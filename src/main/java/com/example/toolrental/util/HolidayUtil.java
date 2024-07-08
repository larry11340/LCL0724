package com.example.toolrental.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class HolidayUtil {
    private static final int INDEPENDENCE_DAY = 4;
    private static final int INDEPENDENCE_MONTH = 7;
    private static final int LABOR_DAY_MONTH = 9;

    //Mark holiday if it fall into range.
    public static boolean isHoliday(LocalDate date) {
        //If July 4 is weekend, it observe holiday as Monday or Friday
        if (isIndependenceDay(date)&&!isWeekend(date)) {
            return true;
        } else if (isAMonday(date) && isADayAfterIndependenceDay(date)) {
            return true;
        } else if (isAFriday(date) && isADayBeforeIndependenceDay(date)) {
            return true;
        } else if (isLaborDay(date)) {
            return true;
        }
        return false;
    }

    private static boolean isAMonday(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private static boolean isAFriday(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }

    private static boolean isADayAfterIndependenceDay(LocalDate date) {
        return date.getMonthValue() == INDEPENDENCE_MONTH && date.getDayOfMonth() == INDEPENDENCE_DAY + 1;
    }

    private static boolean isADayBeforeIndependenceDay(LocalDate date) {
        return date.getMonthValue() == INDEPENDENCE_MONTH && date.getDayOfMonth() == INDEPENDENCE_DAY - 1;
    }

    private static boolean isIndependenceDay(LocalDate date) {
        return date.getMonthValue() == INDEPENDENCE_MONTH && date.getDayOfMonth() == INDEPENDENCE_DAY;
    }

    private static boolean isLaborDay(LocalDate date) {
        if (date.getMonthValue() == LABOR_DAY_MONTH) {
            LocalDate laborDay = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
            return date.isEqual(laborDay);
        }
        return false;
    }

    private static boolean isWeekend(LocalDate date){
        return date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }
}
