package com.practice.seleniumdesign.test.command;

import com.practice.seleniumdesign.command.HomePage;
import com.practice.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.homePage=new HomePage(driver);
    }

    @Test
    public void homePageTest(){
        this.homePage.goTo();

        // Traditional Way
       /* for (ElementValidator ev: this.homePage.getElementValidators()) {
            boolean result = ev.validate();
            Assert.assertTrue(result)
        }*/

        // Java 8
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }
}
