package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.builder.laptop.LaptopBuilder;
import com.webteam.laptopmall.builder.laptop.LaptopBuilderImpl;
import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.FloatBuffer;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    @Test
    void testToLaptopDTO() {
        Laptop product = laptopBuilder();
        ProductDTO productDTO = ProductMapper.toDTO(product);

        assertEquals(product.getId(), productDTO.getId());
        assertEquals(product.getBrand(), productDTO.getBrand());
        assertEquals(product.getModel(), productDTO.getModel());
        assertEquals(product.getDesc(), productDTO.getDesc());
        assertEquals(product.getPrice(), productDTO.getPrice());
        assertEquals(product.getStockQty(), productDTO.getStockQty());
        assertEquals(product.getVersion(), productDTO.getVersion());
        assertEquals(product.getColor(), productDTO.getColor());
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
//        ProductDTO productDTO = new ProductDTO(1L, "Brand", "Model", "Description", new BigDecimal("1000.00"),
//                10, 0, "RAM 16GB | ROM 256", "GREEN",   new CategoryDTO(1, "Laptop"));
//        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
//
//        assertEquals(productDTO.getId(), product.getId());
//        assertEquals(productDTO.getBrand(), product.getBrand());
//        assertEquals(productDTO.getModel(), product.getModel());
//        assertEquals(productDTO.getDesc(), product.getDesc());
//        assertEquals(productDTO.getPrice(), product.getPrice());
//        assertEquals(productDTO.getStockQty(), product.getStockQty());
//        assertEquals(product.getVersion(), productDTO.getVersion());
//        assertEquals(product.getColor(), productDTO.getColor());
    }
}