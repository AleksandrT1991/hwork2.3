package pro.sky.hwork23.Service;

import org.springframework.stereotype.Service;
import pro.sky.hwork23.exception.DivideByZeroException;

@Service
    public class CalculatorService {

    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    public Number plus(Integer a, Integer b) {
        return a + b;

    }
    public Number minus(Integer a, Integer b) {
        return a - b;

    }
    public Number multiply(Integer a, Integer b) {
        return  a * b;
    }
    public Number divide(Integer a, Integer b) {
        if (b == 0) {
            throw new DivideByZeroException("Делить на ноль нельзя!");
        }
        return  a / b;
    }


}
