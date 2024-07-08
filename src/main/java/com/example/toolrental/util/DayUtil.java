package com.example.toolrental.util;

import com.example.toolrental.entity.ToolType;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayUtil {

    //Put these dates into category of weekday, weekend, or is a holiday
    public static Integer [] getCategorizeDays(LocalDate startDate, int count){
        int numberOfWeekDay =0;
        int numberOfWeekEnd =0;
        int numberOfHoliday =0;
        LocalDate endDate = startDate.plusDays(count);
        LocalDate indexDate = startDate;
        while(indexDate.isBefore(endDate)){
            if(HolidayUtil.isHoliday(indexDate)){
                numberOfHoliday++;
            }
            else if(indexDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || indexDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                numberOfWeekEnd++;
            }else{
                numberOfWeekDay++;
            }
            indexDate = indexDate.plusDays(1);

        }
        //Only three types
        Integer [] categorizeDays = new Integer[3];
        categorizeDays[0] = numberOfWeekDay;
        categorizeDays[1] = numberOfWeekEnd;
        categorizeDays[2] = numberOfHoliday;
    return categorizeDays;
    }

    //Calculate the total charge base on the toolInfo and categorize dates
    public static int totalChargeDay(Integer [] categorizeDates, ToolType toolInfo){
        boolean isChargeWeekDay = toolInfo.isWeekdayCharge();
        boolean isChargeWeekEnd = toolInfo.isWeekendCharge();
        boolean isChargeHoliday = toolInfo.isHolidayCharge();
        int totalChargeDay = 0;
        for(int i=0; i< categorizeDates.length;i++){
            if(i==0 && isChargeWeekDay){
                totalChargeDay = totalChargeDay + categorizeDates[i];
            }else if(i==1 && isChargeWeekEnd){
                totalChargeDay = totalChargeDay + categorizeDates[i];
            }else if(i==2 && isChargeHoliday){
                totalChargeDay = totalChargeDay + categorizeDates[i];
            }
        }
        return totalChargeDay;
    }


}
