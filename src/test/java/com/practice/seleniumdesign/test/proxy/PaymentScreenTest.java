package com.practice.seleniumdesign.test.proxy;



import com.google.common.util.concurrent.Uninterruptibles;
import com.practice.seleniumdesign.proxy.PaymentOptionFactory;
import com.practice.seleniumdesign.proxy.PaymentScreen;
import com.practice.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen(){
        System.setProperty("env","PROD");
        this.paymentScreen=new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String,String> paymentDetails){
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("shank","kalra","shankkalra@gmg.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();

        System.out.println(
                "Order Number : " + orderNumber
        );

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[][] getData(){

        Map<String,String> cc = Maps.newHashMap();
        cc.put("cc","123123");
        cc.put("year","1989");
        cc.put("cvv","123");

        Map<String,String> nb = Maps.newHashMap();
        nb.put("bank","WELLS FARGO");
        nb.put("account","myacccount123");
        nb.put("pin","000");


        Map<String,String> pp = Maps.newHashMap();
        nb.put("username","abcdef");
        nb.put("password","abcdef");


        return new Object[][]{
                {"CC",cc},
                {"NB",nb},
                {"PP",pp}
        };
    }

}
