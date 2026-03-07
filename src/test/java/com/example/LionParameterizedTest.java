package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String invalidSex;

    public LionParameterizedTest(String invalidSex) {
        this.invalidSex = invalidSex;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Дракон"},
                {""},
                {"самец"},
                {"САМКА"},
        });
    }

    @Test
    public void testLionInvalidSexThrowsException() {
        try {
            new Lion(invalidSex, new Feline());
            fail("Ожидалось исключение для пола: " + invalidSex);
        } catch (Exception e) {
        }
    }
}