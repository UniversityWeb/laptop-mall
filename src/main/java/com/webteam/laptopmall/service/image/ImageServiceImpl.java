package com.webteam.laptopmall.service.image;

import com.webteam.laptopmall.dto.prod.ProductDTO;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ImageServiceImpl implements ImageService {

    private static final Logger log = Logger.getLogger(ImageServiceImpl.class.getName());

    @Override
    public String saveProductImage(String prodID, String realPath, Part part) {
        String extension = getFileExtension(part);
        String fileName = getFileName(prodID, 0, extension);
        String filePath = getFilePath(realPath, fileName);

        try {
            int i = 0;
            File directory = new File(realPath);
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            while (Files.exists(Path.of(filePath))) {
                i++;
                fileName = getFileName(prodID, i, extension);
                filePath = getFilePath(realPath, fileName);
            }
            if (part != null)
                part.write(filePath);
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return fileName;
    }

    @Override
    public List<String> saveProductImages(String prodID, String realPath, List<Part> parts) {
        for (Part part : parts) {
            saveProductImage(prodID, realPath, part);
        }
        return null;
    }

    @Override
    public List<String> loadAllById(String prodID, String realPath) {
        List<String> listImg = new ArrayList<String>();
        File directory = new File(realPath);
        try {
            for (File file : directory.listFiles()) {
                if (file.getName().contains(prodID)) {
                    listImg.add(file.getName());
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }

        return listImg;
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
        String prodFolder = getProdFolder(realPath, prodId);
        File directory = new File(prodFolder);
        try {
            imgUrls = Arrays.stream(directory.listFiles())
                    .map(f -> getJSTLUrl(prodId, f.getName()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        if (imgUrls.isEmpty()) {
            imgUrls.add("/app/prod/default/0.jpeg");
        }
        return imgUrls;
    }

    private String getProdFolder(String realPath, Long prodId) {
        String subFolder = "app/prod/" + prodId;
        return realPath.concat(subFolder);
    }

    private String getJSTLUrl(Long prodId, String fileName) {
        return "/app/prod/" + prodId + "/" + fileName;
    }

    private String getFileName(String prodID, int number, String fileExtension) {
        return prodID + "-" + number + "." + fileExtension;
    }

    private String getFilePath(String realPath, String fileName) {
        return realPath + "/" + fileName;
    }

    private String getFileExtension(Part part) {
        String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
