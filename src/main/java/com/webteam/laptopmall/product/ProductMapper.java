package com.webteam.laptopmall.product;

import com.webteam.laptopmall.product.dto.LaptopDTO;
import com.webteam.laptopmall.product.dto.MechanicalKeyboardDTO;
import com.webteam.laptopmall.product.dto.MonitorDTO;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.entity.Laptop;
import com.webteam.laptopmall.product.entity.MechanicalKeyboard;
import com.webteam.laptopmall.product.entity.Monitor;
import com.webteam.laptopmall.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        if (product instanceof Laptop) {
            Laptop laptop = (Laptop) product;
            return LaptopMapper.INSTANCE.toDTO(laptop);
        } else if (product instanceof MechanicalKeyboard) {
            MechanicalKeyboard keyboard = (MechanicalKeyboard) product;
            return MechanicalKeyboardMapper.INSTANCE.toDTO(keyboard);
        } else {
            Monitor monitor = (Monitor) product;
            return MonitorMapper.INSTANCE.toDTO(monitor);
        }
    }

    public static Product toEntity(ProductDTO productDTO) {
        if (productDTO instanceof LaptopDTO) {
            LaptopDTO laptop = (LaptopDTO) productDTO;
            return LaptopMapper.INSTANCE.toEntity(laptop);
        } else if (productDTO instanceof MechanicalKeyboardDTO) {
            MechanicalKeyboardDTO keyboard = (MechanicalKeyboardDTO) productDTO;
            return MechanicalKeyboardMapper.INSTANCE.toEntity(keyboard);
        } else {
            MonitorDTO monitor = (MonitorDTO) productDTO;
            return MonitorMapper.INSTANCE.toEntity(monitor);
        }
    }


    @Mapper
    public interface LaptopMapper {
        LaptopMapper INSTANCE = Mappers.getMapper(LaptopMapper.class);

        @Named("toProductDTO")
        LaptopDTO toDTO(Laptop product);

        @Named("toProduct")
        @Mapping(target = "cartItems", ignore = true)
        Laptop toEntity(LaptopDTO productDTO);
    }

    @Mapper
    public interface MechanicalKeyboardMapper {
        MechanicalKeyboardMapper INSTANCE = Mappers.getMapper(MechanicalKeyboardMapper.class);

        @Named("toProduct")
        @Mapping(target = "cartItems", ignore = true)
        MechanicalKeyboard toEntity(MechanicalKeyboardDTO productDTO);

        @Named("toProductDTO")
        MechanicalKeyboardDTO toDTO(MechanicalKeyboard product);
    }

    @Mapper
    public interface MonitorMapper {
        MonitorMapper INSTANCE = Mappers.getMapper(MonitorMapper.class);

        @Named("toProductDTO")
        MonitorDTO toDTO(Monitor product);

        @Named("toProduct")
        @Mapping(target = "cartItems", ignore = true)
        Monitor toEntity(MonitorDTO productDTO);
    }
}
