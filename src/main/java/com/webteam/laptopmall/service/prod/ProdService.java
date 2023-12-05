package com.webteam.laptopmall.service.prod;

import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.dto.prod.ProductDTO;

import java.util.List;

public interface ProdService {
    ProductDTO save(ProductDTO prodDTO);
    ProductDTO update(ProductDTO prodDTO);
    ProductDTO deleteById(Long id);
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
    List<ProductDTO> getProdsByModel(String model);
    List<ProductDTO> getProdsByCategory(ECategory eCategory);

    Long createNewProdID();

    String [] getNameFromList(List<ProductDTO> topBestSellProducts);
}
