package com.webteam.laptopmall.io.image.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;

import javax.servlet.http.Part;
import java.util.List;

public interface ProdImgIO {
    void deleteAllWithoutDefault(String realPath, Long prodId);

    ProductDTO loadProdImageUrls(ProductDTO prodDTO, String realPath);

    List<String> loadProdImageUrls(Long prodId, String realPath);

    String save(String realPath, Long prodId, Part part);

    List<String> saveProductImages(Long prodID, String realPath, List<Part> parts);

    void deleteAll(String realPath, Long prodId);
}
