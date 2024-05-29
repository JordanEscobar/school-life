package com.schoollife.web.Dto;

//Devuelve información con Token y tipo de este.
public class DtoAuthRespuesta {
	
	private String accessToken;
	private String tokenType= "Bearer";
	
	public DtoAuthRespuesta(String accessToken) {
		super();
		this.accessToken = accessToken;
	}
	
}
