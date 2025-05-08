package com.example.ejercicio7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*Crea una aplicación con Spring Boot que sirva para hacer Log In de un usuario. Pasa el email a través de un query string.
 Si el email es "pepe@es.es" devolver un JSON con clave "success"  y
  valor "usuario válido" , caso contrario, clave  "error" valor  "Usuario no válido"*/
@SpringBootApplication
public class Ejercicio7Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio7Application.class, args);
	}

}
