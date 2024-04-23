package com.schoollife.classbook.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public String loginPrueba(String username, String pass) {
		String usuario = "";
		if(username.equalsIgnoreCase("administrador") && pass.equalsIgnoreCase("1234")) {
			usuario = "admin";
		}else if(username.equalsIgnoreCase("profesor") && pass.equalsIgnoreCase("1234")) {
			usuario = "profe";
		}else {
			usuario = "usuario_invalido";
		}
		
		return usuario;
		
	}
	


}
