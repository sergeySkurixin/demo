package leha_help;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

/**
 * Created by скурихин on 23.02.2017.
 */
public class RenameFilesInDirectory {

    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        File directory = new File("C:\\Users\\скурихин\\Desktop\\Новая папка");
        boolean isDirectory = directory.isDirectory();
        boolean exists = directory.exists();

        if (isDirectory && exists) {
            File[] files = directory.listFiles();

            for (File fileEach : files) {

                Path path = fileEach.toPath();
                BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
                FileTime fileTime = basicFileAttributes.creationTime();

                String absolutePath = fileEach.getAbsolutePath();
                String[] split = absolutePath.split("\\.");
                String newName = "";
                for (int i = 0; i < split.length - 1; i++) {
                    newName += split[i];
                }
                long numberOfMinutes = fileTime.to(TimeUnit.MINUTES);
                newName += numberOfMinutes + "." + split[split.length - 1];
                File dest = new File(newName);

                fileEach.renameTo(dest);
            }
        }
        else{
            System.out.println("Error: not directory or not exist");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time of work in mls: " + (endTime - startTime));
    }


}
