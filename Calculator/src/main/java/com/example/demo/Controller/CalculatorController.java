/**
 * 
 */
package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.MinMaxRequest;
import com.example.demo.response.CalculatorResponse;
import com.example.demo.response.MinMaxResponse;
import com.example.demo.service.CalculatorService;
import com.example.demo.util.Util;

/**
 * 
 */

@RestController
@RequestMapping(value = "/calculatorapi/v1")
@ComponentScan(basePackages = "com.example.demo")
public class CalculatorController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping(value = "/addition")
	public CalculatorResponse getAddition(@RequestParam double number1, @RequestParam double number2) {
		
		CalculatorResponse calculatorResponse = new CalculatorResponse(); 
		double addition = calculatorService.doAddition(number1, number2);
		calculatorResponse.setAnswer(Util.getFormattedString(addition));
		calculatorResponse.setDetails(Util.getFormattedString(number1)+" + "+ 
				Util.getFormattedString(number2)+" = " +Util.getFormattedString(addition));
		
		return calculatorResponse;
	}
	
	@GetMapping(value = "/subtraction")
	public CalculatorResponse getSubtraction(@RequestParam double number1, @RequestParam double number2) {
		
		CalculatorResponse calculatorResponse = new CalculatorResponse(); 
		double subtraction = calculatorService.doSubtraction(number1, number2);
		calculatorResponse.setAnswer(Util.getFormattedString(subtraction));
		calculatorResponse.setDetails(Util.getFormattedString(number1)+" - "+ 
				Util.getFormattedString(number2)+" = " +Util.getFormattedString(subtraction));
		
		return calculatorResponse;
	}
	
	@GetMapping(value = "/division")
	public CalculatorResponse getDivision(@RequestParam double number1, @RequestParam double number2) {
		
		CalculatorResponse calculatorResponse = new CalculatorResponse(); 
		calculatorResponse = calculatorService.doDivision(number1, number2);
		return calculatorResponse;
	}
	
	@GetMapping(value = "/square")
	public CalculatorResponse getSquare(@RequestParam double number1) {
		
		CalculatorResponse calculatorResponse = new CalculatorResponse(); 
		double square = calculatorService.getSquare(number1);
		calculatorResponse.setAnswer(Util.getFormattedString(square));
		calculatorResponse.setDetails("Square of "+ 
				Util.getFormattedString(number1)+" = " +Util.getFormattedString(square));
		
		return calculatorResponse;
	}
	
	@GetMapping(value = "/squareRoot")
	public CalculatorResponse getSquareRoot(@RequestParam double number1) {
		
		CalculatorResponse calculatorResponse = new CalculatorResponse(); 
		double squareRoot = calculatorService.getSquareRoot(number1);
		calculatorResponse.setAnswer(Util.getFormattedString(squareRoot));
		calculatorResponse.setDetails("Square root of "+ 
				Util.getFormattedString(number1)+" = " +Util.getFormattedString(squareRoot));
		
		return calculatorResponse;
	}
	
	@GetMapping(value = "/factorial")
	public CalculatorResponse getFactorial(@RequestParam double number1) {
		
		CalculatorResponse calculatorResponse = new CalculatorResponse(); 
		double factorial = calculatorService.getFactorial(number1);
		calculatorResponse.setAnswer(Util.getFormattedString(factorial));
		calculatorResponse.setDetails( Util.getFormattedString(number1)+"! = " +Util.getFormattedString(factorial));
		
		return calculatorResponse;
	}
	
	@PostMapping(value = "/minmax")
	public MinMaxResponse getMinMax(@RequestBody MinMaxRequest minMaxRequest) {
		
		MinMaxResponse minMaxResponse = new MinMaxResponse(); 
		ArrayList<Integer> numbers = minMaxRequest.getNumbers();
		Integer min = calculatorService.getMin(numbers);
		minMaxResponse.setMin(Util.getFormattedString(min));
		Integer max = calculatorService.getMax(numbers);
		minMaxResponse.setMax(Util.getFormattedString(max));
		
		return minMaxResponse;
	}
}
