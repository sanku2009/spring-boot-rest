package com.javacodegeeks.example;

import com.javacodegeeks.example.controller.PersonController;
import com.javacodegeeks.example.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PersonController controller;

    @Mock
    private PersonRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new PersonController(repository);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllPerson_Pass() throws Exception {
        mockMvc.perform(
                get("/all"))
                .andExpect(status().is2xxSuccessful());
    }
}
