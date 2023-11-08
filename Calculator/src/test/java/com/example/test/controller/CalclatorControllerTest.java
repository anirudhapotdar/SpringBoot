/**
 * 
 */
package com.example.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.Controller.CalculatorController;
import com.example.demo.response.CalculatorResponse;
import com.example.demo.service.CalculatorService;

/**
 * 
 */
@WebMvcTest(CalculatorController.class)
public class CalclatorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CalculatorService calculatorService;
	
	@Mock
	private CalculatorResponse calculatorResponse;
	
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

}
