package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.CartItemDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;
import com.webteam.laptopmall.entity.prod.Monitor;
import com.webteam.laptopmall.entity.prod.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ProductMapper.class)
public interface CartItemMapper {
    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    @Named("toCartItemDTO")
    CartItemDTO toDTO(CartItem entity);

    @Named("toCartItem")
    @Mapping(target = "product", qualifiedByName = "toProduct")
    CartItem toEntity(CartItemDTO dto);

    @Named("toProduct")
    default ProductDTO toProductDTO(ProductDTO productDTO) {
        return productDTO;
    }

    @Named("toProduct")
    default Product toProduct(ProductDTO productDTO) {
        return ProductMapper.toEntity(productDTO);
    }
}
