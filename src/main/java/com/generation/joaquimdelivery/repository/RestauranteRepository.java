package com.generation.joaquimdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.joaquimdelivery.model.RestauranteModel;

public interface RestauranteRepository extends JpaRepository<RestauranteModel,Long>{

	public List<RestauranteModel> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);	
	
	public List<RestauranteModel> findAllBySaudavel(@Param("saudavel")boolean saudavel);	
	
}
