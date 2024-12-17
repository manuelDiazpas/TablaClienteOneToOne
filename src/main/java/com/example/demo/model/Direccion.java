package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "calle", nullable = false)
	private String calle;

	@Column(name = "ciudad", nullable = false)
	private String ciudad;

	public Direccion() {
		super();
	}

	public Direccion(Integer id, String calle, String ciudad) {
		super();
		this.id = id;
		this.calle = calle;
		this.ciudad = ciudad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Direccion [getId()=" + getId() + ", getCalle()=" + getCalle() + ", getCiudad()=" + getCiudad() + "]";
	}

}
