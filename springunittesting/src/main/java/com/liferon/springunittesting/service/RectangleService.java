package com.liferon.springunittesting.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RectangleService {
    public Double area(Double l, Double h) {
        log(l, h);
        return l * h;
    }

    public void log(Double... var) {
        System.out.println("Skip this ... " + Arrays.asList(var));
    }
}
