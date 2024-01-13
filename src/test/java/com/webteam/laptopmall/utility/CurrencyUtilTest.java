package com.webteam.laptopmall.utility;

import com.webteam.laptopmall.util.CurrencyUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyUtilTest {
    @Test
    public void testGetUSCurrency() {
        BigDecimal price = new BigDecimal("1000.50");
        String expected = "$1,000.50";
        String result = CurrencyUtil.getUSFormat(price);
        assertEquals(expected, result);
    }

    @Test
    public void testGetVietNamCurrency() {
        BigDecimal price = new BigDecimal(2_000_000);
        String expected = "2.000.000 ₫";
        String result = CurrencyUtil.getVNFormat(price);
        assertEquals(expected, result);
    }
}