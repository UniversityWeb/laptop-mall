package com.webteam.laptopmall.utility;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileUtil {
    private static final Logger log = Logger.getLogger(FileUtil.class.getName());

    public static void deleteAllFilesInFolder(String folderPath, String fileNameToIgnore) {
        try {
            Files.walkFileTree(Paths.get(folderPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!file.getFileName().toString().equals(fileNameToIgnore)) {
                        Files.delete(file);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    log.severe("Failed to delete file: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("All files in the folder deleted successfully.");
        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public static String getImagesWithPattern(String folderPath, String pattern) {
        try (Stream<Path> paths = Files.walk(Path.of(folderPath))) {
            return paths
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(fileName -> fileName.startsWith(pattern))
                    .findFirst()
                    .orElse("");
        } catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
            return "";
        }
    }
}
