package com.example.toolrental.util;

import com.example.toolrental.entity.ToolType;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {

    public static Integer [] getCategorizeDates(LocalDate startDate, int count){
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
        Integer [] categorizeDates = new Integer[3];
        categorizeDates[0] = numberOfWeekDay;
        categorizeDates[1] = numberOfWeekEnd;
        categorizeDates[2] = numberOfHoliday;
    return categorizeDates;
    }

    public static int totalChargeDates(Integer [] categorizeDates, ToolType toolInfo){
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
