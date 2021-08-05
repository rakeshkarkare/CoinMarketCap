package com;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features",
        glue = {"classpath:com.coinmarketcap.stepdefinitions"},
        tags = "@regression"
)
public class CoinMarketCapTestRunner {}