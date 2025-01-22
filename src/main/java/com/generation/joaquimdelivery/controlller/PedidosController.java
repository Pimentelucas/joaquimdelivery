package com.generation.joaquimdelivery.controlller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.joaquimdelivery.model.PedidoModel;
import com.generation.joaquimdelivery.repository.PedidosRepository;
import com.generation.joaquimdelivery.repository.RestauranteRepository;
import com.generation.joaquimdelivery.service.PedidoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidosController {

	@Autowired
	private PedidosRepository pedidosRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<PedidoModel>> getAll(){
		return ResponseEntity.ok(pedidosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoModel> getById(@PathVariable Long id) {
		return pedidosRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<PedidoModel>> getByProduto(@PathVariable String titulo) {
		return ResponseEntity.ok(pedidosRepository.findAllByProdutoContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<PedidoModel> post(@Valid @RequestBody PedidoModel pedido){
		if (restauranteRepository.existsById(pedido.getRestaurante().getId())) {
			
			pedidoService.recomendarSaudavel(pedido);
			
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidosRepository.save(pedido));	
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping
	public ResponseEntity<PedidoModel> put(@Valid @RequestBody PedidoModel pedido) {
		return pedidosRepository.findById(pedido.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
					.body(pedidosRepository.save(pedido)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<PedidoModel> pedidos = pedidosRepository.findById(id);
		
		if(pedidos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
			pedidosRepository.deleteById(id);
	}
	

	
}
