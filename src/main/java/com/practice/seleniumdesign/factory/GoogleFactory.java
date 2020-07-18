package com.practice.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    private static final Function<WebDriver,GooglePage> ENG = (driver)-> new GoogleEnglish(driver);
    private static final Function<WebDriver,GooglePage> FR = (driver)-> new GoogleFrench(driver);
    private static final Function<WebDriver,GooglePage> SA = (driver)-> new GoogleArabic(driver);
    private static final Function<WebDriver,GooglePage> ES = (driver)-> new GoogleES(driver);

    private static final Map<String,Function<WebDriver,GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENG",ENG);
        MAP.put("FR",FR);
        MAP.put("SA",SA);
        MAP.put("ES",ES);
    }

    public static GooglePage get(String language, WebDriver driver){
        return MAP.get(language).apply(driver);
    }
}
