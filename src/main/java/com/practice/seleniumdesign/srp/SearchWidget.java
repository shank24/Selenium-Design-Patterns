package com.practice.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchWidget extends AbstractComponent {


    @FindBy(name ="q")
    private WebElement searchBox;


    public SearchWidget(final WebDriver driver){
        super(driver);
    }


    public void enter(String keyword){
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
    }

    @Override
    public boolean isDisplayed() {
        // Wait until this is Displayed
        return this.wait.until((d -> this.searchBox.isDisplayed()));
    }

}
