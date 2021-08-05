package com.coinmarketcap.pages.backendpages;

public class PlatformPojo {
    private String symbol;
    private String name;
    private String token_address;
    private Long id;
    private String slug;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTokenAddress() {
        return token_address;
    }

    public void setTokenAddress(String token_address) {
        this.token_address = token_address;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
