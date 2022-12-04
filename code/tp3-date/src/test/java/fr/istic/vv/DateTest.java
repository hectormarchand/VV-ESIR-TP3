package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    Date date;
    Date date1;

    @Test
    void isValidDateTest() {
        // Classic date
        date = new Date(1, 12, 2024);

        // Wrong date
        assertThrows(AssertionError.class, () -> {
            new Date(31, 9, 2024);
        });

        // Wrong month
        assertThrows(AssertionError.class, () -> {
            new Date(24, 13, 2024);
        });

        // Not a leap year
        assertThrows(AssertionError.class, () -> {
            new Date(29, 2, 2022);
        });

        // Leap year
        new Date(29, 2, 2024);
    }

    @Test
    void isLeapYearTest() {
        assertTrue(Date.isLeapYear(2024));
        assertTrue(Date.isLeapYear(2020));
        assertFalse(Date.isLeapYear(2022));
        assertTrue(Date.isLeapYear(0));
        assertTrue(Date.isLeapYear(-4));
        assertFalse(Date.isLeapYear(-3));
    }

    @Test
    void nextDateTest() {
        // nextDay
        date = new Date(1, 12, 2024);
        assertEquals(new Date(2, 12, 2024), date.nextDate());
        // nextMonth
        date = new Date(30, 11, 2024);
        assertEquals(new Date(1, 12, 2024), date.nextDate());
        // nextYear
        date = new Date(31, 12, 2024);
        assertEquals(new Date(1, 1, 2025), date.nextDate());
        // nextDay LeapYear
        date = new Date(28, 2, 2024);
        assertEquals(new Date(29, 2, 2024), date.nextDate());
        // nextDay NotLeapYear
        date = new Date(28, 2, 2025);
        assertEquals(new Date(1, 3, 2025), date.nextDate());

    }

    @Test
    void previousDateTest() {
        // previousDay
        date = new Date(2, 12, 2024);
        assertEquals(new Date(1, 12, 2024), date.previousDate());
        // previousMonth
        date = new Date(1, 11, 2024);
        assertEquals(new Date(31, 10, 2024), date.previousDate());
        // previousYear
        date = new Date(1, 1, 2024);
        assertEquals(new Date(31, 12, 2023), date.previousDate());
        // previousDay LeapYear
        date = new Date(1, 3, 2024);
        assertEquals(new Date(29, 2, 2024), date.previousDate());
        // previousDay NotLeapYear
        date = new Date(1, 3, 2025);
        assertEquals(new Date(28, 2, 2025), date.previousDate());

    }

    @Test
    void compareToTest() {
        date = new Date(2, 12, 2024);
        date1 = new Date(2, 12, 2027);
        assertEquals(-1, date.compareTo(date1));
        assertEquals(0, date.compareTo(date));
        assertEquals(1, date1.compareTo(date));

    }

}