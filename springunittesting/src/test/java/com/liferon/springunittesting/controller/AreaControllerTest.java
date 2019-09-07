package com.liferon.springunittesting.controller;

import com.liferon.springunittesting.Type;
import com.liferon.springunittesting.service.CalculateArea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// @RunWith(MockitoJUnitRunner.class)
public class AreaControllerTest {

    @Mock
    private CalculateArea calculateArea;

    @InjectMocks
    private AreaController areaController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateAreaTestMethod()
    {
        Mockito
            .when(calculateArea.calculateArea(Type.RECTANGLE, 5.0, 4.0))
            .thenReturn(20.0);

        ResponseEntity responseEntity = areaController.calculateArea("RECTANGLE", "5", "4");
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(20.0,responseEntity.getBody());
    }
}
