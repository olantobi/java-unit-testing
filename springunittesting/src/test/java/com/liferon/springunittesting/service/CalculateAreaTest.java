package com.liferon.springunittesting.service;

import com.liferon.springunittesting.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CalculateAreaTest {
    @Spy
    private RectangleService rectangleService;
    @Mock
    private SquareService squareService;
    @Mock
    private CircleService circleService;

    @InjectMocks
    private CalculateArea calculateArea;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateRectangleAreaTest()
    {
        Mockito.doCallRealMethod().when(rectangleService).log();
        Mockito.when(rectangleService.area(5.0, 4.0)).thenReturn(20d);
        Double calculatedArea = this.calculateArea.calculateArea(Type.RECTANGLE, 5.0, 4.0);
        Assert.assertEquals(new Double(20.0), calculatedArea);
    }

    @Test
    public void calculateSquareAreaTest()
    {
        Mockito.when(squareService.area(5.0)).thenReturn(25.0);
        Double calculatedArea = this.calculateArea.calculateArea(Type.SQUARE, 5.0);
        Assert.assertEquals(new Double(25.0), calculatedArea);
    }

    @Test
    public void calculateCircleAreaTest()
    {
        Mockito.when(circleService.area(7.0)).thenReturn(153.93804002589985);
        Double calculatedArea = this.calculateArea.calculateArea(Type.CIRCLE, 7.0);
        Assert.assertEquals(new Double(153.93804002589985), calculatedArea);
    }
}
