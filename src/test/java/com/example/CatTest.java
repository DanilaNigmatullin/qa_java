package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline felineMock;

    @Test
    public void testGetSoundReturnsMeow() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsMeatFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodThrowsException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("ошибка"));

        Cat cat = new Cat(felineMock);
        try {
            cat.getFood();
            fail("Ожидалось исключение");
        } catch (Exception e) {
        }
    }
}