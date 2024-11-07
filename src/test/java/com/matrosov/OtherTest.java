package com.matrosov;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OtherTest {
    static Object[][] provideNumbersForAddition() {
        return new Object[][]{
                {1, 2, 3},
                {5, 3, 8},
                {7, -3, 4},
                {-2, -3, -5}
        };
    }

    static Object[][] notProvideNumbersForAddition() {
        return new Object[][]{
                {1, 2, 6},
                {5, 3, 5},
                {7, -3, -1},
                {-2, -3, -523}
        };
    }

    public int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }


    @ParameterizedTest
    @MethodSource("com.matrosov.OtherTest#provideNumbersForAddition")
    void accessProvideNumbersForAddition(Integer i1, Integer i2, Integer result) {
        assertThat(result).isEqualTo(i1 + i2);
    }

    @ParameterizedTest
    @MethodSource("com.matrosov.OtherTest#notProvideNumbersForAddition")
    void failedProvideNumbersForAddition(Integer i1, Integer i2, Integer result) {
        assertThat(result).isNotEqualTo(i1 + i2);
    }
}
