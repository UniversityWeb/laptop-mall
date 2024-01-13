package com.webteam.laptopmall.cartitem;

import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.ProductMapper;
import com.webteam.laptopmall.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
