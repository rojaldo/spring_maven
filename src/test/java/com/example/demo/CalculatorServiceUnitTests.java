package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.calculator.CalculatorService;

@SpringBootTest
public class CalculatorServiceUnitTests {
    
    //inject service here
    @Autowired
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        // remove calculator data before each test
        calculatorService.clear();
    }

    //test methods here
    @Test
    public void testAdd() {
        //test add method
        assertEquals(5, calculatorService.calculate(1, 4, "sum"));
    }

    @Test
    public void testException() {
        //test that when dividing by zero, I get infinity
        assertEquals(Double.POSITIVE_INFINITY, calculatorService.calculate(1, 0, "div"));
        
    }

    // check that I get NaN when I divide 0 by 0
    @Test
    public void testException2() {
        assertEquals(Double.NaN, calculatorService.calculate(0, 0, "div"));
    }

    // test that I get an IllegalaArgumentException when I try to use an operation that is not supported
    @Test
    public void testWrongOperation() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.calculate(1, 1, "wrong"));
    }
    
}
