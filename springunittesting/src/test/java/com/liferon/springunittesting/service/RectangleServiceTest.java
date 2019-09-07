package com.liferon.springunittesting.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleServiceTest {

    private RectangleService rectangleService;

    @Before
    public void init() {
        rectangleService = new RectangleService();
    }

    @Test
    public void testArea() {
        Double calculatedArea = this.rectangleService.area(5.0, 4.0);
        Assert.assertEquals(new Double(20), calculatedArea);
    }
}
