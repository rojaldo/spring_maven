package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.calculator.CalculatorService;

@SpringBootTest
public class CalculatorServiceUnitTests {
    
    //inject service here
    @Autowired
    private CalculatorService calculatorService;

    //test methods here
    @Test
    public void testAdd() {
        //test add method
        assertEquals(5, calculatorService.calculate(1, 4, "sum"));
    }
    
}
