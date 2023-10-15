package com.webteam.laptopmall.mapper;

import com.webteam.laptopmall.dto.ProdColorDTO;
import com.webteam.laptopmall.entity.ProdColor;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdColorMapper {
    ProdColorMapper INSTANCE = Mappers.getMapper(ProdColorMapper.class);

    @Named("toProdColorDTO")
    ProdColorDTO toDTO(ProdColor entity);

    @Named("toProdColor")
    ProdColor toEntity(ProdColorDTO dto);
}
