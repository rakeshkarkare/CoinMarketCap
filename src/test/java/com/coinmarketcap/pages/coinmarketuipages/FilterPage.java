package com.coinmarketcap.pages.coinmarketuipages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterPage extends UIInteractionSteps {

    @Step
    public void verifyNumberOfRows(int expectedCount) {
        int actualCount = find(CoinMarketLandingPage.COIN_MARKET_TABLE).
                findElements(By.tagName("tr")).size();
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Step
    public void verifyPriceRange(List<String> filteredPriceDetails, Double fromPrice, Double toPrice) {
        List<Double> filteredPrices = new ArrayList<>();
        for (String filteredPriceDetail : filteredPriceDetails) {
            filteredPrices.add(Double.valueOf(filteredPriceDetail.substring(1)));
        }
        for (Double filteredPrice : filteredPrices) {
            assertThat(filteredPrice >= fromPrice && filteredPrice <= toPrice).isTrue();
        }
    }

    @Step
    public void verifyMarketCapRange(List<String> marketCapDetails, Double fromMarketCap, Double toMarketCap) {
        List<Double> filteredMarketCap = new ArrayList<>();
        for (String filteredPriceDetail : marketCapDetails) {

            String regex = "(?<=[\\d])(,)(?=[\\d])";
            Pattern p = Pattern.compile(regex);
            String str = filteredPriceDetail.substring(1);
            Matcher m = p.matcher(str);
            str = m.replaceAll("");

            filteredMarketCap.add(Double.valueOf(str));
        }

        for (Double filteredPrice : filteredMarketCap) {
            assertThat(filteredPrice >= fromMarketCap && filteredPrice <= toMarketCap).isTrue();
        }
    }
}
