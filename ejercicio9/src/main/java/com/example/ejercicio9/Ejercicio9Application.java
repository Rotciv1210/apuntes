package com.example.ejercicio9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*Crea una aplicación con Spring Boot que, de una lista de clientes de la base de datos,
se capaz de renderizarlos en un desplegable a través de thymeleaf.
Cuando se seleccione el cliente del desplegable se debería enviar a otra vista a través de atributos de redirección.
En esta otra vista mostrarás algunos datos del cliente
(los que tu quieras, podrían ser el id, el nombre y su email)*/
@SpringBootApplication
public class Ejercicio9Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio9Application.class, args);
	}
}
