package com.webteam.laptopmall.product.builder.dto.keyboard;

import com.webteam.laptopmall.product.dto.MechanicalKeyboardDTO;
import com.webteam.laptopmall.product.entity.Laptop;
import com.webteam.laptopmall.product.entity.MechanicalKeyboard;

import java.util.Set;

public class KeyboardDTOBuilderImpl extends KeyboardDTOBuilder {

    public KeyboardDTOBuilderImpl() {
        prod = new MechanicalKeyboardDTO();
    }

    @Override
    public KeyboardDTOBuilder compatibilities(Set<Laptop.EOS> compatibilities) {
        prod.setCompatibilities(compatibilities);
        return this;
    }

    @Override
    public KeyboardDTOBuilder connections(Set<MechanicalKeyboard.EConnection> connections) {
        prod.setConnections(connections);
        return this;
    }

    @Override
    public KeyboardDTOBuilder cableLength(String cableLength) {
        prod.setCableLength(cableLength);
        return this;
    }

    @Override
    public KeyboardDTOBuilder switchType(String switchType) {
        prod.setSwitchType(switchType);
        return this;
    }

    @Override
    public KeyboardDTOBuilder layout(MechanicalKeyboard.ELayout layout) {
        prod.setLayout(layout);
        return this;
    }

    @Override
    public KeyboardDTOBuilder keyCount(int keyCount) {
        prod.setKeyCount(keyCount);
        return this;
    }

    @Override
    public KeyboardDTOBuilder keycapMaterial(String keycapMaterial) {
        prod.setKeycapMaterial(keycapMaterial);
        return this;
    }

    @Override
    public KeyboardDTOBuilder batteryType(String batteryType) {
        prod.setBatteryType(batteryType);
        return this;
    }

    @Override
    public MechanicalKeyboardDTO build() {
        return prod;
    }
}
