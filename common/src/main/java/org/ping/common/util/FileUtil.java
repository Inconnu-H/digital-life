package org.ping.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 文件操作工具类
 *
 * @author Ping
 */
public class FileUtil {


    public static File[] getFiles(String path) {
        File fileOfPath = new File(path);
        File[] files;
        if (fileOfPath.isDirectory()) {
            files = fileOfPath.listFiles();
        } else {
            files = new File[]{fileOfPath};
        }
        return files;
    }

    /**
     * 修改文件创建时间
     */
    public static void changeCreationTime(String filePath, LocalDateTime localDateTime) {
        // Step 1: Define the path to the file
        Path path = Paths.get(filePath);

        try {
            // Step 2: Create FileTime instance for the new creation time
            FileTime newCreationTime = FileTime.from(localDateTime.toInstant(ZoneOffset.ofHours(8)));

            // Step 3: Get the BasicFileAttributeView of the file
            BasicFileAttributeView attributes = Files.getFileAttributeView(path, BasicFileAttributeView.class);

            // Step 4: Set the new creation time
            attributes.setTimes(null, null, newCreationTime);


            System.out.println("[" + path.getFileName() + "]: creation time updated successfully to " + newCreationTime);
        } catch (IOException e) {
            // Step 5: Handle exceptions
            System.err.println("Error updating file creation time: " + e.getMessage());
        }
    }
}
