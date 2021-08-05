package com.coinmarketcap.pages.backendpages;

import com.coinmarketcap.utils.ReadConfigurationFile;
import com.coinmarketcap.utils.ResponseValidation;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.core.IsNull;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BackendActions {

    private Response response;

    /**
     * This method is basically used to retrieve currency ids from Response
     * @param currencies
     * @return currencyID
     */
    @Step
    public List<Long> retrieveTheCurrencyIDs(List<String> currencies) {
        List<Long> currencyID = new ArrayList<>();
        getMapCall();
        List<CurrencyPojo> currencyPojos = response.jsonPath().getList("data", CurrencyPojo.class);

        for (CurrencyPojo currencyPojo :currencyPojos) {
            if(currencies.contains(currencyPojo.getSymbol())){
                currencyID.add(currencyPojo.getID());
            }
        }

        return currencyID;
    }

    /**
     * This method is basically to covert all currency ids to another currency
     * @param currencyIDs
     * @param convertCurrency
     */
    @Step
    public void convertToBoliviano(List<Long> currencyIDs, String convertCurrency) {
        currencyIDs.forEach(id -> {
            getCurrencyConvertCall(id, convertCurrency);
        });

    }

    /**
     * This method is basically to covert get coin market map call
     */
    private void getMapCall() {
        response = SerenityRest
                .given().header("X-CMC_PRO_API_KEY", ReadConfigurationFile.
                        readConfigurationFile("api.key"))
                .header("Accept", "application/json")
                .when()
                .get(ReadConfigurationFile.
                        form_endpoint("coinmarket.mapcall.endpoint"));
        response.then()
                .statusCode(200);
    }

    /**
     * This private method is to make a get currency convert call
     * @param id
     * @param convertCurrency
     */
    private void getCurrencyConvertCall(long id, String convertCurrency) {
        response = SerenityRest
                .given().header("X-CMC_PRO_API_KEY", ReadConfigurationFile.
                        readConfigurationFile("api.key"))
                .header("Accept", "application/json")
                .queryParam("amount", 1)
                .queryParam("id", id)
                .queryParam("convert", convertCurrency)
                .when()
                .get(ReadConfigurationFile.
                        form_endpoint("coinmarket.priceconversion.endpoint"));
        response.then()
                .statusCode(200);
    }

    /**
     * This method is to get info call for a particular currency
     * @param id
     */
    @Step
    public void getInfoCallForCurrency(long id){
        response = SerenityRest
                .given().header("X-CMC_PRO_API_KEY", ReadConfigurationFile.
                        readConfigurationFile("api.key"))
                .queryParam("id", id)
                .header("Accept", "application/json")
                .when()
                .get(ReadConfigurationFile.
                        form_endpoint("coinmarket.infocall.endpoint"));
        response.then()
                .statusCode(200);
    }

    /**
     * This method is to verify all the values in the get info call
     * @param key
     * @param expectedValue
     */
    @Step
    public void verifyInfoCallDetail(String key, String expectedValue){
        String actualValue = null;
        JsonPath jsonPath = new JsonPath(response.body().asString());
        switch(key){
            case "logo":{
                actualValue = jsonPath.get(ResponseValidation.LOGO_PATH);
                break;
            }
            case "technical_doc":{
                actualValue = jsonPath.get(ResponseValidation.TECHNICAL_DOC_PATH);
                break;
            }
            case "symbol":{
                actualValue = jsonPath.get(ResponseValidation.SYMBOL_PATH);
                break;
            }
            case "date_added":{
                actualValue = jsonPath.get(ResponseValidation.DATE_ADDED_PATH);
                break;
            }
            case "platform":{
                actualValue = jsonPath.get(ResponseValidation.PLATFORM_PATH);
                assertThat(actualValue, is(IsNull.nullValue()));
                break;
            }
            case "tags":{
                actualValue = jsonPath.get(ResponseValidation.TAGS_PATH);
                break;
            }
            default:{
                response.then().statusCode(200);
            }
        }
        if(actualValue != null)
            assertThat(actualValue, equalTo(expectedValue));
    }

    /**
     * This method is to verify the cryptocurrency name is intact with the name in the get map call
     * @param id
     * @param expectedCurrencyName
     */
    @Step
    public void verifyCryptoCurrencyValueInInfoCall(long id, String expectedCurrencyName){
        String actualCurrencyName = fetchCurrencyNameFromInfoCall(id);
        assertThat(actualCurrencyName, equalTo(expectedCurrencyName));
    }


    /**
     * This private method is to retrieve the currency name from the get info call
     * @param id
     * @return
     */
    private String fetchCurrencyNameFromInfoCall(long id){
        String jsonPathCreatorNamePath = "data."+id+".name";
        JsonPath jsonPath = new JsonPath(response.body().asString());
        return jsonPath.get(jsonPathCreatorNamePath);
    }

}