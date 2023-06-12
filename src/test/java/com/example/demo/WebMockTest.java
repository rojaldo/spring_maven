package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.calculator.CalculatorController;
import com.example.demo.calculator.CalculatorService;

@WebMvcTest(CalculatorController.class)
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalculatorService service;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(service.eval("1+2=")).thenReturn("1+2=3");
		this.mockMvc.perform(get("/eval?operation=1+2=")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("1+2=3")));
	}
}
