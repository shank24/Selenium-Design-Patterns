package com.practice.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    public GoogleResultPage(final WebDriver driver){
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.navigationBar = PageFactory.initElements(driver,NavigationBar.class);
        this.resultStat = PageFactory.initElements(driver,ResultStat.class);
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

}
