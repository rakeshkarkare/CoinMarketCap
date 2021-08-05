package com.coinmarketcap.stepdefinitions;

import com.coinmarketcap.pages.coinmarketuipages.CoinMarketLandingPage;
import com.coinmarketcap.pages.coinmarketuipages.CoinMarketPageActions;
import com.coinmarketcap.pages.coinmarketuipages.FilterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.*;

public class FrontendTasksSteps {

    @Steps
    CoinMarketLandingPage coinMarketLandingPage;

    @Steps
    CoinMarketPageActions coinMarketPageActions;

    @Steps
    FilterPage filterPage;

    List<String> allPriceDetails = new ArrayList<>();

    @Given("User launch Coin Market Page")
    public void user_launch_coin_market_page() {
        coinMarketLandingPage.open();
    }

    @Given("record the number of records in the page")
    public void record_the_number_of_records_in_the_page() {
        allPriceDetails = coinMarketPageActions.recordPriceDetails();
    }

    @When("User filter the market cap between {} and {}")
    public void user_filter_the_market_cap(String fromValue, String toValue) {
        coinMarketPageActions.enterMarketCap(fromValue, toValue);
        coinMarketPageActions.clickApplyButton();
    }

    @When("User filter the currencies by price between {} and {}")
    public void user_filter_the_currencies_by_price(String fromValue, String toValue) {
        coinMarketPageActions.enterPriceValues(fromValue, toValue);
        coinMarketPageActions.clickApplyButton();
        coinMarketPageActions.clickShowResults();
    }

    @Then("Verify that the page should display the currencies with the price between {} and {}")
    public void verify_that_the_page_should_display_the_currencies_with_the_price(Double value1, Double value2) {
        List<String> filteredPriceDetails = coinMarketPageActions.recordPriceDetails();
        filterPage.verifyPriceRange(filteredPriceDetails, value1, value2);
    }

    @Then("Verify that the page should display market cap between {} and {}")
    public void verify_that_the_page_market_cap(Double value1, Double value2) {
        List<String> marketCapDetails = coinMarketPageActions.recordMarketCapDetails();
        filterPage.verifyMarketCapRange(marketCapDetails, value1, value2);
    }

    @Given("User select Shows rows drop down to {} value")
    public void the_user_select_shows_rows_dropdown(String value1) {
        coinMarketPageActions.clickShowRows();
        coinMarketPageActions.showRowsSelected(value1);
    }

    @Given("User Verify that {} rows are getting displayed on page")
    public void verify_that_rows_are_getting_displayed_on_page(Integer value) {
        filterPage.verifyNumberOfRows(value);
    }

    @Given("User clicks on filter button")
    public void user_clicks_on_filter_button() {
        coinMarketPageActions.clickFilterButton();
    }
}
