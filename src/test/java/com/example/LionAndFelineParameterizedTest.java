package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionAndFelineParameterizedTest {

    private final String testType;
    private final Object input;

    public LionAndFelineParameterizedTest(String testType, Object input) {
        this.testType = testType;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"lion",   "Дракон"},
                {"lion",   ""},
                {"lion",   "самец"},
                {"lion",   "САМКА"},
                {"feline", 0},
                {"feline", 1},
                {"feline", 2},
                {"feline", 5},
        });
    }

    @Test
    public void runParameterizedTest() throws Exception {
        if ("lion".equals(testType)) {
            try {
                new Lion((String) input, new Feline());
                fail("Ожидалось исключение для пола: " + input);
            } catch (Exception e) {
            }
        } else {
            Feline feline = new Feline();
            int count = (int) input;
            assertEquals(count, feline.getKittens(count));
        }
    }
}