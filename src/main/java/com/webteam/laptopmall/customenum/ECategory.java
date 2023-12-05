package com.webteam.laptopmall.customenum;

public enum ECategory {
    LAPTOP("Laptop"),
    MECHANICAL_KEYBOARD("Mechanical keyboard"),
    MONITOR("Monitor");

    private final String displayName;

    ECategory(String displayName) {
        this.displayName = displayName;
    }
}
