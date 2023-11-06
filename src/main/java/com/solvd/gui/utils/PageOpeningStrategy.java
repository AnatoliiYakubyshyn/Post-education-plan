package com.solvd.gui.utils;

public enum PageOpeningStrategy {

    BY_URL("BY_URL"),

    BY_MARKER("BY_MARKER"),

    BY_URL_AND_MARKER("BY_URL_AND_MARKER");

    private String value;

    PageOpeningStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
