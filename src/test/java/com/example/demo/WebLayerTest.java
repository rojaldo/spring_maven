package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.greeting.GreetingController;

@WebMvcTest(GreetingController.class)
@AutoConfigureMockMvc
//tag::test[]
public class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		// this.mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
	}

	@Disabled
	public void shouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/greet")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("hola clase!")));
	}
}
//end::test[]