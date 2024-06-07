package ru.bip.melodyv2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VideoService {
    private String aptekaText;
    private String createText;
    private String maximText;
    //создание подкаталогов для каждого аккредитуемого
    private Path[] greatSubdirectories(Path newPath) throws IOException {
        System.out.println(newPath.toAbsolutePath());
        String[] subdirectories = new String[]{aptekaText, createText, maximText};
        Path[] subdirectoriesPath = new Path[subdirectories.length];
        for (int i = 0; i < subdirectories.length; i++) {
            if (subdirectories[i].equals("")) {
                subdirectoriesPath[i] = Path.of(newPath.toAbsolutePath() + "\\" + i);
            } else {
                subdirectoriesPath[i] = Path.of(newPath.toAbsolutePath() + "\\" + subdirectories[i]);
            }
            Files.createDirectories(subdirectoriesPath[i]);
        }
        return subdirectoriesPath;
    }

    //создание подкаталогов для нового прохода
    private Path getNewPath(Path directoryPath) {
        File[] dirs = directoryPath.toFile().listFiles();
        int newNumber = 1;
        if (dirs != null) {
            newNumber = dirs.length + 1;
        }
        Path newPath = Path.of(directoryPath.toString() + "\\" + newNumber);
        return newPath;
    }
}
