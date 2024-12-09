package Nivel1.Ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListDirectoryBranchToFile {
    public static void listDirectoryBranch(String path, FileWriter writer) throws IOException {
        File[] listDirectory = new File(path).listFiles();
        if (listDirectory != null) {
            Arrays.sort(listDirectory);
            for (File order : listDirectory) {
                SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = formatDate.format(order.lastModified());

                String type = order.isDirectory() ? "D" : "F";
                writer.write(type + " - " + order.getName() + " Last modified: " + date + System.lineSeparator());

                if (order.isDirectory()) {
                    listDirectoryBranch(order.getAbsolutePath(), writer);
                }
            }
        } else {
            writer.write("The path provided is incorrect or the directory does not exist." + System.lineSeparator());
        }
    }
}
