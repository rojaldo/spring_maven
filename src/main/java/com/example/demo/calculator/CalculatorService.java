package com.example.demo.calculator;

import org.springframework.stereotype.Service;

enum State {
    INIT, FIRST_FIGURE, SECOND_FIGURE, RESULT, ERROR
}

@Service
public class CalculatorService {

    String resultStr;
    State currentState = State.INIT;
    double num1 = 0;
    double num2 = 0;
    String op = "";
    double result = 0;

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

    double calculateEval(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
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

    String eval(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int num = Character.getNumericValue(str.charAt(i));
                this.processNumber(num);
            } else {
                String st = Character.toString(str.charAt(i));
                this.processSymbol(st);
            }
        }
        if (currentState == State.ERROR) {
            resultStr = "ERROR";
        }
        currentState = State.INIT;
        num1 = 0;
        num2 = 0;
        op = "";
        result = 0;
        return resultStr;
    }

    void processNumber(int num) {
        switch (currentState) {
            case INIT:
                num1 = num;
                currentState = State.FIRST_FIGURE;
                resultStr = Double.toString(num1);
                break;
            case FIRST_FIGURE:
                num1 = num1 * 10 + num;
                resultStr = Double.toString(num1);
                break;
            case SECOND_FIGURE:
                num2 = num2 * 10 + num;
                resultStr = resultStr + Integer.toString(num);
                break;
            case RESULT:
                currentState = State.ERROR;
                break;
            case ERROR:
                break;
        }

    }

    void processSymbol(String st) {
        switch (this.currentState) {
            case INIT:
                currentState = State.ERROR;
                break;
            case FIRST_FIGURE:
                if (st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/")) {
                    op = st;
                    resultStr = resultStr + st;
                    currentState = State.SECOND_FIGURE;
                } else {
                    currentState = State.ERROR;
                }
                break;
            case SECOND_FIGURE:
            if (st.equals("=")) {
                result = calculateEval(num1, num2, op);
                resultStr = resultStr + st + Double.toString(result);
                currentState = State.RESULT;
            } else {
                currentState = State.ERROR;
            }
                break;
            case RESULT:
                currentState = State.ERROR;
                break;
            case ERROR:
                break;
        }

    }

}
