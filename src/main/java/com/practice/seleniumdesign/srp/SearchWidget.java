package com.practice.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchWidget extends AbstractComponent {

    private WebDriverWait wait;

    @FindBy(name ="q")
    private WebElement searchBox;


    public SearchWidget(final WebDriver driver){
        this.wait =new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }


    public void enter(String keyword){
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
    }

    @Override
    public boolean isDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        //It will wait for 30 seconds, and if element is visible within 5 seconds, then it will return

        return this.searchBox.isDisplayed();
    }

}
