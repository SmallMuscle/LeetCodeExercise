package com.test.jianZhiOffer;

import com.test.utils.NumericalUtil;

public class S_11_Power {

    public double power(double base, int exponent) {
        double result = 0;
        if (0 == exponent) return result;
        if (0 > exponent) {
            if (NumericalUtil.equals(base, 0.0)) {
                throw new RuntimeException("Input ERR: base=" + base + "\texponent=" + exponent);
            }
            result = 1 / powerWithPositiveExp(base, -exponent);
        } else {
            result = NumericalUtil.equals(base, 0.0) ? 0.0 : powerWithPositiveExp(base, exponent);
        }
        return result;
    }

    private double powerWithPositiveExp(double base, int exponent) {
        if (0 == exponent) return 1;
        if (1 == exponent) return base;
        double result = power(base, exponent >> 1);
        result *= result;
        if ((1 & exponent) ==  1) {
            result *= base;
        }
        return result;
    }


}
