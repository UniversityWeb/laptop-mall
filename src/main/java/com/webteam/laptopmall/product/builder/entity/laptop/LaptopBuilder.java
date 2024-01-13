package com.webteam.laptopmall.product.builder.entity.laptop;

import com.webteam.laptopmall.product.builder.entity.prod.ProductBuilderImpl;
import com.webteam.laptopmall.product.entity.Laptop;

public abstract class LaptopBuilder extends ProductBuilderImpl<Laptop> {
    public abstract LaptopBuilder cpuName(String cpuName);
    public abstract LaptopBuilder cpuCores(int cpuCores);
    public abstract LaptopBuilder cpuThreads(int cpuThreads);
    public abstract LaptopBuilder cpuSpeed(double cpuSpeed);
    public abstract LaptopBuilder cpuMaxSpeed(double cpuMaxSpeed);
    public abstract LaptopBuilder cpuCache(int cpuCache);
    public abstract LaptopBuilder ramSize(int ramSize);
    public abstract LaptopBuilder ramType(Laptop.ERam ramType);
    public abstract LaptopBuilder ramBusSpeed(int ramBusSpeed);
    public abstract LaptopBuilder ramMaxSupport(int ramMaxSupport);
    public abstract LaptopBuilder romType(Laptop.ERom romType);
    public abstract LaptopBuilder romSize(int romSize);
    public abstract LaptopBuilder screenSize(double screenSize);
    public abstract LaptopBuilder screenResolution(String screenResolution);
    public abstract LaptopBuilder screenRefreshRate(int screenRefreshRate);
    public abstract LaptopBuilder screenTechnology(String screenTechnology);
    public abstract LaptopBuilder brightness(int brightness);
    public abstract LaptopBuilder antiGlare(boolean antiGlare);
    public abstract LaptopBuilder graphicsCard(String graphicsCard);
    public abstract LaptopBuilder weight(double weight);
    public abstract LaptopBuilder material(String material);
    public abstract LaptopBuilder operatingSystem(Laptop.EOS operatingSystem);
}
