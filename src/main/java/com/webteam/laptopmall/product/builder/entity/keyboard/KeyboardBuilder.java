package com.webteam.laptopmall.product.builder.entity.keyboard;

import com.webteam.laptopmall.product.builder.entity.prod.ProductBuilderImpl;
import com.webteam.laptopmall.product.entity.Laptop;
import com.webteam.laptopmall.product.entity.MechanicalKeyboard;

import java.util.Set;

public abstract class KeyboardBuilder extends ProductBuilderImpl<MechanicalKeyboard> {
    public abstract KeyboardBuilder compatibilities(Set<Laptop.EOS> compatibilities);
    public abstract KeyboardBuilder connections(Set<MechanicalKeyboard.EConnection> connections);
    public abstract KeyboardBuilder cableLength(String cableLength);
    public abstract KeyboardBuilder switchType(String switchType);
    public abstract KeyboardBuilder layout(MechanicalKeyboard.ELayout layout);
    public abstract KeyboardBuilder keyCount(int keyCount);
    public abstract KeyboardBuilder keycapMaterial(String keycapMaterial);
    public abstract KeyboardBuilder batteryType(String batteryType);
}
