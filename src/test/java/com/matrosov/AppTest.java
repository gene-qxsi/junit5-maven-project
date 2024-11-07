package com.matrosov;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    void firstDITest(TestInfo info, TestReporter reporter) {
        String name = info.getTestMethod().get().getName();
        reporter.publishEntry(name);
        System.out.println("выполняется метод: " + name);
    }

    @RepeatedTest(10)
    void secondDITest(RepetitionInfo repetitionInfo, TestReporter reporter) {
        int c = repetitionInfo.getCurrentRepetition();
        int t = repetitionInfo.getTotalRepetitions();
        int f = repetitionInfo.getFailureCount();
        System.out.println(c + " повторение из " + t + ", не прошло - " + f);
        reporter.publishEntry("Текущий повтор: " + c);
        assertThat(c).isBetween(2, 6);
    }
}
