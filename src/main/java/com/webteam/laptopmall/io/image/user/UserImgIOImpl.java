package com.webteam.laptopmall.io.image.user;

import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.utility.FileUtil;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserImgIOImpl implements UserImgIO {
    private static final Logger log = Logger.getLogger(UserImgIOImpl.class.getName());

    @Override
    public String save(String realPath, String username, Part part) {
        String fileName = getFileName(username, part);
        String userFolder = getUserFolderByUsername(realPath, username);
        String pathToSave = userFolder + File.separator + fileName;

        FileUtil.deleteAllFilesInFolder(userFolder, fileName);

        try (InputStream fileContent = part.getInputStream()) {
            Files.copy(fileContent, Paths.get(pathToSave), StandardCopyOption.REPLACE_EXISTING);
            return pathToSave;
        } catch (IOException e) {
            log.severe(e.getMessage());
            return "";
        }
    }

    private String getFileName(String username, Part part) {
        return username + "." + getFileExtension(part);
    }

    private String getFileExtension(Part part) {
        String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    public UserDTO loadJstlImgUrl(String realPath, UserDTO userDTO) {
        String avatarUrl = loadJstlImgUrl(realPath, userDTO.getUsername());
        userDTO.setAvatarUrl(avatarUrl);
        return userDTO;
    }

    @Override
    public String loadJstlImgUrl(String realPath, String username) {
        String prodFolder = getUserFolderByUsername(realPath, username);
        File directory = new File(prodFolder);
        try {
            if (directory.listFiles().length > 0) {
                File avatar = directory.listFiles()[0];
                String jstlImgUrl = createJSTLUrl(username, avatar.getName());
                return jstlImgUrl;
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        return getDefaultImg();
    }

    private String getDefaultImg() {
        return "/app/user/default/0.jpeg";
    }

    private String getUserFolderByUsername(String realPath, String username) {
        String subFolder = "app" + File.separator + "user" + File.separator + username;
        return realPath.concat(subFolder);
    }

    private String createJSTLUrl(String username, String fileName) {
        return "/app/user/" + username + File.separator + fileName;
    }
}
