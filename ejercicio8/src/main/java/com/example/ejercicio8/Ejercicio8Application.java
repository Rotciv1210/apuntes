package com.example.ejercicio8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* Crea una aplicación con Spring Boot que devuelva el salario neto de un empleado en un JSON pasando el salario bruto

y el % de  IRPF que se le descuenta por la URL.

Ejemplo : http://localohst:8080/19000/10

descuento = salario bruto *  irpf / 100
salario neto = salario bruto  - descuento

el JSON a devolver para el ejemplo :
{
       salario : 1710
}*/
@SpringBootApplication
public class Ejercicio8Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio8Application.class, args);
	}

}
