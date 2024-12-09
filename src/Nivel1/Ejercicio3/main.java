package Nivel1.Ejercicio3;

import java.io.FileWriter;
import java.io.IOException;

import static Nivel1.Ejercicio3.ListDirectoryBranchToFile.listDirectoryBranch;

public class main {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: java ListDirectoryBranchToFile <directoryPath> <outputFilePath>");
            return;

        }

        String directoryPath = args[0]; // Primer argumento: ruta del directorio
        String outputFilePath = args[1]; // Segundo argumento: ruta del archivo de salida

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            listDirectoryBranch(directoryPath, writer);
            System.out.println("Results saved to file: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
