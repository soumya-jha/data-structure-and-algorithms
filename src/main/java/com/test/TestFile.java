package com.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestFile {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.####");
        double a = Double.valueOf(3 + 2 )/2;
        System.out.println(df.format(a));
        BigDecimal bd = new BigDecimal(3+2).divide(new BigDecimal(2)).setScale(5);
        System.out.println(bd);
    }
}
