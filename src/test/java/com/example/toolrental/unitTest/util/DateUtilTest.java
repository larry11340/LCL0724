package com.example.toolrental.unitTest.util;

import com.example.toolrental.entity.ToolType;
import com.example.toolrental.util.DateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DateUtilTest {

    @Test
    @DisplayName("Validate categorize days")
    public void getCategorizeDatesValidation(){
       Integer [] values= DateUtil.getCategorizeDates(LocalDate.of(2024,7,1), 6);
       Integer [] expectedValues = {4,1,1};

       Assertions.assertArrayEquals(expectedValues,values);
    }

    @Test
    @DisplayName("Validate Total Charge Dates")
    public void totalChargeDatesValidation(){
        Integer [] values = {4,1,1};
        ToolType model = new ToolType("Ladder",new BigDecimal("1.99"),true, false,true);
        DateUtil.totalChargeDates(values,model);
    }
}
