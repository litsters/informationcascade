package main;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExportUtility {

    public static void Export(String fileName, String fileContents)
    {
        try {

            File file = new File(fileName);

            if (file.createNewFile()){
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

                    bw.write(fileContents);

                } catch (IOException e) {

                    e.printStackTrace();

                }
            }else{
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String GenerateFileName(String name, String extension) {
        String cwd = System.getProperty("user.dir");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        Date now = new Date();
        String fileName = cwd + "/" + name + "_" + dateFormat.format(now) + "." + extension;
        return fileName;
    }

}
