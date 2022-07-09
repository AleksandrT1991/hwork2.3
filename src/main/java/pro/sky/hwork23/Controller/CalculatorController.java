package pro.sky.hwork23.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hwork23.Service.CalculatorService;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
    public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return calculatorService.greetings();
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer  a,
                       @RequestParam(value = "num2", required = false) Integer b) {
        if (Objects.isNull(a)|| Objects.isNull(b))
            return "Не правильно переданы данные!";
        return buildString(a, b, (Integer) calculatorService.plus(a, b), "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer  a,
                        @RequestParam(value = "num2", required = false) Integer  b) {
        if (Objects.isNull(a)|| Objects.isNull(b))
            return "Не правильно переданы данные!";
        return buildString(a, b, (Integer) calculatorService.minus(a, b), "-");
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer  a,
                           @RequestParam(value = "num2", required = false) Integer  b) {
        if (Objects.isNull(a)|| Objects.isNull(b))
            return "Не правильно переданы данные!";
        return buildString(a, b, (Integer) calculatorService.multiply(a, b), "*");
    }
    @GetMapping("/divide")
    public String devide(@RequestParam(value = "num1", required = false) Integer  a,
                         @RequestParam(value = "num2", required = false) Integer  b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не правильно переданы данные!";
    }
        return buildString(a, b, (Integer) calculatorService.divide(a, b), "/");

    }

    public String buildString(Integer a, Integer b, Integer result, String operation) {
        return String.format("%.1f %s %.1f = %.1f", a, operation, b, result);
    }
}

