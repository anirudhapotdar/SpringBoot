/**
 * 
 */
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

/**
 * 
 */
@Service("calculatorService")
public class CalculatorService {
	
	public double doAddition(double number1, double number2) {
		double addition;
		addition = number1 + number2;
		return addition;
	}
	
	
	public double doSubtraction(double number1, double number2) {
		double subtraction;
		subtraction = number1 - number2;
		return subtraction;
	}
	
	
	public double doDivision(double number1, double number2) {
		double division;
		division = number1 / number2;
		return division;
	}
	
	public double getSquare(double number1) {
		double square;
		square = number1 * number1;
		return square;
	}
	
	public double getSquareRoot(double number1) {
		double squareRoot;
		squareRoot = Math.sqrt(number1);
		return squareRoot;
	}
	
	
	public double getFactorial(double number1) {
		double factorial;
		factorial = factorial(number1);
		return factorial;
	}
	
	static double factorial(double n){    
		  if (n == 0)    
		    return 1;    
		  else    
		    return(n * factorial(n-1));    
		 }    
	
	public Integer getMax(ArrayList<Integer> number1) {
		Integer max = number1
			      .stream()
			      .mapToInt(v -> v)
			      .max().orElseThrow(NoSuchElementException::new);
		return max;
	}
	
	public Integer getMin(ArrayList<Integer> number1) {
		Integer min = number1
			      .stream()
			      .mapToInt(v -> v)
			      .min().orElseThrow(NoSuchElementException::new);
		return min;
	}
	

}
