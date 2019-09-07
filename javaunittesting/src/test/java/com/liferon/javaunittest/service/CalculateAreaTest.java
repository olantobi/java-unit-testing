package com.liferon.javaunittest.service;

import com.liferon.javaunittest.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculateAreaTest {
    private RectangleService rectangleService;
    private SquareService squareService;
    private CircleService circleService;

    private CalculateArea calculateArea;

    @Before
    public void init() {
        rectangleService = Mockito.mock(RectangleService.class);
        squareService = Mockito.mock(SquareService.class);
        circleService = Mockito.mock(CircleService.class);

        calculateArea = new CalculateArea(rectangleService, squareService, circleService);
    }

    @Test
    public void calculateRectangleAreaTest()
    {
        Mockito.when(rectangleService.area(5.0,4.0)).thenReturn(20d);
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
