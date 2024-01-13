package com.webteam.laptopmall.product.entity;

import com.webteam.laptopmall.product.ECategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "laptops")
@PrimaryKeyJoinColumn(name = "id")
public class Laptop extends Product {
    public enum ERam {
        DDR3,
        DDR4,
    }

    public enum ERom {
        HDD,
        SSD
    }

    public enum EOS {
        WINDOWS, MAC, LINUX
    }

    @Column(name = "cpu_name")
    private String cpuName;
    @Column(name = "cpu_cores")
    private int cpuCores;
    @Column(name = "cpu_threads")
    private int cpuThreads;
    @Column(name = "cpu_speed")
    private double cpuSpeed;
    @Column(name = "cpu_max_speed")
    private double cpuMaxSpeed;
    @Column(name = "cpu_cache")
    private int cpuCache;

    @Column(name = "ram_size")
    private int ramSize;
    @Column(name = "ram_type")
    @Enumerated(EnumType.STRING)
    private ERam ramType;
    @Column(name = "ram_bus_speed")
    private int ramBusSpeed;
    @Column(name = "ram_max_support")
    private int ramMaxSupport;

    @Column(name = "rom_type")
    @Enumerated(EnumType.STRING)
    private ERom romType;
    @Column(name = "rom_size")
    private int romSize;

    @Column(name = "screen_size")
    private double screenSize;
    @Column(name = "screen_resolution")
    private String screenResolution;
    @Column(name = "screen_refresh_rate")
    private int screenRefreshRate;
    @Column(name = "screen_technology")
    private String screenTechnology;

    private int brightness;
    @Column(name = "anti_glare")
    private boolean antiGlare;

    @Column(name = "graphics_card")
    private String graphicsCard;

    private double weight;
    private String material;

    @Column(name = "operating_system")
    @Enumerated(EnumType.STRING)
    private EOS operatingSystem;

    public Laptop() {
        super();
    }

    public Laptop(String brand, String model, String desc, BigDecimal price, Integer stockQty,
                  double discountPercent, String version, String color, ECategory category, int releaseYear,
                  String cpuName, int cpuCores, int cpuThreads, double cpuSpeed, double cpuMaxSpeed,
                  int cpuCache, int ramSize, ERam ramType, int ramBusSpeed, int ramMaxSupport,
                  ERom romType, int romSize, double screenSize, String screenResolution,
                  int screenRefreshRate, String screenTechnology, int brightness, boolean antiGlare,
                  String graphicsCard, double weight, String material, EOS operatingSystem, boolean markAsDeleted) {
        super(brand, model, desc, price, stockQty, discountPercent, version, color, category, releaseYear,markAsDeleted);
        this.cpuName = cpuName;
        this.cpuCores = cpuCores;
        this.cpuThreads = cpuThreads;
        this.cpuSpeed = cpuSpeed;
        this.cpuMaxSpeed = cpuMaxSpeed;
        this.cpuCache = cpuCache;
        this.ramSize = ramSize;
        this.ramType = ramType;
        this.ramBusSpeed = ramBusSpeed;
        this.ramMaxSupport = ramMaxSupport;
        this.romType = romType;
        this.romSize = romSize;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.screenRefreshRate = screenRefreshRate;
        this.screenTechnology = screenTechnology;
        this.brightness = brightness;
        this.antiGlare = antiGlare;
        this.graphicsCard = graphicsCard;
        this.weight = weight;
        this.material = material;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cpuName='" + cpuName + '\'' +
                ", cpuCores=" + cpuCores +
                ", cpuThreads=" + cpuThreads +
                ", cpuSpeed=" + cpuSpeed +
                ", cpuMaxSpeed=" + cpuMaxSpeed +
                ", cpuCache=" + cpuCache +
                ", ramSize=" + ramSize +
                ", ramType=" + ramType +
                ", ramBusSpeed=" + ramBusSpeed +
                ", ramMaxSupport=" + ramMaxSupport +
                ", romType=" + romType +
                ", romSize=" + romSize +
                ", screenSize=" + screenSize +
                ", screenResolution='" + screenResolution + '\'' +
                ", screenRefreshRate=" + screenRefreshRate +
                ", screenTechnology='" + screenTechnology + '\'' +
                ", brightness=" + brightness +
                ", antiGlare=" + antiGlare +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", superClass=" + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        if (cpuCores != laptop.cpuCores) return false;
        if (cpuThreads != laptop.cpuThreads) return false;
        if (Double.compare(cpuSpeed, laptop.cpuSpeed) != 0) return false;
        if (Double.compare(cpuMaxSpeed, laptop.cpuMaxSpeed) != 0) return false;
        if (cpuCache != laptop.cpuCache) return false;
        if (ramSize != laptop.ramSize) return false;
        if (ramBusSpeed != laptop.ramBusSpeed) return false;
        if (ramMaxSupport != laptop.ramMaxSupport) return false;
        if (romSize != laptop.romSize) return false;
        if (Double.compare(screenSize, laptop.screenSize) != 0) return false;
        if (screenRefreshRate != laptop.screenRefreshRate) return false;
        if (brightness != laptop.brightness) return false;
        if (antiGlare != laptop.antiGlare) return false;
        if (Double.compare(weight, laptop.weight) != 0) return false;
        if (!Objects.equals(cpuName, laptop.cpuName)) return false;
        if (ramType != laptop.ramType) return false;
        if (romType != laptop.romType) return false;
        if (!Objects.equals(screenResolution, laptop.screenResolution))
            return false;
        if (!Objects.equals(screenTechnology, laptop.screenTechnology))
            return false;
        if (!Objects.equals(graphicsCard, laptop.graphicsCard))
            return false;
        if (!Objects.equals(material, laptop.material)) return false;
        return Objects.equals(operatingSystem, laptop.operatingSystem);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (cpuName != null ? cpuName.hashCode() : 0);
        result = 31 * result + cpuCores;
        result = 31 * result + cpuThreads;
        temp = Double.doubleToLongBits(cpuSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cpuMaxSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cpuCache;
        result = 31 * result + ramSize;
        result = 31 * result + (ramType != null ? ramType.hashCode() : 0);
        result = 31 * result + ramBusSpeed;
        result = 31 * result + ramMaxSupport;
        result = 31 * result + (romType != null ? romType.hashCode() : 0);
        result = 31 * result + romSize;
        temp = Double.doubleToLongBits(screenSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (screenResolution != null ? screenResolution.hashCode() : 0);
        result = 31 * result + screenRefreshRate;
        result = 31 * result + (screenTechnology != null ? screenTechnology.hashCode() : 0);
        result = 31 * result + brightness;
        result = 31 * result + (antiGlare ? 1 : 0);
        result = 31 * result + (graphicsCard != null ? graphicsCard.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (operatingSystem != null ? operatingSystem.hashCode() : 0);
        return result;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public int getCpuThreads() {
        return cpuThreads;
    }

    public void setCpuThreads(int cpuThreads) {
        this.cpuThreads = cpuThreads;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public double getCpuMaxSpeed() {
        return cpuMaxSpeed;
    }

    public void setCpuMaxSpeed(double cpuMaxSpeed) {
        this.cpuMaxSpeed = cpuMaxSpeed;
    }

    public int getCpuCache() {
        return cpuCache;
    }

    public void setCpuCache(int cpuCache) {
        this.cpuCache = cpuCache;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public ERam getRamType() {
        return ramType;
    }

    public void setRamType(ERam ramType) {
        this.ramType = ramType;
    }

    public int getRamBusSpeed() {
        return ramBusSpeed;
    }

    public void setRamBusSpeed(int ramBusSpeed) {
        this.ramBusSpeed = ramBusSpeed;
    }

    public int getRamMaxSupport() {
        return ramMaxSupport;
    }

    public void setRamMaxSupport(int ramMaxSupport) {
        this.ramMaxSupport = ramMaxSupport;
    }

    public ERom getRomType() {
        return romType;
    }

    public void setRomType(ERom romType) {
        this.romType = romType;
    }

    public int getRomSize() {
        return romSize;
    }

    public void setRomSize(int romSize) {
        this.romSize = romSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public int getScreenRefreshRate() {
        return screenRefreshRate;
    }

    public void setScreenRefreshRate(int screenRefreshRate) {
        this.screenRefreshRate = screenRefreshRate;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public void setScreenTechnology(String screenTechnology) {
        this.screenTechnology = screenTechnology;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public boolean isAntiGlare() {
        return antiGlare;
    }

    public void setAntiGlare(boolean antiGlare) {
        this.antiGlare = antiGlare;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public EOS getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(EOS operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
