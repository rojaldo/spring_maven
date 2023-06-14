package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.library.users.UserDto;
import com.example.demo.library.users.UsersRestController;
import com.example.demo.library.users.UsersService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersRestController.class)
public class UserControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersService service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {

        List<UserDto> users = new ArrayList<UserDto>();
        when(service.getAllUsers()).thenReturn(users);

        this.mockMvc.perform(get("/api/v1/users")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    // check that I get user info after I create a user
    @Test
    public void AddUser() throws Exception {
        UserDto user = UserDto.builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .dniStr("12345678A")
                .email("uno@cualquiera.com")
                .build();
        when (service.createUser(user)).thenReturn(user);
        // this.mockMvc.perform(post("/api/v1/users").content(asJsonString(user))).andDo(print()).andExpect(status().is(201));
    }

}
