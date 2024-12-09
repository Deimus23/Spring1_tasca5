package Nivel1.Ejercicio2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class ListDirectoryBranch {
    public ListDirectoryBranch() {
    }

    public static void listDirectoryBranch(String path) {
        File[] listDirectory = new File(path).listFiles();
        if (listDirectory != null) {
            Arrays.sort(listDirectory);
            for (File order : listDirectory) {
                SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = formatDate.format(order.lastModified());

                String type = order.isDirectory() ? "D" : "F";
                System.out.println(type + " - " + order.getName() + " Last modified: " + date);

                if (order.isDirectory()) {
                    listDirectoryBranch(path);
                }
            }
        } else {
            System.out.println("The route for the directory isn't correct");
        }
    }
}
