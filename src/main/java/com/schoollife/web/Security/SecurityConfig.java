package com.schoollife.web.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
		super();
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
	}
	
	
	//este bean se encarga de verificar la informacion de los usuarios que se logeen a nuestro Proyecto
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//Con este bean nos encargaremos de encriptar todas las contraseñas
	@Bean
	PasswordEncoder  passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//incorpora el filtro de seguridad relacionado con el token
	@Bean
	JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	//DEPRECADO
	//Establece una cadena de filtros de seguridad en el proyecto, permisos segun rol
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.exceptionHandling()//permitir manejo de excepciones
		.authenticationEntryPoint(jwtAuthenticationEntryPoint)
		.and()
		.sessionManagement()//permitir gestion de sesiones
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/registro","/registrar","/css/**","/js/**","/img/**","https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css","https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js","https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout()
		.permitAll()
		.and()
		.httpBasic();
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
		
}
