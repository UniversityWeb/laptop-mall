package com.webteam.laptopmall.service.image;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.prod.Product;

import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public interface ImageService {
    String saveProductImage(String prodID,String realPath, Part part);
    List<String> saveProductImages(String prodID,String realPath, List<Part> parts);
    List<String> loadAllById(String prodID,String realPath);
    ProductDTO loadProdImageUrls(ProductDTO prodDTO, String realPath);
    List<String> loadProdImageUrls(Long prodId, String realPath);
}
