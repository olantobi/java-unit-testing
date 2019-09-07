package com.liferon.javaunittest.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SquareServiceTest {
    private SquareService squareService;

    @Before
    public void init() {
        squareService = new SquareService();
    }

    @Test
    public void testArea() {
        Double calculatedArea = this.squareService.area(5.0);
        Assert.assertEquals(new Double(25.0), calculatedArea);

    }
}
