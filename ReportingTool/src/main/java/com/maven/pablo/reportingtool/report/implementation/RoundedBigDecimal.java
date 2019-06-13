package com.maven.pablo.reportingtool.report.implementation;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundedBigDecimal {

    public static BigDecimal of(BigDecimal value) {
            BigDecimal divided = value.divide( BigDecimal.valueOf(0.5) , 0,  RoundingMode.HALF_DOWN);
            BigDecimal result = divided.multiply(BigDecimal.valueOf(0.5));
            return result;
        }
    }

