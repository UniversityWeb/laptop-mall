package com.webteam.laptopmall.dto.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.entity.prod.Laptop;

import java.math.BigDecimal;

public class LaptopDTO extends ProductDTO {
    private String cpuName;
    private int cpuCores;
    private int cpuThreads;
    private double cpuSpeed;
    private double cpuMaxSpeed;
    private int cpuCache;
    private int ramSize;
    private Laptop.ERam ramType;
    private int ramBusSpeed;
    private int ramMaxSupport;
    private Laptop.ERom romType;
    private int romSize;
    private double screenSize;
    private String screenResolution;
    private int screenRefreshRate;
    private String screenTechnology;
    private int brightness;
    private boolean antiGlare;
    private String graphicsCard;
    private double weight;
    private String material;
    private Laptop.EOS operatingSystem;

    public LaptopDTO() {
    }

    public LaptopDTO(Long id, String brand, String model, String desc, BigDecimal price, Integer stockQty,
                     double discountPercent, String version, String color, int releaseYear, ECategory category,
                     String cpuName, int cpuCores, int cpuThreads, double cpuSpeed, double cpuMaxSpeed,
                     int cpuCache, int ramSize, Laptop.ERam ramType, int ramBusSpeed, int ramMaxSupport,
                     Laptop.ERom romType, int romSize, double screenSize, String screenResolution,
                     int screenRefreshRate, String screenTechnology, int brightness, boolean antiGlare,
                     String graphicsCard, double weight, String material, Laptop.EOS operatingSystem, boolean markAsDeleted) {
        super(id, brand, model, desc, price, stockQty, discountPercent, version, color, releaseYear, category, markAsDeleted);
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
        return "LaptopDTO{" +
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
                ", operatingSystem=" + operatingSystem +
                ", superClass=" + super.toString() +
                '}';
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

    public Laptop.ERam getRamType() {
        return ramType;
    }

    public void setRamType(Laptop.ERam ramType) {
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

    public Laptop.ERom getRomType() {
        return romType;
    }

    public void setRomType(Laptop.ERom romType) {
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

    public Laptop.EOS getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(Laptop.EOS operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
