/**
 * 
 */
package com.example.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.Controller.CalculatorController;
import com.example.demo.response.CalculatorResponse;
import com.example.demo.response.MinMaxResponse;
import com.example.demo.service.CalculatorService;

/**
 * 
 */
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CalculatorService calculatorService;
	
	@Mock
	private CalculatorResponse calculatorResponse;
	
	@Mock
	MinMaxResponse minMaxResponse;
	
	@Test
	public void testDoAddition() throws Exception
	{
		when(calculatorService.doAddition(5, 3)).thenReturn(8.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("8");
		when(calculatorResponse.getDetails()).thenReturn("5 + 3 = 8");
		
		mockMvc.perform(get("/calculatorapi/v1/addition")
						.param("number1","5")
						.param("number2", "3")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"8\",\"details\":\"5 + 3 = 8\"}"));
	}
	
	@Test
	public void testDosubtraction() throws Exception
	{
		when(calculatorService.doSubtraction(5, 3)).thenReturn(2.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("2.0");
		when(calculatorResponse.getDetails()).thenReturn("5 - 3 = 2");
		
		mockMvc.perform(get("/calculatorapi/v1/subtraction")
						.param("number1","5")
						.param("number2", "3")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"2\",\"details\":\"5 - 3 = 2\"}"));
	}
	
	
	@Test
	public void testDoDivistion() throws Exception
	{
		when(calculatorService.doDivision(6, 3)).thenReturn(calculatorResponse);
		
		when(calculatorResponse.getAnswer()).thenReturn("2");
		when(calculatorResponse.getDetails()).thenReturn("6 / 3 = 2");
		
		mockMvc.perform(get("/calculatorapi/v1/division")
						.param("number1","6")
						.param("number2", "3")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"2\",\"details\":\"6 / 3 = 2\"}"));
	}
	
	@Test
	public void testGetSquare() throws Exception
	{
		when(calculatorService.getSquare(3)).thenReturn(9.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("9");
		when(calculatorResponse.getDetails()).thenReturn("square of 3 = 9");
		
		mockMvc.perform(get("/calculatorapi/v1/square")
						.param("number1","6")
						.param("number2", "3")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"9\",\"details\":\"square of 3 = 9\"}"));
	}
	
	@Test
	public void testGetSquareRoot() throws Exception
	{
		when(calculatorService.getSquareRoot(9)).thenReturn(3.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("3");
		when(calculatorResponse.getDetails()).thenReturn("square root of 9 = 3");
		
		mockMvc.perform(get("/calculatorapi/v1/squareRoot")
						.param("number1","6")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"3\",\"details\":\"square of 9 = 3\"}"));
	}
	
	@Test
	public void testGetFactorial() throws Exception
	{
		when(calculatorService.getFactorial(9)).thenReturn(3.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("5");
		when(calculatorResponse.getDetails()).thenReturn("5! = 120");
		
		mockMvc.perform(get("/calculatorapi/v1/factorial")
						.param("number1","5")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"5\",\"details\":\"5! = 120\"}"));
	}
	
	@Test
	public void testGetMinMax() throws Exception
	{
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		when(calculatorService.getMin(numbers)).thenReturn(1);
		when(calculatorService.getMax(numbers)).thenReturn(3);
		
		when(minMaxResponse.getMin()).thenReturn("1");
		when(minMaxResponse.getMax()).thenReturn("3");
		
		mockMvc.perform(get("/calculatorapi/v1/minmax")
						.param("number1","1,2,3")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"min\":\"1\",\"max\":\"3\"}"));
	}
	
	


}
