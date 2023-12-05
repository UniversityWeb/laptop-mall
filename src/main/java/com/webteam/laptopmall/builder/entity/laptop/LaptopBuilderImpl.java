package com.webteam.laptopmall.builder.entity.laptop;


import com.webteam.laptopmall.entity.prod.Laptop;

public class LaptopBuilderImpl extends LaptopBuilder {

    public LaptopBuilderImpl() {
        prod = new Laptop();
    }

    @Override
    public LaptopBuilder cpuName(String cpuName) {
        prod.setCpuName(cpuName);
        return this;
    }

    @Override
    public LaptopBuilder cpuCores(int cpuCores) {
        prod.setCpuCores(cpuCores);
        return this;
    }

    @Override
    public LaptopBuilder cpuThreads(int cpuThreads) {
        prod.setCpuThreads(cpuThreads);
        return this;
    }

    @Override
    public LaptopBuilder cpuSpeed(double cpuSpeed) {
        prod.setCpuSpeed(cpuSpeed);
        return this;
    }

    @Override
    public LaptopBuilder cpuMaxSpeed(double cpuMaxSpeed) {
        prod.setCpuMaxSpeed(cpuMaxSpeed);
        return this;
    }

    @Override
    public LaptopBuilder cpuCache(int cpuCache) {
        prod.setCpuCache(cpuCache);
        return this;
    }

    @Override
    public LaptopBuilder ramSize(int ramSize) {
        prod.setRamSize(ramSize);
        return this;
    }

    @Override
    public LaptopBuilder ramType(Laptop.ERam ramType) {
        prod.setRamType(ramType);
        return this;
    }

    @Override
    public LaptopBuilder ramBusSpeed(int ramBusSpeed) {
        prod.setRamBusSpeed(ramBusSpeed);
        return this;
    }

    @Override
    public LaptopBuilder ramMaxSupport(int ramMaxSupport) {
        prod.setRamMaxSupport(ramMaxSupport);
        return this;
    }

    @Override
    public LaptopBuilder romType(Laptop.ERom romType) {
        prod.setRomType(romType);
        return this;
    }

    @Override
    public LaptopBuilder romSize(int romSize) {
        prod.setRomSize(romSize);
        return this;
    }

    @Override
    public LaptopBuilder screenSize(double screenSize) {
        prod.setScreenSize(screenSize);
        return this;
    }

    @Override
    public LaptopBuilder screenResolution(String screenResolution) {
        prod.setScreenResolution(screenResolution);
        return this;
    }

    @Override
    public LaptopBuilder screenRefreshRate(int screenRefreshRate) {
        prod.setScreenRefreshRate(screenRefreshRate);
        return this;
    }

    @Override
    public LaptopBuilder screenTechnology(String screenTechnology) {
        prod.setScreenTechnology(screenTechnology);
        return this;
    }

    @Override
    public LaptopBuilder brightness(int brightness) {
        prod.setBrightness(brightness);
        return this;
    }

    @Override
    public LaptopBuilder antiGlare(boolean antiGlare) {
        prod.setAntiGlare(antiGlare);
        return this;
    }

    @Override
    public LaptopBuilder graphicsCard(String graphicsCard) {
        prod.setGraphicsCard(graphicsCard);
        return this;
    }

    @Override
    public LaptopBuilder weight(double weight) {
        prod.setWeight(weight);
        return this;
    }

    @Override
    public LaptopBuilder material(String material) {
        prod.setMaterial(material);
        return this;
    }

    @Override
    public LaptopBuilder operatingSystem(Laptop.EOS operatingSystem) {
        prod.setOperatingSystem(operatingSystem);
        return this;
    }

    @Override
    public Laptop build() {
        return prod;
    }
}
