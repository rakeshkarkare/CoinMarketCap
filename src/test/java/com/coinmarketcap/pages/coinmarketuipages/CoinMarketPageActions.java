package com.coinmarketcap.pages.coinmarketuipages;

import com.coinmarketcap.utils.CustomWait;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CoinMarketPageActions extends UIInteractionSteps {

    CustomWait customWait;

    @Step
    public void clickShowRows() {
        find(CoinMarketLandingPage.SHOW_ROWS).click();
    }

    @Step
    public void showRowsSelected(String value1) {
        find(CoinMarketLandingPage.showDropDown(value1)).click();
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(CoinMarketLandingPage.
                        showDropDownSelected(value1)))
                .isSelected();
    }

    @Step
    public List<String> recordPriceDetails() {
        List<String> priceDetails = new ArrayList<>();
        customWait.sleep(1);
        List<WebElement> rows = find(CoinMarketLandingPage.COIN_MARKET_TABLE).
                findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            priceDetails.add(cols.get(3).getText());
        }
        return priceDetails;
    }

    @Step
    public List<String> recordMarketCapDetails() {
        List<String> marketCapDetails = new ArrayList<>();
        customWait.sleep(1);
        List<WebElement> rows = find(CoinMarketLandingPage.COIN_MARKET_TABLE).
                findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            marketCapDetails.add(cols.get(6).getText());
        }
        return marketCapDetails;
    }

    @Step
    public void clickFilterButton() {
        find(CoinMarketLandingPage.FILTER_LINK).click();
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(CoinMarketLandingPage.FILTER_BUTTON))
                .isEnabled();
        find(CoinMarketLandingPage.FILTER_BUTTON).click();
    }

    @Step
    public void enterPriceValues(String fromValue, String toValue) {
        find(CoinMarketLandingPage.PRICE_BUTTON).click();
        find(CoinMarketLandingPage.PRICE_FROM).sendKeys(fromValue);
        find(CoinMarketLandingPage.PRICE_TO).sendKeys(toValue);
    }

    @Step
    public void enterMarketCap(String fromValue, String toValue) {
        find(CoinMarketLandingPage.MARKET_CAP_BUTTON).click();
        find(CoinMarketLandingPage.MARKET_CAP_FROM).sendKeys(fromValue);
        find(CoinMarketLandingPage.MARKET_CAP_TO).sendKeys(toValue);
    }

    @Step
    public void clickApplyButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement element = find(CoinMarketLandingPage.PRICE_APPLY);
        js.executeScript("arguments[0].click();", element);
    }

    @Step
    public void clickShowResults() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement element = find(CoinMarketLandingPage.SHOW_RESULTS);
        js.executeScript("arguments[0].click();", element);
    }

}