package com.generation.joaquimdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.joaquimdelivery.model.PedidoModel;

public interface PedidosRepository extends JpaRepository<PedidoModel, Long> {

	public List <PedidoModel> findAllByProdutoContainingIgnoreCase(@Param("produto") String produto);
	
}
