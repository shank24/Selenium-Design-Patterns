package com.practice.seleniumdesign.srp.result;

import com.practice.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStat extends AbstractComponent {

    @FindBy(id="result-stats")
    private WebElement resultStat;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat(){
        return this.resultStat.getText();
    }
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d-> this.resultStat.isDisplayed()));
    }
}
