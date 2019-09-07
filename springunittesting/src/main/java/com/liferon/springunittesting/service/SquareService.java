package com.liferon.springunittesting.service;

import org.springframework.stereotype.Service;

@Service
public class SquareService {

    public Double area(Double l) {
        return l * l;
    }
}
