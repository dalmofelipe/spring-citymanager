package com.citymanager.Budget.enums;

public enum OriginEnum {

    FEDERAL("FEDERAL"),
    STATE("STATE"),
    COUNTRY("COUNTRY");

    private final String value;

    private OriginEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
