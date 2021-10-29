package com.unicesumar.adsis4s2021.dozero.televisao;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Televisao {
	
	@Id
	private String id;
	private String marca;
	private String modelo;
	private int polegada;
	
	public Televisao() {
		id = UUID.randomUUID().toString();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPolegada() {
		return polegada;
	}

	public void setPolegada(int polegada) {
		this.polegada = polegada;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Televisao other = (Televisao) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
