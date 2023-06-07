package com.example.demo.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(
            @RequestParam(name = "num1", required = false, defaultValue = "0") double num1,
            @RequestParam(name = "num2", required = false, defaultValue = "0") double num2,
            @RequestParam(name = "op", required = false, defaultValue = "sum") String op,
            Model model) {
        double result = this.calculatorService.calculate(num1, num2, op);

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("op", this.calculatorService.encode(op));
        model.addAttribute("result", result);
        return "calculator";
    }

    @GetMapping("/eval")
    public String eval(
            @RequestParam(name = "operation", required = false, defaultValue = "1+4=") String eval,
            Model model) {

                String result = calculatorService.eval(eval);
                if (result.equals("ERROR")) {
                    result = eval;
                    model.addAttribute("error", true);
                    model.addAttribute("result", result);
                } else {
                    model.addAttribute("error", false);
                    model.addAttribute("result", result);
                }

        return "eval";
    }
}
