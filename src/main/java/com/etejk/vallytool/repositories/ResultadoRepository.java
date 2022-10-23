package com.etejk.vallytool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etejk.vallytool.entities.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer>{
	
}