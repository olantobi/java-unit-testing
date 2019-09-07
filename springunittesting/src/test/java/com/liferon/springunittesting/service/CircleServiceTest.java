package com.liferon.springunittesting.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircleServiceTest {

    private CircleService circleService;

    @Before
    public void init() {
        circleService = new CircleService();
    }

    @Test
    public void testArea() {
        Double calculatedArea = this.circleService.area(7.0);
        Assert.assertEquals(new Double(153.93804002589985), calculatedArea);

    }
}
