package com.etejk.vallytool.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.etejk.vallytool.dao.UsuarioDAO;
import com.etejk.vallytool.entities.RoleModel;
import com.etejk.vallytool.entities.RoleName;
import com.etejk.vallytool.entities.Usuario;
import com.etejk.vallytool.repositories.RoleRepository;
import com.etejk.vallytool.repositories.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository ur;
	
	@Autowired
	RoleRepository rr;
	
	@PostMapping("usuario")
	public String saveUsuario(UsuarioDAO usuarioDAO) {
		System.out.println(usuarioDAO);
		
		
		List<RoleModel> findAllRoles = rr.findAll();
		List<RoleModel> roles = new ArrayList<>();
		for (RoleModel role : findAllRoles) {
			if(role.getRoleName().name().equals(usuarioDAO.getRole())) {
				roles.add(role);
			}
		}
		
		System.out.println(roles.get(0).getRoleName().name());
		
		Usuario usuarioOriginal = new Usuario(
				usuarioDAO.getCpf().replace(".", "").replace("-", ""),
				usuarioDAO.getNome(),
				usuarioDAO.getEmail(),
				usuarioDAO.senha(),
				roles
				);
		
		ur.save(usuarioOriginal);
		return "redirect:/inicio";
	}
	
	@GetMapping("inicio")
	public String inicio(Model model, @Param("search") String search) {
		if(search != null) {
			model.addAttribute("usuarios", ur.search(search));
		}else {
		model.addAttribute("usuarios", ur.findAll());
		}
		
		return "site/inicio";
	}
}
