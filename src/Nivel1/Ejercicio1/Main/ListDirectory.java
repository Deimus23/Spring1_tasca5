package Nivel1.Ejercicio1.Main;

import java.io.File;
import java.util.Arrays;

public class ListDirectory {
    public ListDirectory() {
    }

    public static void listDirectory(String var0) {
        File var1 = new File(var0);
        if (var1.isDirectory()) {
            String[] var2 = (new File(var0)).list();
            if (var2 != null) {
                Arrays.sort(var2);

                for(String var6 : var2) {
                    System.out.println(var6);
                }
            } else {
                System.out.println("The directory is empty");
            }
        } else {
            System.out.println("The route for the directory isn't correct");
        }

    }
}