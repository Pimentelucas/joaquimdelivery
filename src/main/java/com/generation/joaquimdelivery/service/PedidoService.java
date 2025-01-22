package com.generation.joaquimdelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.generation.joaquimdelivery.model.PedidoModel;
import com.generation.joaquimdelivery.repository.PedidosRepository;

public class PedidoService {

	@Autowired
	PedidosRepository pedidosRepository;
	public String recomendarSaudavel(PedidoModel pedido) {
		if(pedidosRepository.findById(pedido.getId()).isPresent()) {
			if(pedido.getRestaurante().getSaudavel()) 
				return null;
			return "Pede saudavel aí po";
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
}
