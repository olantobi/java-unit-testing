package com.liferon.springunittesting.service;

import com.liferon.springunittesting.Type;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculateArea {

    private final RectangleService rectangleService;
    private final SquareService squareService;
    private final CircleService circleService;

    public Double calculateArea(Type type, Double... r)
    {
        switch (type)
        {
            case RECTANGLE:
                if(r.length >=2)
                    return rectangleService.area(r[0],r[1]);
                else
                    throw new RuntimeException("Missing required params");
            case SQUARE:
                if(r.length >=1)
                    return squareService.area(r[0]);
                else
                    throw new RuntimeException("Missing required param");

            case CIRCLE:
                if(r.length >=1)
                    return circleService.area(r[0]);
                else
                    throw new RuntimeException("Missing required param");
            default:
                throw new RuntimeException("Operation not supported");
        }
    }
}
