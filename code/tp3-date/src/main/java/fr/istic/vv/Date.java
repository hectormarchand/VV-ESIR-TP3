package fr.istic.vv;

import java.util.Arrays;
import java.util.List;

class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new AssertionError();
        }
    }

    public boolean isValidDate(int day, int month, int year) {
        List<Integer> listMonth31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        if (month <= 0 || month >= 13) {
            return false;
        }
        if (day <= 0 || day >= 32) {
            return false;
        }
        if (listMonth31.contains(month)) {
            return true;
        } else {
            if (day >= 31) {
                return false;
            }
            // if (month = February)
            if (month == 2) {
                // Annee bisextile ???
                if (day >= 29) {
                    if (day == 29 && isLeapYear(year)) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public Date nextDate() {
        // next day
        if (isValidDate(day + 1, month, year)) {
            return new Date(day + 1, month, year);
        }
        // next month
        if (isValidDate(1, month + 1, year)) {
            return new Date(1, month + 1, year);
        }
        // next year
        return new Date(1, 1, year + 1);

    }

    public Date previousDate() {
        // previous day
        if (isValidDate(day - 1, month, year)) {
            return new Date(day - 1, month, year);
        }
        // previous month
        if (isValidDate(1, month - 1, year)) {
            if (isValidDate(31, month - 1, year)) {
                return new Date(31, month - 1, year);
            }
            if (isValidDate(30, month - 1, year)) {
                return new Date(30, month - 1, year);
            }
            if (isValidDate(29, month - 1, year)) {
                return new Date(29, month - 1, year);
            }
            return new Date(28, month - 1, year);
        }
        // previous year
        return new Date(31, 12, year - 1);
    }

    public int compareTo(Date other) {
        if (other == null) {
            throw new NullPointerException();
        }
        // same date
        if (this.equals(other)) {
            return 0;
        }
        // this > other
        if (this.year >= other.getYear()) {
            return 1;
        }
        if (this.year == other.getYear() && this.month >= other.getMonth()) {
            return 1;
        }
        if (this.year == other.getYear() && this.month == other.getMonth() && this.day >= other.getDay()) {
            return 1;
        }
        // this < other
        return -1;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (!(other instanceof Date)) {
            return false;
        }

        Date otherDate = ((Date) other);

        return this.getDay() == otherDate.getDay()
            && this.getMonth() == otherDate.getMonth()
            && this.getYear() == otherDate.getYear();
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}