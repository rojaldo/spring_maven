package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    double calculate(double num1, double num2, String op) {
        switch (op) {
            case "sum":
                return num1 + num2;
            case "sub":
                return num1 - num2;
            case "mul":
                return num1 * num2;
            case "div":
                return num1 / num2;
            default:
                return 0;
        }
    }

    String encode(String op) {
        switch (op) {
            case "sum":
                return "+";
            case "sub":
                return "-";
            case "mul":
                return "*";
            case "div":
                return "/";
            default:
                return "";
        }
    }
    
}
