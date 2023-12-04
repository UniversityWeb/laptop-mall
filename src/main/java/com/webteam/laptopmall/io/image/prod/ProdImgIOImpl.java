package com.webteam.laptopmall.io.image.prod;

import com.webteam.laptopmall.dto.prod.ProductDTO;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProdImgIOImpl implements ProdImgIO {

    private static final Logger log = Logger.getLogger(ProdImgIOImpl.class.getName());

    @Override
    public String saveProdImage(String realPath, Long prodId, Part part) {
        String pathToSave = createPathToSave(realPath, prodId, part);

        try (InputStream fileContent = part.getInputStream()) {
            Files.copy(fileContent, Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
            return pathToSave;
        } catch (IOException e) {
            log.severe(e.getMessage());
            return "";
        }
    }

    private String generateFileName(Long prodId, String extension) {
        Long index = new Random().nextLong();
        return index + extension;
    }

    private String createPathToSave(String realPath, Long prodId, Part part) {
        String extension = getFileExtension(part);
        String prodFolder = getProdFolderById(realPath, prodId);
        String fileName = generateFileName(prodId, extension);
        return prodFolder.concat(fileName);
    }

    @Override
    public List<String> saveProdImages(String realPath, Long prodId, List<Part> parts) {
        for (Part part : parts) {
            saveProdImage(realPath, prodId, part);
        }
        return null;
    }

    private String getFileExtension(Part part) {
        String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
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
