package com.example.toolrental.service.impl;

import com.example.toolrental.dto.RentalAgreement;
import com.example.toolrental.entity.Tool;
import com.example.toolrental.exception.ErrorCodes;
import com.example.toolrental.exception.ToolRentalException;

import com.example.toolrental.repository.ToolRepository;
import com.example.toolrental.service.ToolRentalService;
import com.example.toolrental.util.DayUtil;
import com.example.toolrental.util.PriceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ToolRentalServiceImpl implements ToolRentalService {

    private ToolRepository toolRepository;
    Logger logger = LoggerFactory.getLogger(ToolRentalServiceImpl.class);


    @Autowired
    public ToolRentalServiceImpl(ToolRepository toolRepository){
        this.toolRepository = toolRepository;
    }

    @Override
    public RentalAgreement postCheckout(String code, int dayCount, int discount, LocalDate startDate) throws ToolRentalException {
        logger.info("postCheckout service for code " + code);
        Optional<Tool> toolInfo = Optional.empty();
        try {
            toolInfo = toolRepository.getToolByCode(code);
        }catch(Exception c){
            logger.error("Something wrong with database", c.getMessage());
            throw new ToolRentalException(ErrorCodes.UNEXPECTED_ERROR_DATABASE);
        }
        if (toolInfo.isEmpty()) {
            logger.error("Invalid code, code not found");
                throw new ToolRentalException(ErrorCodes.CODE_NOT_FOUND, code);
        }
        try {
            Integer[] dateCategories = DayUtil.getCategorizeDays(startDate, dayCount);
            int totalChargeDates = DayUtil.totalChargeDay(dateCategories, toolInfo.get().getToolType());
            BigDecimal totalCharge = PriceUtil.totalCharge(totalChargeDates, toolInfo.get().getToolType().getDailyCharge());
            BigDecimal discountAmount = BigDecimal.valueOf(0);
            if (discount != 0) {
                discountAmount = PriceUtil.discountAmount(discount, totalCharge);
            }
            BigDecimal finalCharge = PriceUtil.finalCharge(discountAmount, totalCharge);
            return new RentalAgreement(toolInfo.get().getCode(), toolInfo.get().getToolType().getType(), toolInfo.get().getBrand(), dayCount, startDate, startDate.plusDays(dayCount), toolInfo.get().getToolType().getDailyCharge(), totalChargeDates, totalCharge, discount, discountAmount,
                    finalCharge);
        }catch(Exception e){
            logger.error("Something wrong with services", e.getMessage());
            throw new ToolRentalException(ErrorCodes.UNEXPECTED_ERROR);
        }
    }

}
