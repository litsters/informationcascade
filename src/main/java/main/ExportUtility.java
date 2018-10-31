package main;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExportUtility {

    public static void Export(String fileName, String fileContents) {
        throw new NotImplementedException();

        /*fileName = System.getProperty("user.dir") + "/" + fileName;
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        File file = new File(fileName);

        try {
            file.createNewFile();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {

            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContents);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bufferedWriter != null)
                    bufferedWriter.close();

                if (fileWriter != null)
                    fileWriter.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }*/
    }

    public static String GenerateFileName(String name, String extension) {
        String cwd = System.getProperty("user.dir");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        Date now = new Date();
        String fileName = cwd + "/" + name + "_" + dateFormat.format(now) + "." + extension;
        return fileName;
    }

}
