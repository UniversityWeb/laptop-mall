package com.webteam.laptopmall.product;

public enum ECategory {
    LAPTOP("Laptop"),
    MECHANICAL_KEYBOARD("Mechanical keyboard"),
    MONITOR("Monitor");

    private final String displayName;

    ECategory(String displayName) {
        this.displayName = displayName;
    }
}
