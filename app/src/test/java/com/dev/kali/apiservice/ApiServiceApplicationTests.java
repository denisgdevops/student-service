package com.dev.kali.apiservice;

import com.dev.kali.apiservice.controller.ApiController;
import com.dev.kali.apiservice.controller.ApiService;
import com.dev.kali.apiservice.dtos.Students;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApiServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    private MockMvc mockMvc;

    @InjectMocks
    private ApiController apiController;

    @Mock
    private ApiService apiService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    public void testGetStudents() throws Exception {
        // Prepare test data
        List<Students> expectedStudents = new ArrayList<>();
        Students student1 = new Students();
        student1.setId(1);
        student1.setName("Emmanuel Karuonai");
        student1.setSex("Female");
        student1.setAge(38);
        Students student2 = new Students();
        student2.setId(2);
        student2.setName("Swety Kava");
        student2.setSex("Female");
        student2.setAge(15);
        expectedStudents.add(student1);
        expectedStudents.add(student2);

        // Mock the service call and return the test data
        when(apiService.fetchStudents()).thenReturn(expectedStudents);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
