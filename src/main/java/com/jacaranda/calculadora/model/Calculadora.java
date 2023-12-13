package com.jacaranda.calculadora.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class Calculadora {
	
	@NotNull
	private double num1;
	@NotNull
	private double num2;
	private char ope;
	
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public char getOpe() {
		return ope;
	}
	public void setOpe(char ope) {
		this.ope = ope;
	}
	
	public double resolve() throws Exception {
		double result = 0.0;
		
		if(this.ope == '+') {
			result = this.num1+this.num2;
		}
		else if(this.ope == '-') {
			result = this.num1-this.num2;
		}
		else if(this.ope == '*') {
			result = this.num1*this.num2;
		}
		else if(this.ope == '/') {
			result = this.num1/this.num2;
		}
		else {
			throw new Exception("No existe ese operador");
		}
		
		return result;
	}
	@Override
	public int hashCode() {
		return Objects.hash(num1, num2, ope);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculadora other = (Calculadora) obj;
		return Double.doubleToLongBits(num1) == Double.doubleToLongBits(other.num1)
				&& Double.doubleToLongBits(num2) == Double.doubleToLongBits(other.num2) && ope == other.ope;
	}
	
	
}
