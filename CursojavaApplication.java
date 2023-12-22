package com.redsoft.cursojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redsoft.cursojava.servicio.UsuarioService;

@SpringBootApplication
public class CursojavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursojavaApplication.class, args);
		System.out.println("HOLAAA");
		UsuarioService usr1 = new UsuarioService();
		usr1.getUsuarios();
	}

}
