package com.webteam.laptopmall.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static String getUSFormat(BigDecimal priceUS) {
        return getCurrency(priceUS, Locale.US);
    }

    public static String getVNFormat(BigDecimal priceVN) {
        Locale locale = new Locale("vi", "VN");
        return getCurrency(priceVN, locale);
    }

    private static String getCurrency(BigDecimal price, Locale locale) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
        String priceStr = currency.format(price);
        return priceStr;
    }
}
