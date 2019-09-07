package com.liferon.javaunittest;

import com.liferon.javaunittest.service.CalculateArea;
import com.liferon.javaunittest.service.CircleService;
import com.liferon.javaunittest.service.RectangleService;
import com.liferon.javaunittest.service.SquareService;

public class JavaUnitTestApplicaton {

    public static void main(String[] args) {
        System.out.printf("We are starting out...");
        RectangleService rectangleService = new RectangleService();
        SquareService squareService = new SquareService();
        CircleService circleService = new CircleService();

        CalculateArea calculator = new CalculateArea(rectangleService, squareService, circleService);
        Double area = calculator.calculateArea(Type.CIRCLE, 7d);

        System.out.println(area);
    }
}
