package com.practice.seleniumdesign.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOption> CC = () -> new CreditCard();
    private static final Supplier<PaymentOption> NB = () -> new NetBanking();
    private static final Supplier<PaymentOption> PP = () -> new Paypal();

    private static final Map<String, Supplier<PaymentOption>> MAP= new HashMap<>();

    static {
        MAP.put("CC",CC);
        MAP.put("NB",NB);
        MAP.put("PP",PP);
    }

    public static PaymentOption get(String option){
        return MAP.get(option).get();
    }

}
