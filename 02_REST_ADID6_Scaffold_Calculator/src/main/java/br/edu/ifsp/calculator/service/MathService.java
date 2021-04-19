package br.edu.ifsp.calculator.service;

import br.edu.ifsp.calculator.utils.Convert;

public class MathService {

	public Double sum(String numberOne, String numberTwo) {
		
		return Convert.convertToDouble(numberOne) + Convert.convertToDouble(numberTwo);
		
	}
	
	public Double subtraction(String numberOne, String numberTwo) {
		
		return Convert.convertToDouble(numberOne) - Convert.convertToDouble(numberTwo);
		
	}

	public Double multiplication(String numberOne, String numberTwo) {
		
		return Convert.convertToDouble(numberOne) * Convert.convertToDouble(numberTwo);
		
	}
	
	public Double division(String numberOne, String numberTwo) {
		
		return Convert.convertToDouble(numberOne) / Convert.convertToDouble(numberTwo);
		
	}
	
	public Double mean(String numberOne, String numberTwo) {
		
		return (Convert.convertToDouble(numberOne) + Convert.convertToDouble(numberTwo)) / 2;
		
	}
	
	public Double squareRoot(String number) {
		
		return (Double) Math.sqrt(Convert.convertToDouble(number));
		
	}
	
}
