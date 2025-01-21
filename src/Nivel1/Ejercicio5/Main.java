package Nivel1.Ejercicio5;

import Nivel1.Ejercicio5.ListDirectoryBranch;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        boolean exit=false;
        do {
            if (args.length < 2) {
                System.out.println("Usage:");
                System.out.println("1. List directory and save to a file: java ListDirectoryBranchToFile <directoryPath> <outputFilePath>");
                System.out.println("2. Read a text file: java ListDirectoryBranchToFile read <filePath>");
            }else{
                exit=true;
            }
        }while(!exit);
        try {
            if (args[0].equalsIgnoreCase("collect")) {

                if (args.length < 3) {
                    System.out.println("Usage: java Main collect <directoryPath> <outputFilePath>");
                    return;
                }
                String directoryPath = args[1];
                String outputFilePath = args[2];

                DirectoryInfo directoryInfo = ListDirectoryBranch.listDirectoryBranch(directoryPath);
                ListDirectoryBranch.serializeObject(directoryInfo, outputFilePath);
                System.out.println("Directory information serialized successfully to " + outputFilePath);
            } else if (args[0].equalsIgnoreCase("deserialize")) {

                String inputFilePath = args[1];
                DirectoryInfo directoryInfo = ListDirectoryBranch.deserializeObject(inputFilePath);
                System.out.println("Deserialized content:");
                for (String entry : directoryInfo.getEntries()) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("Invalid mode. Use 'collect' or 'deserialize'.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


