package com.practice.seleniumdesign.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {


    @FindBy(name ="q")
    private WebElement searchBox;


    public SearchWidget(final WebDriver driver){
        super(driver);
    }

    // The purpose of changing this in to char by char, is to simulate the human way of
    // querying the keyword
    public void enter(String keyword){
        this.searchBox.clear();
        for (char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch+"");
        }


    }

    @Override
    public boolean isDisplayed() {
        // Wait until this is Displayed
        return this.wait.until((d -> this.searchBox.isDisplayed()));
    }

}
