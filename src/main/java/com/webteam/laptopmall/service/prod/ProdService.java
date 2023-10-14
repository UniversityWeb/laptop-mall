package com.webteam.laptopmall.service.prod;

import com.webteam.laptopmall.dto.ProductDTO;

import java.util.List;

public interface ProdService {
    ProductDTO save(ProductDTO prodDTO);
    ProductDTO update(ProductDTO prodDTO);
    ProductDTO deleteById(Long id);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
}
