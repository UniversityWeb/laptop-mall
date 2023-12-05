package com.webteam.laptopmall.io.image.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.utility.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProdImgIOImpl implements ProdImgIO {

    private static final Logger log = Logger.getLogger(ProdImgIOImpl.class.getName());

    @Override
    public void deleteAllWithoutDefault(String realPath, Long prodId) {
        String prodFolder = getProdFolderById(realPath, prodId);
        String defaultImgPattern = "0.";
        String fileName = FileUtil.getImagesWithPattern(prodFolder, defaultImgPattern);
        FileUtil.deleteAllFilesInFolder(realPath, fileName);
    }

    @Override
    public ProductDTO loadProdImageUrls(ProductDTO prodDTO, String realPath) {
        List<String> imgUrls = loadProdImageUrls(prodDTO.getId(), realPath);
        prodDTO.setImageUrls(imgUrls);
        return prodDTO;
    }

    @Override
    public List<String> loadProdImageUrls(Long prodId, String realPath) {
        List<String> imgUrls = new ArrayList<>();
        String prodFolder = getProdFolderById(realPath, prodId);
        File directory = new File(prodFolder);
        try {
            imgUrls = Arrays.stream(directory.listFiles())
                    .map(f -> createJSTLUrl(prodId, f.getName()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        if (imgUrls.isEmpty()) {
            imgUrls.add( getDefaultImg() );
        }
        return imgUrls;
    }

    private String getProdFolderById(String realPath, Long prodId) {
        String subFolder = "app/prod/" + prodId;
        return realPath.concat(subFolder);
    }

    private String getDefaultImg() {
        return "/app/prod/default/0.jpeg";
    }

    private String createJSTLUrl(Long prodId, String fileName) {
        return "/app/prod/" + prodId + "/" + fileName;
    }
}
