package com.practice.seleniumdesign.test.factory;

import com.practice.seleniumdesign.factory.GoogleFactory;
import com.practice.seleniumdesign.factory.GooglePage;
import com.practice.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;


    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword){

        //Here driver is coming from Base Class.
        // Creating an instance of Google Factory.

        this.googlePage = GoogleFactory.get(language,this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultsCount = this.googlePage.getResultsCount();
        System.out.println("Results Count  :: "+ resultsCount);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "design patterns"},
                {"SA", "docker"},
                {"ES", "money heist"}
        };
    }
}
