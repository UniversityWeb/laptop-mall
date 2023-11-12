package com.webteam.laptopmall.builder.monitor;


import com.webteam.laptopmall.entity.prod.Monitor;

import java.util.Set;

public class MonitorBuilderImpl extends MonitorBuilder {

    public MonitorBuilderImpl() {
        prod = new Monitor();
    }

    @Override
    public MonitorBuilder screenSize(double screenSize) {
        prod.setScreenSize(screenSize);
        return this;
    }

    @Override
    public MonitorBuilder resolution(String resolution) {
        prod.setResolution(resolution);
        return this;
    }

    @Override
    public MonitorBuilder touchScreen(boolean touchScreen) {
        prod.setTouchScreen(touchScreen);
        return this;
    }

    @Override
    public MonitorBuilder panelType(Monitor.EPanel panelType) {
        prod.setPanelType(panelType);
        return this;
    }

    @Override
    public MonitorBuilder refreshRate(int refreshRate) {
        prod.setRefreshRate(refreshRate);
        return this;
    }

    @Override
    public MonitorBuilder eyeCareTechnology(boolean eyeCareTechnology) {
        prod.setEyeCareTechnology(eyeCareTechnology);
        return this;
    }

    @Override
    public MonitorBuilder brightness(int brightness) {
        prod.setBrightness(brightness);
        return this;
    }

    @Override
    public MonitorBuilder hdrSupported(boolean hdrSupported) {
        prod.setHdrSupported(hdrSupported);
        return this;
    }

    @Override
    public MonitorBuilder builtInSpeakers(boolean builtInSpeakers) {
        prod.setBuiltInSpeakers(builtInSpeakers);
        return this;
    }

    @Override
    public MonitorBuilder powerConsumption(double powerConsumption) {
        prod.setPowerConsumption(powerConsumption);
        return this;
    }

    @Override
    public MonitorBuilder weight(double weight) {
        prod.setWeight(weight);
        return this;
    }

    @Override
    public MonitorBuilder connections(Set<Monitor.EConnection> connections) {
        prod.setConnections(connections);
        return this;
    }

    @Override
    public Monitor build() {
        return prod;
    }
}
