package com.etejk.vallytool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etejk.vallytool.dao.ResultadoDAO;
import com.etejk.vallytool.entities.Resultado;
import com.etejk.vallytool.repositories.ResultadoRepository;

@RestController
public class ResultadoController {
	
	@Autowired
	public ResultadoRepository rr;

	@PostMapping("/avaliar")
	public void avaliar(ResultadoDAO resultado) {
		System.out.println(resultado);
		Resultado resultado2 = resultado.toResultado();
		System.out.println(resultado2.getDisciplina().getNome());
	}
}
