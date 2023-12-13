package com.jacaranda.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.calculadora.model.Calculadora;
import com.jacaranda.calculadora.model.CalculadoraPotencia;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CalculadoraController {
	
	@GetMapping("/calculadora")
	public String calculadora(Model model) {
		Calculadora calculator = new Calculadora();
		CalculadoraPotencia calculatorP = new CalculadoraPotencia();
		
		model.addAttribute("calc", calculator);
		model.addAttribute("calcP", calculatorP);
		return "calculadora";
	}
	
	@GetMapping("/resolver")
	public String resolver(Model model, @ModelAttribute("calc") Calculadora calculadoraUser){
		Calculadora calculator = new Calculadora();
		CalculadoraPotencia calculatorP = new CalculadoraPotencia();
		model.addAttribute("calc", calculator);
		model.addAttribute("calcP", calculatorP);
		String result;
		try {
			result = "Operación anterior: " + calculadoraUser.getNum1() + calculadoraUser.getOpe() + calculadoraUser.getNum2() + "=" + calculadoraUser.resolve();
		} catch (Exception e) {
			result = e.getMessage();
		}
		
		model.addAttribute("result", result);
		
		return "calculadora";
	}
	
	@GetMapping("/resolverPotencia")
	public String resolverPotencia(Model model,@Validated  @ModelAttribute("calcP") CalculadoraPotencia calculadoraPotencia, BindingResult bindinResult){
		CalculadoraPotencia calculatorP = new CalculadoraPotencia();
		Calculadora calculator = new Calculadora();
		model.addAttribute("calc", calculator);
		if(bindinResult.hasErrors()) {
			model.addAttribute("resultP", "Error al operar");
			return "calculadora";
		}
		model.addAttribute("calcP", calculatorP);
		String result = calculadoraPotencia.getResult();
		
		model.addAttribute("resultP", result);
		
		return "calculadora";
		
	}
	
}
