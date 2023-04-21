package com.test;

import java.math.BigDecimal;

public class TestFile {
    public static void main(String[] args) {
        double a = Double.valueOf(3 + 2 )/2;
        BigDecimal bd = new BigDecimal(3+2).divide(new BigDecimal(2)).setScale(5);
        System.out.println(bd);
    }
}
