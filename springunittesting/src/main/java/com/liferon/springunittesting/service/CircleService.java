package com.liferon.springunittesting.service;

import org.springframework.stereotype.Service;

@Service
public class CircleService {

    public Double area(Double r) {
        return Math.PI * r * r;
    }
}
