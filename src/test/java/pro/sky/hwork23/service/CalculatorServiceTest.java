package pro.sky.hwork23.service;


import org.junit.jupiter.api.Test;
import pro.sky.hwork23.Service.CalculatorService;
import pro.sky.hwork23.exception.DivideByZeroException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        Number actual = calculatorService.plus(1, 2);
        assertThat(actual).isEqualTo(3);


        actual = calculatorService.plus(-3, 1);
        assertThat(actual).isEqualTo(-2);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(5, 2);
        assertThat(actual).isEqualTo(3);

        actual = calculatorService.minus(-3, 1);
        assertThat(actual).isEqualTo(-4);
    }
    @Test
    public void multiplyTest() {
        Number actual = calculatorService.multiply(4, 3);
        assertThat(actual).isEqualTo(12);

        actual = calculatorService.multiply(-3, 1);
        assertThat(actual).isEqualTo(-3);
    }
    @Test
    public void divideTest() {
        Number actual = calculatorService.divide(9, 3);
        assertThat(actual).isEqualTo(3);

        actual = calculatorService.divide(-3, 1);
        assertThat(actual).isEqualTo(-3);
    }
    @Test
    public void divideNegativeTest(){
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()-> calculatorService.divide(1,0))
                .withMessage("Делить на ноль нельзя!");

            assertThatExceptionOfType(DivideByZeroException.class)
                    .isThrownBy(()-> calculatorService.divide(-1,0))
                    .withMessage("Делить на ноль нельзя!");
    }
}