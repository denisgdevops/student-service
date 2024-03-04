package com.dev.kali.apiservice;

import com.dev.kali.apiservice.controller.ApiController;
import com.dev.kali.apiservice.dtos.Students;
import com.dev.kali.apiservice.model.Tutorial;
import com.dev.kali.apiservice.repository.TutorialRepository;
import com.dev.kali.apiservice.service.ApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApiServiceApplicationTests {

    @Test
    void contextLoads() {
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
    }

    private MockMvc mockMvc;

    @InjectMocks
    private ApiController apiController;

    @Mock
    private ApiService apiService;

    @Mock
    private TutorialRepository tutorialRepository;

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


    @Test
    public void testFetchTutorials_SpecificTitle() {

        List<Tutorial> tutorialsTitle = setTutorialTitleData();

        Mockito.when(apiService.fetchTutorialsByTittle("Power Apps Class")).thenReturn(tutorialsTitle);
        assertEquals(tutorialsTitle,apiService.fetchTutorialsByTittle("Power Apps Class"));

    }

    @Test
    public void testFetchTutorials_AllData() {

        List<Tutorial> tutorials = setTutorialData();
        Mockito.when(tutorialRepository.findAll()).thenReturn(tutorials);
        // Mock the service call and return the test data
        when(apiService.fetchTutorials()).thenReturn(tutorials);
        assertEquals(apiService.fetchTutorials(),tutorialRepository.findAll());

    }


    public  List<Tutorial> setTutorialTitleData() {
        List<Tutorial> tutorials = new ArrayList<>();
        Tutorial tutorial1 = new Tutorial();
        tutorial1.setId(1);
        tutorial1.setTitle("Powerapps");
        tutorial1.setDescription("Power Apps class is fun");
        tutorial1.setPublished(true);
        tutorials.add(tutorial1);
        return tutorials;

    }


    public  List<Tutorial> setTutorialData() {
        List<Tutorial> tutorials = new ArrayList<>();
        Tutorial tutorial1 = new Tutorial();
        tutorial1.setId(1);
        tutorial1.setTitle("Powerapps");
        tutorial1.setDescription("Power Apps class is fun");
        tutorial1.setPublished(true);
        tutorials.add(tutorial1);

        Tutorial tutorial2 = new Tutorial();
        tutorial2.setId(2);
        tutorial2.setTitle("Copilot");
        tutorial2.setDescription("Copilot automates work");
        tutorial2.setPublished(false);
        tutorials.add(tutorial2);

        return tutorials;

    }



}
