package com.example.toolrental.unitTest.util;

import com.example.toolrental.util.HolidayUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

public class HolidayUtilTest {

    @Test
    @DisplayName("validate July 4 and is not on weekend then it is a holiday")
    public void validateJuly4thIsHolidayTest(){
        LocalDate date = LocalDate.of(2024,7,4);
        Assertions.assertTrue(HolidayUtil.isHoliday(date));
    }
    @Test
    @DisplayName("validate Labor Day is a holiday")
    public void validateLaborDayIsHolidayTest(){
        LocalDate date = LocalDate.of(2024,9,2);
        Assertions.assertTrue(HolidayUtil.isHoliday(date));
    }
    @Test
    @DisplayName("validate July 4 and is on weekend then it is NOT a holiday")
    public void validateJuly4thNotHolidayTest(){
        LocalDate date = LocalDate.of(2026,7,4);
        Assertions.assertFalse(HolidayUtil.isHoliday(date));
    }

    @Test
    @DisplayName("validate July 3 and July 4 is on weekend(Saturday) so July 3 it is a holiday")
    public void validateJuly3HolidayTest(){
        LocalDate date = LocalDate.of(2026,7,3);
        Assertions.assertTrue(HolidayUtil.isHoliday(date));
    }

    @Test
    @DisplayName("validate July 5 and July 4 is on weekend(Sunday) so July 5 it is a holiday")
    public void validateJuly5HolidayTest(){
        LocalDate date = LocalDate.of(2027,7,5);
        Assertions.assertTrue(HolidayUtil.isHoliday(date));
    }

}
