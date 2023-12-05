package com.webteam.laptopmall.io.image.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;

import javax.servlet.http.Part;
import java.util.List;

public interface ProdImgIO {
    void deleteAllWithoutDefault(String realPath, Long prodId);

    ProductDTO loadProdImageUrls(ProductDTO prodDTO, String realPath);

    List<String> loadProdImageUrls(Long prodId, String realPath);
}
