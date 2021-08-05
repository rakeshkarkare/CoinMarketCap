package com.coinmarketcap.pages.coinmarketuipages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("coinmarketcap.page")
public class CoinMarketLandingPage extends PageObject {

    public static By SHOW_ROWS = By.xpath("//div[contains(@class, 'sc-16r8icm-0 ekMmID table-control-page-sizer')]//div[contains(@class, 'sc-16r8icm-0 tu1guj-0 cSTqvK')]");

    public static By COIN_MARKET_TABLE = By.xpath("//div[@class='h7vnx2-1 bFzXgL']//table//tbody");
    public static By FILTER_BUTTON = By.xpath("//*[contains(@class, 'sc-1erqz0q-0 kSFTVn')]/li[5]/button");
    public static By FILTER_LINK = By.xpath("//*[contains(@class, 'sc-1hxnufv-5 fmuRvw')]//button[contains(@class, 'x0o17e-0 ewuQaX sc-36mytl-0 bBafzO table-control-filter')]");
    public static By PRICE_BUTTON = By.xpath("//button[contains(text(),'Price')]");
    public static By PRICE_FROM = By.xpath("//input[@placeholder='$0']");
    public static By PRICE_TO = By.xpath("//input[@placeholder='$99,999']");
    public static By PRICE_APPLY = By.xpath("//button[contains(text(),'Apply')]");

    public static By MARKET_CAP_BUTTON = By.xpath("//button[contains(text(),'Market Cap')]");
    public static By MARKET_CAP_FROM = By.xpath("//input[@placeholder='$0']");
    public static By MARKET_CAP_TO = By.xpath("//input[@placeholder='$999,999,999,999']");
    public static By SHOW_RESULTS = By.xpath("//button[contains(text(),'Show results')]");

    private static String SHOW_ROW_DROP_DOWN = "//div[contains(@class, 'tippy-content')]//button[contains(text(), '%s')]";
    private static String ROW_DOWN_SELECTED_VALUE = "//div[contains(@class, 'sc-16r8icm-0 ekMmID table-control-page-sizer')]//div[contains(text(), '%s')]";

    public static By showDropDown(String value){
        return By.xpath(
                String.format(SHOW_ROW_DROP_DOWN, value)
        );
    }

    public static By showDropDownSelected(String value){
        return By.xpath(
                String.format(ROW_DOWN_SELECTED_VALUE, value)
        );
    }
}
