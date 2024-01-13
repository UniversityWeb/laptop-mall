package com.webteam.laptopmall.product.builder.dto.monitor;


import com.webteam.laptopmall.product.dto.MonitorDTO;
import com.webteam.laptopmall.product.entity.Monitor;

import java.util.Set;

public class MonitorDTOBuilderImpl extends MonitorDTOBuilder {

    public MonitorDTOBuilderImpl() {
        prod = new MonitorDTO();
    }

    @Override
    public MonitorDTOBuilder screenSize(double screenSize) {
        prod.setScreenSize(screenSize);
        return this;
    }

    @Override
    public MonitorDTOBuilder resolution(String resolution) {
        prod.setResolution(resolution);
        return this;
    }

    @Override
    public MonitorDTOBuilder touchScreen(boolean touchScreen) {
        prod.setTouchScreen(touchScreen);
        return this;
    }

    @Override
    public MonitorDTOBuilder panelType(Monitor.EPanel panelType) {
        prod.setPanelType(panelType);
        return this;
    }

    @Override
    public MonitorDTOBuilder refreshRate(int refreshRate) {
        prod.setRefreshRate(refreshRate);
        return this;
    }

    @Override
    public MonitorDTOBuilder eyeCareTechnology(boolean eyeCareTechnology) {
        prod.setEyeCareTechnology(eyeCareTechnology);
        return this;
    }

    @Override
    public MonitorDTOBuilder brightness(int brightness) {
        prod.setBrightness(brightness);
        return this;
    }

    @Override
    public MonitorDTOBuilder hdrSupported(boolean hdrSupported) {
        prod.setHdrSupported(hdrSupported);
        return this;
    }

    @Override
    public MonitorDTOBuilder builtInSpeakers(boolean builtInSpeakers) {
        prod.setBuiltInSpeakers(builtInSpeakers);
        return this;
    }

    @Override
    public MonitorDTOBuilder powerConsumption(double powerConsumption) {
        prod.setPowerConsumption(powerConsumption);
        return this;
    }

    @Override
    public MonitorDTOBuilder weight(double weight) {
        prod.setWeight(weight);
        return this;
    }

    @Override
    public MonitorDTOBuilder connections(Set<Monitor.EConnection> connections) {
        prod.setConnections(connections);
        return this;
    }

    @Override
    public MonitorDTO build() {
        return prod;
    }
}
