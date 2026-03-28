package com.example.demo;

import service.SpringBootTest;
import service.Test;

@SpringBootTest
public class DateServiceTest {

    @Test
    public void testDaysBetween() {
        int result = DateService.calculateDaysBetween("01/01/2020", "03/01/2020");
        assertEquals(2, result);
    }
}

