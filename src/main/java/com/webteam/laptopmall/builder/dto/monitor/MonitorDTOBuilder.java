package com.webteam.laptopmall.builder.dto.monitor;

import com.webteam.laptopmall.builder.dto.prod.ProductDTOBuilderImpl;
import com.webteam.laptopmall.dto.prod.MonitorDTO;
import com.webteam.laptopmall.entity.prod.Monitor;

import java.util.Set;

public abstract class MonitorDTOBuilder extends ProductDTOBuilderImpl<MonitorDTO> {
    public abstract MonitorDTOBuilder screenSize(double screenSize);
    public abstract MonitorDTOBuilder resolution(String resolution);
    public abstract MonitorDTOBuilder touchScreen(boolean touchScreen);
    public abstract MonitorDTOBuilder panelType(Monitor.EPanel panelType);
    public abstract MonitorDTOBuilder refreshRate(int refreshRate);
    public abstract MonitorDTOBuilder eyeCareTechnology(boolean eyeCareTechnology);
    public abstract MonitorDTOBuilder brightness(int brightness);
    public abstract MonitorDTOBuilder hdrSupported(boolean hdrSupported);
    public abstract MonitorDTOBuilder builtInSpeakers(boolean builtInSpeakers);
    public abstract MonitorDTOBuilder powerConsumption(double powerConsumption);
    public abstract MonitorDTOBuilder weight(double weight);
    public abstract MonitorDTOBuilder connections(Set<Monitor.EConnection> connections);
}
