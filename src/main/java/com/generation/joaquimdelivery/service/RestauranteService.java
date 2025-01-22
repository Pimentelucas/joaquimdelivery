package com.generation.joaquimdelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.joaquimdelivery.model.RestauranteModel;
import com.generation.joaquimdelivery.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	public Optional<List<RestauranteModel>> getBySaudavel() {
			
		return Optional.ofNullable(restauranteRepository.findAllBySaudavel(true)); 
	}
}
