package Nivel1.Ejercicio4;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListDirectoryBranchToFile {

    public static void listDirectoryBranch(String path, FileWriter writer) {
        try {
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
        } catch (IOException e) {
            try {
                writer.write("An error occurred while processing the path: " + e.getMessage() + System.lineSeparator());
            } catch (IOException inner) {
                System.err.println("Failed to write error information: " + inner.getMessage());
            }
        }
    }



    public static void readTxtFile(String filePath) throws IOException {
        System.out.println("Reading content of file: " + filePath);
        Files.lines(Paths.get(filePath)).forEach(System.out::println);
    }
}
