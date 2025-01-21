package com.generation.joaquimdelivery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.joaquimdelivery.model.UsuarioModel;
import com.generation.joaquimdelivery.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<UsuarioModel> cadastrarUsuario(UsuarioModel usuario) {

		if (usuarioRepository.findById(usuario.getId()).isPresent())
			return Optional.empty();

		return Optional.of(usuarioRepository.save(usuario));
	
	}
	
	public Optional<UsuarioModel> atualizarUsuario(UsuarioModel usuario) {
		
		if(usuarioRepository.findById(usuario.getId()).isPresent()) {

			Optional<UsuarioModel> buscaUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

			if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

			return Optional.ofNullable(usuarioRepository.save(usuario));
			
		}

		return Optional.empty();
	
	}	

	public boolean deletarUsuario(Long id) {
		Optional<UsuarioModel> buscaUsuario = usuarioRepository.findById(id);
		
		if (buscaUsuario.isEmpty())
			return false;
		usuarioRepository.deleteById(id);
		return true;
	}
}
