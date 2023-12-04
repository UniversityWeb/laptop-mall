package com.webteam.laptopmall.io.image.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;

import javax.servlet.http.Part;
import java.util.List;

public interface ProdImgIO {
    String saveProdImage(String realPath, Long prodId, Part part);

    List<String> saveProdImages(String realPath, Long prodId, List<Part> parts);

    ProductDTO loadProdImageUrls(ProductDTO prodDTO, String realPath);

    List<String> loadProdImageUrls(Long prodId, String realPath);
}
