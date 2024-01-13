package com.webteam.laptopmall.file.prod;

import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;
import com.webteam.laptopmall.file.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
import java.util.stream.Collectors;

public class ProdImgIOImpl implements ProdImgIO {

    private static final Logger log = LogManager.getLogger(ProdImgIOImpl.class);

    private ProdService prodService = new ProdServiceImpl();

    @Override
    public void deleteAllWithoutDefault(String realPath, Long prodId) {
        String prodFolder = getProdFolderById(realPath, prodId);
        String defaultImgPattern = prodId+"-0.";
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

        if(prodService.getById(prodId).getMarkAsDeleted())
            imgUrls.add( getDefaultImg(1) );

        try {
            imgUrls.addAll(Arrays.stream(directory.listFiles())
                    .map(f -> createJSTLUrl(prodId, f.getName()))
                    .collect(Collectors.toList())) ;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (imgUrls.isEmpty()) {
            imgUrls.add( getDefaultImg(0) );
        }
        return imgUrls;
    }

    private String getProdFolderById(String realPath, Long prodId) {
        String subFolder = "app/prod/" + prodId;
        return realPath.concat(subFolder);
    }

    private String getDefaultImg(int index) {
        return "/app/prod/default/"+index+".png";
    }

    private String createJSTLUrl(Long prodId, String fileName) {
        return "/app/prod/" + prodId + "/" + fileName;
    }

    @Override
    public String save(String realPath, Long prodId, Part part) {

        String prodFolder = getProdFolderById(realPath, prodId);
        File directory = new File(prodFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String fileName = getFileName(prodId, part,directory.listFiles().length);
        String pathToSave = prodFolder + File.separator + fileName;

        try (InputStream fileContent = part.getInputStream()) {
            Files.copy(fileContent, Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
            return pathToSave;
        } catch (IOException e) {
            log.error(e.getMessage());
            return "";
        }
    }

    @Override
    public List<String> saveProductImages(Long prodID, String realPath, List<Part> parts) {
        for (Part part : parts) {
            save(realPath,prodID,part);
        }
        return null;
    }

    private String getFileName(Long prodId, Part part,int index) {
        return prodId.toString()+"-"+index + "." + getFileExtension(part);
    }

    private String getFileExtension(Part part) {
        String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public void deleteAll(String realPath, Long prodId){
        String prodFolder = getProdFolderById(realPath, prodId);
        File directory = new File(prodFolder);
        directory.delete();
    }
}
