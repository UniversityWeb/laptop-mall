package com.webteam.laptopmall.product.dto;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.entity.Monitor;

import java.math.BigDecimal;
import java.util.Set;

public class MonitorDTO extends ProductDTO {
    private double screenSize;
    private String resolution;
    private boolean touchScreen;
    private Monitor.EPanel panelType;
    private int refreshRate;
    private boolean eyeCareTechnology;
    private int brightness;
    private boolean hdrSupported;
    private boolean builtInSpeakers;
    private double powerConsumption;
    private double weight;
    private Set<Monitor.EConnection> connections;

    public MonitorDTO() {
    }

    public MonitorDTO(Long id, String brand, String model, String desc, BigDecimal price, Integer stockQty,
                      double discountPercent, String version, String color, int releaseYear, ECategory category,
                      double screenSize, String resolution, boolean touchScreen, Monitor.EPanel panelType,
                      int refreshRate, boolean eyeCareTechnology, int brightness, boolean hdrSupported,
                      boolean builtInSpeakers, double powerConsumption, double weight, Set<Monitor.EConnection> connections, boolean markAsDeleted) {
        super(id, brand, model, desc, price, stockQty, discountPercent, version, color, releaseYear, category,markAsDeleted);
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.touchScreen = touchScreen;
        this.panelType = panelType;
        this.refreshRate = refreshRate;
        this.eyeCareTechnology = eyeCareTechnology;
        this.brightness = brightness;
        this.hdrSupported = hdrSupported;
        this.builtInSpeakers = builtInSpeakers;
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.connections = connections;
    }

    @Override
    public String toString() {
        return "MonitorDTO{" +
                "screenSize=" + screenSize +
                ", resolution='" + resolution + '\'' +
                ", touchScreen=" + touchScreen +
                ", panelType=" + panelType +
                ", refreshRate=" + refreshRate +
                ", eyeCareTechnology=" + eyeCareTechnology +
                ", brightness=" + brightness +
                ", hdrSupported=" + hdrSupported +
                ", builtInSpeakers=" + builtInSpeakers +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", connections=" + connections +
                ", superClass=" + super.toString() +
                '}';
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public Monitor.EPanel getPanelType() {
        return panelType;
    }

    public void setPanelType(Monitor.EPanel panelType) {
        this.panelType = panelType;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public boolean isEyeCareTechnology() {
        return eyeCareTechnology;
    }

    public void setEyeCareTechnology(boolean eyeCareTechnology) {
        this.eyeCareTechnology = eyeCareTechnology;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public boolean isHdrSupported() {
        return hdrSupported;
    }

    public void setHdrSupported(boolean hdrSupported) {
        this.hdrSupported = hdrSupported;
    }

    public boolean isBuiltInSpeakers() {
        return builtInSpeakers;
    }

    public void setBuiltInSpeakers(boolean builtInSpeakers) {
        this.builtInSpeakers = builtInSpeakers;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Set<Monitor.EConnection> getConnections() {
        return connections;
    }

    public void setConnections(Set<Monitor.EConnection> connections) {
        this.connections = connections;
    }
}

