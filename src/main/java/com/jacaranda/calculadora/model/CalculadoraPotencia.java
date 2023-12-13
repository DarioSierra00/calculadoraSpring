package com.jacaranda.calculadora.model;

import jakarta.validation.constraints.NotNull;

public class CalculadoraPotencia {
	
	@NotNull
	private double voltios;
	private double amperios;
	
	public String getResult() {
		return String.format("El voltaje es %s, su amperaje %s y la potencia es %s W", this.voltios,this.amperios,calculate());
	}
	
	public double calculate() {
		return this.amperios*this.voltios;
	}

	public double getVoltios() {
		return voltios;
	}

	public void setVoltios(double voltios) throws Exception {
		try {
			this.voltios = voltios;
		} catch (Exception e) {
			throw new Exception("Debe ser un numero");
		}
	}

	public double getAmperios() {
		return amperios;
	}

	public void setAmperios(double amperios) throws Exception {
		try {
			this.amperios = amperios;
		} catch (Exception e) {
			throw new Exception("Debe ser un numero");
		}
	}
	
}
