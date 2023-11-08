/**
 * 
 */
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.DefaultRowSorter;

import org.springframework.stereotype.Service;

import com.example.demo.response.CalculatorResponse;
import com.example.demo.util.Util;

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
	
	
	public CalculatorResponse doDivision(double number1, double number2) throws ArithmeticException {
		double division;
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		try {
			if(number2 == 0) {
				throw new ArithmeticException();
			} else {
				division = number1 / number2;
				calculatorResponse.setAnswer(Util.getFormattedString(division));
				calculatorResponse.setDetails(Util.getFormattedString(number1)+" / "+ 
						Util.getFormattedString(number2)+" = " +Util.getFormattedString(division));
			}
		} catch(ArithmeticException e) {
			e.printStackTrace();
			calculatorResponse.setAnswer("undefined");
			calculatorResponse.setDetails("number2 should not be zero");
		}
		
		return calculatorResponse;
		
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
