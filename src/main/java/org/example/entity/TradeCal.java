package org.example.entity;

public class TradeCal {
    private Integer id;

    private String exchange;

    private String calDate;

    private String isOpen;

    private String pretradeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange == null ? null : exchange.trim();
    }

    public String getCalDate() {
        return calDate;
    }

    public void setCalDate(String calDate) {
        this.calDate = calDate == null ? null : calDate.trim();
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }

    public String getPretradeDate() {
        return pretradeDate;
    }

    public void setPretradeDate(String pretradeDate) {
        this.pretradeDate = pretradeDate == null ? null : pretradeDate.trim();
    }
}