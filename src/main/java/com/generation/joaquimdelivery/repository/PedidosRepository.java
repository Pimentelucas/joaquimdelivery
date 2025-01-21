package com.generation.joaquimdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.joaquimdelivery.model.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

	public List <Pedidos> findAllByProdutoContainingIgnoreCase(@Param("produto") String produto);
	
}
