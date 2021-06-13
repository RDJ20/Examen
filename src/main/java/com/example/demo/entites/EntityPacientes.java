package com.example.demo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class EntityPacientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(name = "nombre1")
	private String nombre1;
	
	@Column(name = "nombre2")
	private String nombre2;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	
	@Column(name = "edad")
	private int edad;
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
		}
	public String getNombre2() {
		return nombre2;
		}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellido) {
		this.apellidos = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
