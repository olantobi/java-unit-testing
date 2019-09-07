package com.liferon.springunittesting.controller;

import com.liferon.springunittesting.Type;
import com.liferon.springunittesting.service.CalculateArea;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class AreaControllerApiTest {
    @Mock
    private CalculateArea calculateArea;

    @InjectMocks
    private AreaController areaController;

    private MockMvc mockMvc;

    @Before
    public void init()
    {
        mockMvc = standaloneSetup(areaController).build();
    }

    @Test
    public void calculateAreaTest() throws Exception {
        Mockito
            .when(calculateArea.calculateArea(Type.RECTANGLE, 5.0d, 4.0d))
            .thenReturn(20d);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/area?type=RECTANGLE&param1=5&param2=4")
                       )
               .andExpect(status().isOk())
               .andExpect(content().string("20.0"));
    }

}
