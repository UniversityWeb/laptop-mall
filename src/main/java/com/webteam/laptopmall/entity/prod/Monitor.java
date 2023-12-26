package com.webteam.laptopmall.entity.prod;

import com.webteam.laptopmall.customenum.ECategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "monitors")
@PrimaryKeyJoinColumn(name = "id")
public class Monitor extends Product {
    public enum EPanel {
        IPS,
        TN,
        OLED
    }

    public enum EConnection {
        HDMI,
        DisplayPort,
        USB_C,
        VGA,
        Thunderbolt
    }

    @Column(name = "screen_size")
    private double screenSize;
    @Column(name = "resolution")
    private String resolution;
    @Column(name = "touch_screen")
    private boolean touchScreen;
    @Column(name = "panel_type")
    @Enumerated(EnumType.STRING)
    private EPanel panelType;
    @Column(name = "refresh_rate")
    private int refreshRate;
    @Column(name = "eye_care_technology")
    private boolean eyeCareTechnology;
    private int brightness;
    @Column(name = "hdr_supported")
    private boolean hdrSupported;
    @Column(name = "built_in_speakers")
    private boolean builtInSpeakers;
    @Column(name = "power_consumption")
    private double powerConsumption;
    private double weight;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = EConnection.class)
    @CollectionTable(name = "monitor_connections", joinColumns = @JoinColumn(name = "monitor_id"))
    @Enumerated(EnumType.STRING)
    private Set<EConnection> connections;

    public Monitor() {
        super();
    }

    public Monitor(String brand, String model, String desc, BigDecimal price, Integer stockQty,
                   double discountPercent, String version, String color, ECategory category, int releaseYear,
                   double screenSize, String resolution, boolean touchScreen, EPanel panelType, int refreshRate,
                   boolean eyeCareTechnology, int brightness, boolean hdrSupported, boolean builtInSpeakers,
                   double powerConsumption, double weight, Set<EConnection> connections, boolean markAsDeleted) {
        super(brand, model, desc, price, stockQty, discountPercent, version, color, category, releaseYear,markAsDeleted);
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
        return "Monitor{" +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Monitor monitor = (Monitor) o;

        if (Double.compare(screenSize, monitor.screenSize) != 0) return false;
        if (touchScreen != monitor.touchScreen) return false;
        if (refreshRate != monitor.refreshRate) return false;
        if (eyeCareTechnology != monitor.eyeCareTechnology) return false;
        if (brightness != monitor.brightness) return false;
        if (hdrSupported != monitor.hdrSupported) return false;
        if (builtInSpeakers != monitor.builtInSpeakers) return false;
        if (Double.compare(powerConsumption, monitor.powerConsumption) != 0) return false;
        if (Double.compare(weight, monitor.weight) != 0) return false;
        if (!Objects.equals(resolution, monitor.resolution)) return false;
        if (panelType != monitor.panelType) return false;
        return Objects.equals(connections, monitor.connections);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(screenSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (resolution != null ? resolution.hashCode() : 0);
        result = 31 * result + (touchScreen ? 1 : 0);
        result = 31 * result + (panelType != null ? panelType.hashCode() : 0);
        result = 31 * result + refreshRate;
        result = 31 * result + (eyeCareTechnology ? 1 : 0);
        result = 31 * result + brightness;
        result = 31 * result + (hdrSupported ? 1 : 0);
        result = 31 * result + (builtInSpeakers ? 1 : 0);
        temp = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (connections != null ? connections.hashCode() : 0);
        return result;
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

    public EPanel getPanelType() {
        return panelType;
    }

    public void setPanelType(EPanel panelType) {
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

    public Set<EConnection> getConnections() {
        return connections;
    }

    public void setConnections(Set<EConnection> connections) {
        this.connections = connections;
    }
}
