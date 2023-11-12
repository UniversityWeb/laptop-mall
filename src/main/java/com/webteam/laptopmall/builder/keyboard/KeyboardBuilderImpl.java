package com.webteam.laptopmall.builder.keyboard;

import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;

import java.util.Set;

public class KeyboardBuilderImpl extends KeyboardBuilder {

    public KeyboardBuilderImpl() {
        prod = new MechanicalKeyboard();
    }

    @Override
    public KeyboardBuilder compatibilities(Set<Laptop.OS> compatibilities) {
        prod.setCompatibilities(compatibilities);
        return this;
    }

    @Override
    public KeyboardBuilder connections(Set<MechanicalKeyboard.EConnection> connections) {
        prod.setConnections(connections);
        return this;
    }

    @Override
    public KeyboardBuilder cableLength(String cableLength) {
        prod.setCableLength(cableLength);
        return this;
    }

    @Override
    public KeyboardBuilder switchType(String switchType) {
        prod.setSwitchType(switchType);
        return this;
    }

    @Override
    public KeyboardBuilder layout(MechanicalKeyboard.ELayout layout) {
        prod.setLayout(layout);
        return this;
    }

    @Override
    public KeyboardBuilder keyCount(int keyCount) {
        prod.setKeyCount(keyCount);
        return this;
    }

    @Override
    public KeyboardBuilder keycapMaterial(String keycapMaterial) {
        prod.setKeycapMaterial(keycapMaterial);
        return this;
    }

    @Override
    public KeyboardBuilder batteryType(String batteryType) {
        prod.setBatteryType(batteryType);
        return this;
    }

    @Override
    public MechanicalKeyboard build() {
        return prod;
    }
}
