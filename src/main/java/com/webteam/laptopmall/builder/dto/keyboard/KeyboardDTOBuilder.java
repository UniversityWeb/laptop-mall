package com.webteam.laptopmall.builder.dto.keyboard;

import com.webteam.laptopmall.builder.dto.prod.ProductDTOBuilderImpl;
import com.webteam.laptopmall.dto.prod.MechanicalKeyboardDTO;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;

import java.util.Set;

public abstract class KeyboardDTOBuilder extends ProductDTOBuilderImpl<MechanicalKeyboardDTO> {
    public abstract KeyboardDTOBuilder compatibilities(Set<Laptop.OS> compatibilities);
    public abstract KeyboardDTOBuilder connections(Set<MechanicalKeyboard.EConnection> connections);
    public abstract KeyboardDTOBuilder cableLength(String cableLength);
    public abstract KeyboardDTOBuilder switchType(String switchType);
    public abstract KeyboardDTOBuilder layout(MechanicalKeyboard.ELayout layout);
    public abstract KeyboardDTOBuilder keyCount(int keyCount);
    public abstract KeyboardDTOBuilder keycapMaterial(String keycapMaterial);
    public abstract KeyboardDTOBuilder batteryType(String batteryType);
}
