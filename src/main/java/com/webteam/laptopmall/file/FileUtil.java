package com.webteam.laptopmall.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FileUtil {

    private static final Logger log = LogManager.getLogger(FileUtil.class);

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
                    log.error("Failed to delete file: " + file);
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("All files in the folder deleted successfully.");
        } catch (IOException e) {
            log.error(e.getMessage());
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
            log.error(e.getMessage());
            return "";
        }
    }
}
