package com.jacaranda.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jacaranda.calculadora.model.Calculadora;

@Controller
public class CalculadoraController {
	
	@GetMapping("/calculadora")
	public String calculadora(Model model) {
		Calculadora calculator = new Calculadora();
		
		model.addAttribute("calc", calculator);
		return "calculadora";
	}
	
	@GetMapping("/resolver")
	public String resolver(Model model, @ModelAttribute("calc") Calculadora calculadoraUser){
		Calculadora calculator = new Calculadora();
		model.addAttribute("calc", calculator);
		String result;
		try {
			result = "Operación anterior: " + calculadoraUser.getNum1() + calculadoraUser.getOpe() + calculadoraUser.getNum2() + "=" + calculadoraUser.resolve();
		} catch (Exception e) {
			result = e.getMessage();
		}
		
		model.addAttribute("result", result);
		
		return "calculadora";
	}
}
