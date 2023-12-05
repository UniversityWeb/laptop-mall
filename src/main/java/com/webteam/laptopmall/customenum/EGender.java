package com.webteam.laptopmall.customenum;

public enum EGender {
    MALE("Male"),
    FEMALE("Female");

    private final String displayName;

    EGender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
