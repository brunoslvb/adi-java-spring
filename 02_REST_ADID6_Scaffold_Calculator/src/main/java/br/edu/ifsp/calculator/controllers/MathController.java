package br.edu.ifsp.calculator.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.calculator.exception.UnsuportedMathOperationException;
import br.edu.ifsp.calculator.service.MathService;
import br.edu.ifsp.calculator.utils.Convert;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	
	private static AtomicLong counter = new AtomicLong();
	
	MathService mathService = new MathService();
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!Convert.isNumeric(numberOne) || !Convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		return mathService.sum(numberOne, numberTwo);
	}
	
	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!Convert.isNumeric(numberOne) || !Convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		return mathService.subtraction(numberOne, numberTwo);
	}
	
	@RequestMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!Convert.isNumeric(numberOne) || !Convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		return multiplication(numberOne, numberTwo);
	}
	
	@RequestMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!Convert.isNumeric(numberOne) || !Convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		return division(numberOne, numberTwo);
	}
	
	@RequestMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!Convert.isNumeric(numberOne) || !Convert.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		return mathService.mean(numberOne, numberTwo);
	}
	
	@RequestMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		
		if(!Convert.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		return mathService.squareRoot(number);
	}
	
}
