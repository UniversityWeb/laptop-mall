package com.webteam.laptopmall.builder.dto.laptop;


import com.webteam.laptopmall.dto.prod.LaptopDTO;
import com.webteam.laptopmall.entity.prod.Laptop;

public class LaptopDTOBuilderImpl extends LaptopDTOBuilder {

    public LaptopDTOBuilderImpl() {
        prod = new LaptopDTO();
    }

    @Override
    public LaptopDTOBuilder cpuName(String cpuName) {
        prod.setCpuName(cpuName);
        return this;
    }

    @Override
    public LaptopDTOBuilder cpuCores(int cpuCores) {
        prod.setCpuCores(cpuCores);
        return this;
    }

    @Override
    public LaptopDTOBuilder cpuThreads(int cpuThreads) {
        prod.setCpuThreads(cpuThreads);
        return this;
    }

    @Override
    public LaptopDTOBuilder cpuSpeed(double cpuSpeed) {
        prod.setCpuSpeed(cpuSpeed);
        return this;
    }

    @Override
    public LaptopDTOBuilder cpuMaxSpeed(double cpuMaxSpeed) {
        prod.setCpuMaxSpeed(cpuMaxSpeed);
        return this;
    }

    @Override
    public LaptopDTOBuilder cpuCache(int cpuCache) {
        prod.setCpuCache(cpuCache);
        return this;
    }

    @Override
    public LaptopDTOBuilder ramSize(int ramSize) {
        prod.setRamSize(ramSize);
        return this;
    }

    @Override
    public LaptopDTOBuilder ramType(Laptop.ERam ramType) {
        prod.setRamType(ramType);
        return this;
    }

    @Override
    public LaptopDTOBuilder ramBusSpeed(int ramBusSpeed) {
        prod.setRamBusSpeed(ramBusSpeed);
        return this;
    }

    @Override
    public LaptopDTOBuilder ramMaxSupport(int ramMaxSupport) {
        prod.setRamMaxSupport(ramMaxSupport);
        return this;
    }

    @Override
    public LaptopDTOBuilder romType(Laptop.ERom romType) {
        prod.setRomType(romType);
        return this;
    }

    @Override
    public LaptopDTOBuilder romSize(int romSize) {
        prod.setRomSize(romSize);
        return this;
    }

    @Override
    public LaptopDTOBuilder screenSize(double screenSize) {
        prod.setScreenSize(screenSize);
        return this;
    }

    @Override
    public LaptopDTOBuilder screenResolution(String screenResolution) {
        prod.setScreenResolution(screenResolution);
        return this;
    }

    @Override
    public LaptopDTOBuilder screenRefreshRate(int screenRefreshRate) {
        prod.setScreenRefreshRate(screenRefreshRate);
        return this;
    }

    @Override
    public LaptopDTOBuilder screenTechnology(String screenTechnology) {
        prod.setScreenTechnology(screenTechnology);
        return this;
    }

    @Override
    public LaptopDTOBuilder brightness(int brightness) {
        prod.setBrightness(brightness);
        return this;
    }

    @Override
    public LaptopDTOBuilder antiGlare(boolean antiGlare) {
        prod.setAntiGlare(antiGlare);
        return this;
    }

    @Override
    public LaptopDTOBuilder graphicsCard(String graphicsCard) {
        prod.setGraphicsCard(graphicsCard);
        return this;
    }

    @Override
    public LaptopDTOBuilder weight(double weight) {
        prod.setWeight(weight);
        return this;
    }

    @Override
    public LaptopDTOBuilder material(String material) {
        prod.setMaterial(material);
        return this;
    }

    @Override
    public LaptopDTOBuilder operatingSystem(Laptop.EOS operatingSystem) {
        prod.setOperatingSystem(operatingSystem);
        return this;
    }

    @Override
    public LaptopDTO build() {
        return prod;
    }
}
