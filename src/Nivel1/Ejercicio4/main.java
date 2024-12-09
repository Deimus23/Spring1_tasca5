package Nivel1.Ejercicio4;

import java.io.FileWriter;
import java.io.IOException;

import static Nivel1.Ejercicio4.ListDirectoryBranchToFile.listDirectoryBranch;
import static Nivel1.Ejercicio4.ListDirectoryBranchToFile.readTxtFile;

public class main {public static void main(String[] args) {

    if (args.length < 2) {
        System.out.println("Usage:");
        System.out.println("1. List directory and save to a file: java ListDirectoryBranchToFile <directoryPath> <outputFilePath>");
        System.out.println("2. Read a text file: java ListDirectoryBranchToFile read <filePath>");
        return;
    }

    try {
        if (args[0].equalsIgnoreCase("read")) {

            String filePath = args[1];
            readTxtFile(filePath);
        } else {

            String directoryPath = args[0];
            String outputFilePath = args[1];

            try (FileWriter writer = new FileWriter(outputFilePath)) {
                listDirectoryBranch(directoryPath, writer);
                System.out.println("Results saved to file: " + outputFilePath);
            }
        }
    } catch (IOException e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}
}
