package com.coinmarketcap.pages.backendpages;

public class CurrencyPojo {

    private Long id;
    private String name;
    private String symbol;
    private String slug;
    private Integer is_active;
    private Long rank;
    private String first_historical_data;
    private String last_historical_data;
    private PlatformPojo platform;

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getIsActive() {
        return is_active;
    }

    public void setIsActive(int is_active) {
        this.is_active = is_active;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getFirstHistoricalData() {
        return first_historical_data;
    }

    public void setFirstHistoricalData(String first_historical_data) {
        this.first_historical_data = first_historical_data;
    }

    public String getLastHistoricalData() {
        return last_historical_data;
    }

    public void setLastHistoricalData(String last_historical_data) {
        this.last_historical_data = last_historical_data;
    }

    public PlatformPojo getPlatform(){
        return platform;
    }

    public void setPlatform(PlatformPojo platform){
        this.platform = platform;
    }

}
