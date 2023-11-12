package com.webteam.laptopmall.dto.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;

import java.math.BigDecimal;
import java.util.Set;

public class MechanicalKeyboardDTO extends ProductDTO {
    private Set<Laptop.OS> compatibilities;
    private Set<MechanicalKeyboard.EConnection> connections;
    private String cableLength;
    private String switchType;
    private MechanicalKeyboard.ELayout layout;
    private int keyCount;
    private String keycapMaterial;
    private String batteryType;

    public MechanicalKeyboardDTO() {
    }

    public MechanicalKeyboardDTO(Long id, String brand, String model, String desc, BigDecimal price,
                                 Integer stockQty, double discountPercent, String version, String color,
                                 int releaseYear, ECategory category, Set<Laptop.OS> compatibilities,
                                 Set<MechanicalKeyboard.EConnection> connections, String cableLength,
                                 String switchType, MechanicalKeyboard.ELayout layout,
                                 int keyCount, String keycapMaterial, String batteryType) {
        super(id, brand, model, desc, price, stockQty, discountPercent, version, color, releaseYear, category);
        this.compatibilities = compatibilities;
        this.connections = connections;
        this.cableLength = cableLength;
        this.switchType = switchType;
        this.layout = layout;
        this.keyCount = keyCount;
        this.keycapMaterial = keycapMaterial;
        this.batteryType = batteryType;
    }

    @Override
    public String toString() {
        return "MechanicalKeyboardDTO{" +
                "compatibilities=" + compatibilities +
                ", connections=" + connections +
                ", cableLength='" + cableLength + '\'' +
                ", switchType='" + switchType + '\'' +
                ", layout=" + layout +
                ", keyCount=" + keyCount +
                ", keycapMaterial='" + keycapMaterial + '\'' +
                ", batteryType='" + batteryType + '\'' +
                ", superClass=" + super.toString() +
                '}';
    }

    public Set<Laptop.OS> getCompatibilities() {
        return compatibilities;
    }

    public void setCompatibilities(Set<Laptop.OS> compatibilities) {
        this.compatibilities = compatibilities;
    }

    public Set<MechanicalKeyboard.EConnection> getConnections() {
        return connections;
    }

    public void setConnections(Set<MechanicalKeyboard.EConnection> connections) {
        this.connections = connections;
    }

    public String getCableLength() {
        return cableLength;
    }

    public void setCableLength(String cableLength) {
        this.cableLength = cableLength;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    public MechanicalKeyboard.ELayout getLayout() {
        return layout;
    }

    public void setLayout(MechanicalKeyboard.ELayout layout) {
        this.layout = layout;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    public String getKeycapMaterial() {
        return keycapMaterial;
    }

    public void setKeycapMaterial(String keycapMaterial) {
        this.keycapMaterial = keycapMaterial;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }
}
