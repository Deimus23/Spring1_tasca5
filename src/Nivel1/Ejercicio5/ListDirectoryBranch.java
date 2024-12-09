package Nivel1.Ejercicio5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    class DirectoryInfo implements Serializable {
        private static final long serialVersionUID = 1L;

        private final List<String> entries;

        public DirectoryInfo() {
            this.entries = new ArrayList<>();
        }

        public void addEntry(String entry) {
            entries.add(entry);
        }

        public List<String> getEntries() {
            return entries;
        }
    }

    public class ListDirectoryBranch {
        public ListDirectoryBranch() {
        }

        public static DirectoryInfo listDirectoryBranch(String path) {
            DirectoryInfo directoryInfo = new DirectoryInfo();
            File[] listDirectory = new File(path).listFiles();
            if (listDirectory != null) {
                Arrays.sort(listDirectory);
                for (File order : listDirectory) {
                    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String date = formatDate.format(order.lastModified());
                    String type = order.isDirectory() ? "D" : "F";
                    String entry = type + " - " + order.getName() + " Last modified: " + date;

                    directoryInfo.addEntry(entry);

                    if (order.isDirectory()) {
                        directoryInfo.getEntries().addAll(listDirectoryBranch(order.getAbsolutePath()).getEntries());
                    }
                }
            } else {
                directoryInfo.addEntry("The route for the directory isn't correct");
            }
            return directoryInfo;
        }

        public static void serializeObject(DirectoryInfo directoryInfo, String outputFilePath) throws IOException {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFilePath))) {
                oos.writeObject(directoryInfo);
                System.out.println("Object serialized to file: " + outputFilePath);
            }
        }

        public static DirectoryInfo deserializeObject(String inputFilePath) throws IOException, ClassNotFoundException {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputFilePath))) {
                return (DirectoryInfo) ois.readObject();
            }
        }

    }
