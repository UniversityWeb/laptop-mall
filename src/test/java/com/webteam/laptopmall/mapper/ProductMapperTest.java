package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.builder.dto.laptop.LaptopDTOBuilder;
import com.webteam.laptopmall.builder.dto.laptop.LaptopDTOBuilderImpl;
import com.webteam.laptopmall.builder.entity.laptop.LaptopBuilder;
import com.webteam.laptopmall.builder.entity.laptop.LaptopBuilderImpl;
import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.LaptopDTO;
import com.webteam.laptopmall.entity.prod.Laptop;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    @Nested
    class LaptopMapperTest {
        @Test
        void testToLaptopDTO() {
            Laptop product = laptopBuilder();
            LaptopDTO productDTO = (LaptopDTO) ProductMapper.toDTO(product);

            // common fields
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
                    .operatingSystem(Laptop.OS.WINDOW)
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
            // Given
            LaptopDTO productDTO = laptopDTOBuilder();

            Laptop product = ProductMapper.LaptopMapper.INSTANCE.toEntity(productDTO);

            // common fields
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
                    .operatingSystem(Laptop.OS.WINDOW)
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
        }

        @Test
        void testToMechanicalKeyboardEntity() {
        }
    }

    @Nested
    class MonitorMapperTest {
        @Test
        void testToMonitorDTO() {
        }

        @Test
        void testToMonitorEntity() {
        }
    }
}