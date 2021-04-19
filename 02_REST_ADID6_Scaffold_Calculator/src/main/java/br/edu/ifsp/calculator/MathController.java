package br.edu.ifsp.calculator;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.calculator.exception.UnsuportedMathOperationException;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	
	private static AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		return sum;
	}
	
	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		
		return sub;
	}
	
	@RequestMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
		
		return mult;
	}
	
	@RequestMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		
		return div;
	}
	
	@RequestMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		Double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		
		return mean;
	}
	
	@RequestMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		
		if(!isNumeric(number)) {
			throw new UnsuportedMathOperationException("Por favor entre com um valor numérico!");
		}
		
		Double squareRoot = (Double) Math.sqrt(convertToDouble(number));
		
		return squareRoot;
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		
		String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	
	
}
