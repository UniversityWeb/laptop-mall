package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.builder.dto.keyboard.KeyboardDTOBuilder;
import com.webteam.laptopmall.builder.dto.keyboard.KeyboardDTOBuilderImpl;
import com.webteam.laptopmall.builder.dto.laptop.LaptopDTOBuilder;
import com.webteam.laptopmall.builder.dto.laptop.LaptopDTOBuilderImpl;
import com.webteam.laptopmall.builder.dto.monitor.MonitorDTOBuilder;
import com.webteam.laptopmall.builder.dto.monitor.MonitorDTOBuilderImpl;
import com.webteam.laptopmall.builder.entity.keyboard.KeyboardBuilder;
import com.webteam.laptopmall.builder.entity.keyboard.KeyboardBuilderImpl;
import com.webteam.laptopmall.builder.entity.laptop.LaptopBuilder;
import com.webteam.laptopmall.builder.entity.laptop.LaptopBuilderImpl;
import com.webteam.laptopmall.builder.entity.monitor.MonitorBuilder;
import com.webteam.laptopmall.builder.entity.monitor.MonitorBuilderImpl;
import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.LaptopDTO;
import com.webteam.laptopmall.dto.prod.MechanicalKeyboardDTO;
import com.webteam.laptopmall.dto.prod.MonitorDTO;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;
import com.webteam.laptopmall.entity.prod.Monitor;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    @Nested
    class LaptopMapperTest {
        @Test
        void testToLaptopDTO() {
            // Setup
            Laptop product = laptopBuilder();

            // Action
            LaptopDTO productDTO = (LaptopDTO) ProductMapper.toDTO(product);

            // Assert
            // Common fields
            assertEquals(product.getId(), productDTO.getId());
            assertEquals(product.getBrand(), productDTO.getBrand());
            assertEquals(product.getModel(), productDTO.getModel());
            assertEquals(product.getDesc(), productDTO.getDesc());
            assertEquals(product.getPrice(), productDTO.getPrice());
            assertEquals(product.getStockQty(), productDTO.getStockQty());
            assertEquals(product.getVersion(), productDTO.getVersion());
            assertEquals(product.getColor(), productDTO.getColor());

            // Laptop fields
            assertEquals(product.getCpuName(), productDTO.getCpuName());
            assertEquals(product.getCpuCores(), productDTO.getCpuCores());
            assertEquals(product.getCpuThreads(), productDTO.getCpuThreads());
            assertEquals(product.getCpuSpeed(), productDTO.getCpuSpeed());
            assertEquals(product.getCpuMaxSpeed(), productDTO.getCpuMaxSpeed());
            assertEquals(product.getCpuCache(), productDTO.getCpuCache());

            assertEquals(product.getRamSize(), productDTO.getRamSize());
            assertEquals(product.getRamType(), productDTO.getRamType());
            assertEquals(product.getRamBusSpeed(), productDTO.getRamBusSpeed());
            assertEquals(product.getRamMaxSupport(), productDTO.getRamMaxSupport());

            assertEquals(product.getRomType(), productDTO.getRomType());
            assertEquals(product.getRomSize(), productDTO.getRomSize());

            assertEquals(product.getScreenSize(), productDTO.getScreenSize());
            assertEquals(product.getScreenResolution(), productDTO.getScreenResolution());
            assertEquals(product.getScreenRefreshRate(), productDTO.getScreenRefreshRate());
            assertEquals(product.getScreenTechnology(), productDTO.getScreenTechnology());

            assertEquals(product.getBrightness(), productDTO.getBrightness());
            assertEquals(product.isAntiGlare(), productDTO.isAntiGlare());

            assertEquals(product.getGraphicsCard(), productDTO.getGraphicsCard());

            assertEquals(product.getWeight(), productDTO.getWeight());
            assertEquals(product.getMaterial(), productDTO.getMaterial());

            assertEquals(product.getOperatingSystem(), productDTO.getOperatingSystem());
        }

        private Laptop laptopBuilder() {
            LaptopBuilder builder = new LaptopBuilderImpl();
            return builder
                    .cpuName("Intel Core i5")
                    .cpuCores(4)
                    .cpuThreads(8)
                    .cpuSpeed(2.5)
                    .cpuMaxSpeed(4.0)
                    .cpuCache(8)
                    .ramSize(16)
                    .ramType(Laptop.ERam.DDR4)
                    .ramBusSpeed(3200)
                    .ramMaxSupport(32)
                    .romType(Laptop.ERom.SSD)
                    .romSize(512)
                    .screenSize(15.6)
                    .screenResolution("1920 x 1080")
                    .screenRefreshRate(60)
                    .screenTechnology("LED")
                    .brightness(250)
                    .antiGlare(true)
                    .graphicsCard("Nvidia GeForce GTX 1650")
                    .weight(2.3)
                    .material("Aluminum")
                    .operatingSystem(Laptop.EOS.WINDOWS)
                    .id(1L)
                    .brand("HP")
                    .model("Pavilion")
                    .desc("Powerful and stylish laptop for everyday use")
                    .price(new BigDecimal("799.99"))
                    .stockQty(50)
                    .discountPercent(10.0)
                    .version("1.0")
                    .color("Silver")
                    .category(ECategory.LAPTOP)
                    .releaseYear(2022)
                    .build();
        }

        @Test
        void testToLaptopEntity() {
            // Setup
            LaptopDTO productDTO = laptopDTOBuilder();

            // Action
            Laptop product = ProductMapper.LaptopMapper.INSTANCE.toEntity(productDTO);

            // Assert
            // Common fields
            assertEquals(productDTO.getId(), product.getId());
            assertEquals(productDTO.getBrand(), product.getBrand());
            assertEquals(productDTO.getModel(), product.getModel());
            assertEquals(productDTO.getDesc(), product.getDesc());
            assertEquals(productDTO.getPrice(), product.getPrice());
            assertEquals(productDTO.getStockQty(), product.getStockQty());
            assertEquals(productDTO.getVersion(), product.getVersion());
            assertEquals(productDTO.getColor(), product.getColor());

            // laptop fields
            assertEquals(productDTO.getCpuName(), product.getCpuName());
            assertEquals(productDTO.getCpuCores(), product.getCpuCores());
            assertEquals(productDTO.getCpuThreads(), product.getCpuThreads());
            assertEquals(productDTO.getCpuSpeed(), product.getCpuSpeed());
            assertEquals(productDTO.getCpuMaxSpeed(), product.getCpuMaxSpeed());
            assertEquals(productDTO.getCpuCache(), product.getCpuCache());

            assertEquals(productDTO.getRamSize(), product.getRamSize());
            assertEquals(productDTO.getRamType(), product.getRamType());
            assertEquals(productDTO.getRamBusSpeed(), product.getRamBusSpeed());
            assertEquals(productDTO.getRamMaxSupport(), product.getRamMaxSupport());

            assertEquals(productDTO.getRomType(), product.getRomType());
            assertEquals(productDTO.getRomSize(), product.getRomSize());

            assertEquals(productDTO.getScreenSize(), product.getScreenSize());
            assertEquals(productDTO.getScreenResolution(), product.getScreenResolution());
            assertEquals(productDTO.getScreenRefreshRate(), product.getScreenRefreshRate());
            assertEquals(productDTO.getScreenTechnology(), product.getScreenTechnology());

            assertEquals(productDTO.getBrightness(), product.getBrightness());
            assertEquals(productDTO.isAntiGlare(), product.isAntiGlare());

            assertEquals(productDTO.getGraphicsCard(), product.getGraphicsCard());

            assertEquals(productDTO.getWeight(), product.getWeight());
            assertEquals(productDTO.getMaterial(), product.getMaterial());

            assertEquals(productDTO.getOperatingSystem(), product.getOperatingSystem());
        }

        private LaptopDTO laptopDTOBuilder() {
            LaptopDTOBuilder builder = new LaptopDTOBuilderImpl();
            return builder
                    .cpuName("Intel Core i5")
                    .cpuCores(4)
                    .cpuThreads(8)
                    .cpuSpeed(2.5)
                    .cpuMaxSpeed(4.0)
                    .cpuCache(8)
                    .ramSize(16)
                    .ramType(Laptop.ERam.DDR4)
                    .ramBusSpeed(3200)
                    .ramMaxSupport(32)
                    .romType(Laptop.ERom.SSD)
                    .romSize(512)
                    .screenSize(15.6)
                    .screenResolution("1920 x 1080")
                    .screenRefreshRate(60)
                    .screenTechnology("LED")
                    .brightness(250)
                    .antiGlare(true)
                    .graphicsCard("Nvidia GeForce GTX 1650")
                    .weight(2.3)
                    .material("Aluminum")
                    .operatingSystem(Laptop.EOS.WINDOWS)
                    .id(1L)
                    .brand("HP")
                    .model("Pavilion")
                    .desc("Powerful and stylish laptop for everyday use")
                    .price(new BigDecimal("799.99"))
                    .stockQty(50)
                    .discountPercent(10.0)
                    .version("1.0")
                    .color("Silver")
                    .category(ECategory.LAPTOP)
                    .releaseYear(2022)
                    .build();
        }
    }

    @Nested
    class MechanicalKeyboardMapperTest {
        @Test
        void testToMechanicalKeyboardDTO() {
            // Setup
            MechanicalKeyboard keyboard = keyboardBuilder();

            // Action
            MechanicalKeyboardDTO keyboardDTO = ProductMapper.MechanicalKeyboardMapper.INSTANCE.toDTO(keyboard);

            // Assert
            // Common fields
            assertEquals(keyboard.getId(), keyboardDTO.getId());
            assertEquals(keyboard.getBrand(), keyboardDTO.getBrand());
            assertEquals(keyboard.getModel(), keyboardDTO.getModel());
            assertEquals(keyboard.getDesc(), keyboardDTO.getDesc());
            assertEquals(keyboard.getPrice(), keyboardDTO.getPrice());
            assertEquals(keyboard.getStockQty(), keyboardDTO.getStockQty());
            assertEquals(keyboard.getVersion(), keyboardDTO.getVersion());
            assertEquals(keyboard.getColor(), keyboardDTO.getColor());

            // MechanicalKeyboard fields
            assertEquals(keyboard.getCompatibilities(), keyboardDTO.getCompatibilities());
            assertEquals(keyboard.getConnections(), keyboardDTO.getConnections());
            assertEquals(keyboard.getCableLength(), keyboardDTO.getCableLength());
            assertEquals(keyboard.getSwitchType(), keyboardDTO.getSwitchType());
            assertEquals(keyboard.getLayout(), keyboardDTO.getLayout());
            assertEquals(keyboard.getKeyCount(), keyboardDTO.getKeyCount());
            assertEquals(keyboard.getKeycapMaterial(), keyboardDTO.getKeycapMaterial());
            assertEquals(keyboard.getBatteryType(), keyboardDTO.getBatteryType());
        }

        private MechanicalKeyboard keyboardBuilder() {
            Set<Laptop.EOS> compatibilities = new HashSet<>();
            compatibilities.add(Laptop.EOS.WINDOWS);
            compatibilities.add(Laptop.EOS.MAC);
            compatibilities.add(Laptop.EOS.LINUX);

            Set<MechanicalKeyboard.EConnection> connections = new HashSet<>();
            connections.add(MechanicalKeyboard.EConnection.USB_RECEIVER);
            connections.add(MechanicalKeyboard.EConnection.BLUETOOTH);
            connections.add(MechanicalKeyboard.EConnection.WIRED);

            KeyboardBuilder builder = new KeyboardBuilderImpl();
            return builder
                    .compatibilities(compatibilities)
                    .connections(connections)
                    .cableLength("1.8m")
                    .switchType("Cherry MX Red")
                    .layout(MechanicalKeyboard.ELayout.FULL_SIZE)
                    .keyCount(104)
                    .keycapMaterial("ABS")
                    .batteryType("AA")
                    .id(1L)
                    .brand("BrandName")
                    .model("Model123")
                    .desc("Description of the keyboard")
                    .price(new BigDecimal("99.99"))
                    .stockQty(50)
                    .discountPercent(0.05)
                    .version("Version2")
                    .color("Black")
                    .category(ECategory.MECHANICAL_KEYBOARD)
                    .releaseYear(2023)
                    .build();
        }

        @Test
        void testToMechanicalKeyboardEntity() {
            // Setup
            MechanicalKeyboardDTO keyboardDTO = keyboardDTOBuilder();

            // Action
            MechanicalKeyboard keyboard = ProductMapper.MechanicalKeyboardMapper.INSTANCE.toEntity(keyboardDTO);

            // Assert
            // Common fields
            assertEquals(keyboardDTO.getId(), keyboard.getId());
            assertEquals(keyboardDTO.getBrand(), keyboard.getBrand());
            assertEquals(keyboardDTO.getModel(), keyboard.getModel());
            assertEquals(keyboardDTO.getDesc(), keyboard.getDesc());
            assertEquals(keyboardDTO.getPrice(), keyboard.getPrice());
            assertEquals(keyboardDTO.getStockQty(), keyboard.getStockQty());
            assertEquals(keyboardDTO.getVersion(), keyboard.getVersion());
            assertEquals(keyboardDTO.getColor(), keyboard.getColor());

            // MechanicalKeyboard fields
            assertEquals(keyboardDTO.getCompatibilities(), keyboard.getCompatibilities());
            assertEquals(keyboardDTO.getConnections(), keyboard.getConnections());
            assertEquals(keyboardDTO.getCableLength(), keyboard.getCableLength());
            assertEquals(keyboardDTO.getSwitchType(), keyboard.getSwitchType());
            assertEquals(keyboardDTO.getLayout(), keyboard.getLayout());
            assertEquals(keyboardDTO.getKeyCount(), keyboard.getKeyCount());
            assertEquals(keyboardDTO.getKeycapMaterial(), keyboard.getKeycapMaterial());
            assertEquals(keyboardDTO.getBatteryType(), keyboard.getBatteryType());
        }

        private MechanicalKeyboardDTO keyboardDTOBuilder() {
            Set<Laptop.EOS> compatibilities = new HashSet<>();
            compatibilities.add(Laptop.EOS.WINDOWS);
            compatibilities.add(Laptop.EOS.MAC);
            compatibilities.add(Laptop.EOS.LINUX);

            Set<MechanicalKeyboard.EConnection> connections = new HashSet<>();
            connections.add(MechanicalKeyboard.EConnection.USB_RECEIVER);
            connections.add(MechanicalKeyboard.EConnection.BLUETOOTH);
            connections.add(MechanicalKeyboard.EConnection.WIRED);

            KeyboardDTOBuilder builder = new KeyboardDTOBuilderImpl();
            return builder
                    .compatibilities(compatibilities)
                    .connections(connections)
                    .cableLength("1.8m")
                    .switchType("Cherry MX Red")
                    .layout(MechanicalKeyboard.ELayout.FULL_SIZE)
                    .keyCount(104)
                    .keycapMaterial("ABS")
                    .batteryType("AA")
                    .id(1L)
                    .brand("BrandName")
                    .model("Model123")
                    .desc("Description of the keyboard")
                    .price(new BigDecimal("99.99"))
                    .stockQty(50)
                    .version("Version2")
                    .color("Black")
                    .build();
        }
    }

    @Nested
    class MonitorMapperTest {
        @Test
        void testToMonitorDTO() {
            // Setup
            Monitor monitor = monitorBuilder();

            // Action
            MonitorDTO monitorDTO = ProductMapper.MonitorMapper.INSTANCE.toDTO(monitor);

            // Assert
            // Common fields
            assertEquals(monitor.getId(), monitorDTO.getId());
            assertEquals(monitor.getBrand(), monitorDTO.getBrand());
            assertEquals(monitor.getModel(), monitorDTO.getModel());
            assertEquals(monitor.getDesc(), monitorDTO.getDesc());
            assertEquals(monitor.getPrice(), monitorDTO.getPrice());
            assertEquals(monitor.getStockQty(), monitorDTO.getStockQty());
            assertEquals(monitor.getVersion(), monitorDTO.getVersion());
            assertEquals(monitor.getColor(), monitorDTO.getColor());

            // Monitor fields
            assertEquals(monitor.getScreenSize(), monitorDTO.getScreenSize());
            assertEquals(monitor.getResolution(), monitorDTO.getResolution());
            assertEquals(monitor.isTouchScreen(), monitorDTO.isTouchScreen());
            assertEquals(monitor.getPanelType(), monitorDTO.getPanelType());
            assertEquals(monitor.getRefreshRate(), monitorDTO.getRefreshRate());
            assertEquals(monitor.isEyeCareTechnology(), monitorDTO.isEyeCareTechnology());
            assertEquals(monitor.getBrightness(), monitorDTO.getBrightness());
            assertEquals(monitor.isHdrSupported(), monitorDTO.isHdrSupported());
            assertEquals(monitor.isBuiltInSpeakers(), monitorDTO.isBuiltInSpeakers());
            assertEquals(monitor.getPowerConsumption(), monitorDTO.getPowerConsumption());
            assertEquals(monitor.getWeight(), monitorDTO.getWeight());
            assertEquals(monitor.getConnections(), monitorDTO.getConnections());
        }

        private Monitor monitorBuilder() {
            Set<Monitor.EConnection> connections = new HashSet<>();
            connections.add(Monitor.EConnection.HDMI);
            connections.add(Monitor.EConnection.USB_C);

            MonitorBuilder builder = new MonitorBuilderImpl();
            return builder
                    .screenSize(27.0)
                    .resolution("1920x1080")
                    .touchScreen(true)
                    .panelType(Monitor.EPanel.IPS)
                    .refreshRate(144)
                    .eyeCareTechnology(true)
                    .brightness(250)
                    .hdrSupported(true)
                    .builtInSpeakers(true)
                    .powerConsumption(50.5)
                    .weight(7.2)
                    .connections(connections)
                    .id(1L)
                    .brand("BrandName")
                    .model("Model123")
                    .desc("Description of the monitor")
                    .price(new BigDecimal("299.99"))
                    .stockQty(50)
                    .discountPercent(0.1)
                    .version("Version2")
                    .color("Black")
                    .category(ECategory.MONITOR)
                    .releaseYear(2023)
                    .build();
        }

        @Test
        void testToMonitorEntity() {
            // Setup
            MonitorDTO monitorDTO = monitorDTOBuilder();

            // Action
            Monitor monitor = ProductMapper.MonitorMapper.INSTANCE.toEntity(monitorDTO);

            // Assert
            // Common fields
            assertEquals(monitorDTO.getId(), monitor.getId());
            assertEquals(monitorDTO.getBrand(), monitor.getBrand());
            assertEquals(monitorDTO.getModel(), monitor.getModel());
            assertEquals(monitorDTO.getDesc(), monitor.getDesc());
            assertEquals(monitorDTO.getPrice(), monitor.getPrice());
            assertEquals(monitorDTO.getStockQty(), monitor.getStockQty());
            assertEquals(monitorDTO.getVersion(), monitor.getVersion());
            assertEquals(monitorDTO.getColor(), monitor.getColor());

            // Monitor fields
            assertEquals(monitorDTO.getScreenSize(), monitor.getScreenSize());
            assertEquals(monitorDTO.getResolution(), monitor.getResolution());
            assertEquals(monitorDTO.isTouchScreen(), monitor.isTouchScreen());
            assertEquals(monitorDTO.getPanelType(), monitor.getPanelType());
            assertEquals(monitorDTO.getRefreshRate(), monitor.getRefreshRate());
            assertEquals(monitorDTO.isEyeCareTechnology(), monitor.isEyeCareTechnology());
            assertEquals(monitorDTO.getBrightness(), monitor.getBrightness());
            assertEquals(monitorDTO.isHdrSupported(), monitor.isHdrSupported());
            assertEquals(monitorDTO.isBuiltInSpeakers(), monitor.isBuiltInSpeakers());
            assertEquals(monitorDTO.getPowerConsumption(), monitor.getPowerConsumption());
            assertEquals(monitorDTO.getWeight(), monitor.getWeight());
            assertEquals(monitorDTO.getConnections(), monitor.getConnections());
        }

        private MonitorDTO monitorDTOBuilder() {
            Set<Monitor.EConnection> connections = new HashSet<>();
            connections.add(Monitor.EConnection.HDMI);
            connections.add(Monitor.EConnection.USB_C);

            MonitorDTOBuilder builder = new MonitorDTOBuilderImpl();
            return builder
                    .screenSize(27.0)
                    .resolution("1920x1080")
                    .touchScreen(true)
                    .panelType(Monitor.EPanel.IPS)
                    .refreshRate(144)
                    .eyeCareTechnology(true)
                    .brightness(250)
                    .hdrSupported(true)
                    .builtInSpeakers(true)
                    .powerConsumption(50.5)
                    .weight(7.2)
                    .connections(connections)
                    .id(1L)
                    .brand("BrandName")
                    .model("Model123")
                    .desc("Description of the monitor")
                    .price(new BigDecimal("299.99"))
                    .stockQty(50)
                    .discountPercent(0.1)
                    .version("Version2")
                    .color("Black")
                    .category(ECategory.MONITOR)
                    .releaseYear(2023)
                    .build();
        }
    }
}