package com.webteam.laptopmall.product.service;

import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.ProductDTO;

import java.util.List;

public interface ProdService {
    ProductDTO save(ProductDTO prodDTO);
    ProductDTO update(ProductDTO prodDTO);
    ProductDTO deleteById(Long id);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
    List<ProductDTO> getProdsByModel(String model);
    List<ProductDTO> getProdsByCategory(ECategory eCategory);

    String [] getNameFromList(List<ProductDTO> topBestSellProducts);
    int markProductAsDeleted(Long prodId);
    List<ProductDTO> getProdsIsAvailable();
}
