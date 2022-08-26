package br.com.roger;

//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.roger.converter.NumberConverter;
import br.com.roger.exceptions.UnsupportedMathOperationException;
import br.com.roger.math.SimpleMath;

@RestController
public class MathController {
	
	//private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value ="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value ="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@RequestMapping(value ="/multiply/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiply(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.multiply(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value ="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value ="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value ="/sqrt/{numberOne}", method=RequestMethod.GET)
	public Double sqrt(
			@PathVariable(value = "numberOne")String numberOne			
			) throws Exception {
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return math.sqrt(NumberConverter.convertToDouble(numberOne));
	}
	

	
	
}
