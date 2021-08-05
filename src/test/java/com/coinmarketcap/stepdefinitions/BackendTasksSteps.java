package com.coinmarketcap.stepdefinitions;

import com.coinmarketcap.pages.backendpages.BackendActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

public class BackendTasksSteps {

    @Steps
    BackendActions backendActions;

    private List<Long> currencyIDs = new ArrayList<>();

    @Given("User retrieve the IDs of the below currencies")
    public void user_retrieve_the_IDs_currencies(List<String> currencies) {
        currencyIDs = backendActions.retrieveTheCurrencyIDs(currencies);
    }

    @Then("Verify user able to convert them to Bolivian Boliviano currency as {}")
    public void user_convert_them_to_Bolivian(String convertCurrency) {
        backendActions.convertToBoliviano(currencyIDs, convertCurrency);
    }

    @Given("User make get info call for Ethereum with id {}")
    public void user_make_an_info_call_for_Ethereum(long id) {
        backendActions.getInfoCallForCurrency(id);
    }

    @Then("Verify the below details in the response")
    public void user_should_able_to_verify_the_below_details(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows) {
            backendActions.verifyInfoCallDetail(columns.get(0), columns.get(1));
        }
    }

    @Given("User retrieve the info of Id {}")
    public void user_retrieve_the_info_of_Id(long id)
    {
        backendActions.getInfoCallForCurrency(id);
    }

    @Then("Verify the currency is having {} value as {}")
    public void verify_the_currency_with_Id_is_having_mineable_tag(String key, String value) {
        backendActions.verifyInfoCallDetail(key, value);
    }

    @Then("Verify the currency with Id {} is having correct cryptocurrency {}")
    public void verify_the_currency_with_Id_is_having_correct_cryptocurrency(long id, String expectedCurrencyName) {
        backendActions.verifyCryptoCurrencyValueInInfoCall(id, expectedCurrencyName);
    }

}
