package services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileService {

    public static String[] read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }

   public static void createFile(String path, String name) throws IOException {
        File folder=new File(path);
        if (!folder.exists()){
            folder.mkdirs();
        }
        File file=new File(path + "\\"+name);
        file.createNewFile();
    }
   public static void addObjectsToFile(String path, String text)  {
        try {
            Files.write(Paths.get(path),text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}