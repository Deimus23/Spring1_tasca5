package Nivel1.Ejercicio3;

import java.io.FileWriter;
import java.io.IOException;

import static Nivel1.Ejercicio3.ListDirectoryBranchToFile.listDirectoryBranch;

public class main {
    public static void main(String[] args) {
        boolean exit=false;

        do{
        if (args.length < 2) {
            System.err.println("Usage: java ListDirectoryBranchToFile <directoryPath> <outputFilePath>");
        }else{
            exit=true;
        }
        }while(!exit);

        String directoryPath = args[0];
        String outputFilePath = args[1];

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            listDirectoryBranch(directoryPath, writer);
            System.err.println("Results saved to file: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
