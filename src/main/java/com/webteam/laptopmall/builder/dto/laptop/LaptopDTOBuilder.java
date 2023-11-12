package com.webteam.laptopmall.builder.dto.laptop;

import com.webteam.laptopmall.builder.dto.prod.ProductDTOBuilderImpl;
import com.webteam.laptopmall.dto.prod.LaptopDTO;
import com.webteam.laptopmall.entity.prod.Laptop;

public abstract class LaptopDTOBuilder extends ProductDTOBuilderImpl<LaptopDTO> {
    public abstract LaptopDTOBuilder cpuName(String cpuName);
    public abstract LaptopDTOBuilder cpuCores(int cpuCores);
    public abstract LaptopDTOBuilder cpuThreads(int cpuThreads);
    public abstract LaptopDTOBuilder cpuSpeed(double cpuSpeed);
    public abstract LaptopDTOBuilder cpuMaxSpeed(double cpuMaxSpeed);
    public abstract LaptopDTOBuilder cpuCache(int cpuCache);
    public abstract LaptopDTOBuilder ramSize(int ramSize);
    public abstract LaptopDTOBuilder ramType(Laptop.ERam ramType);
    public abstract LaptopDTOBuilder ramBusSpeed(int ramBusSpeed);
    public abstract LaptopDTOBuilder ramMaxSupport(int ramMaxSupport);
    public abstract LaptopDTOBuilder romType(Laptop.ERom romType);
    public abstract LaptopDTOBuilder romSize(int romSize);
    public abstract LaptopDTOBuilder screenSize(double screenSize);
    public abstract LaptopDTOBuilder screenResolution(String screenResolution);
    public abstract LaptopDTOBuilder screenRefreshRate(int screenRefreshRate);
    public abstract LaptopDTOBuilder screenTechnology(String screenTechnology);
    public abstract LaptopDTOBuilder brightness(int brightness);
    public abstract LaptopDTOBuilder antiGlare(boolean antiGlare);
    public abstract LaptopDTOBuilder graphicsCard(String graphicsCard);
    public abstract LaptopDTOBuilder weight(double weight);
    public abstract LaptopDTOBuilder material(String material);
    public abstract LaptopDTOBuilder operatingSystem(Laptop.OS operatingSystem);
}
