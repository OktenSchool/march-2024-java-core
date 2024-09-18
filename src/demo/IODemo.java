package demo;

import lombok.SneakyThrows;

import java.io.*;
import java.util.stream.Collectors;

public class IODemo {

    public static void main(String[] args) {
        // I/O Stream

        // InputStream
        // OutputStream

        for (int i = 0; i < 400_000; i++) {
            // try-with-resources
            try (FileInputStream fis = new FileInputStream("test.txt")) {
                System.out.println("Open file #" + i + " has content: " + new String(fis.readAllBytes()));
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (Reader reader = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(reader)) {
            String userInput = br.readLine();
            System.out.println("You just entered: " + userInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(readFromFile("test.txt"));
        writeToFile("test.txt", "test1");
        System.out.println(readFromFile("test.txt"));
        writeToFile("test.txt", "test2");
        System.out.println(readFromFile("test.txt"));
    }

    @SneakyThrows
    private static void writeToFile(String fileName, String content) {
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(file, true);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"))) {
            bw.write(content);
        }
    }

    @SneakyThrows
    private static String readFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            return br.lines().collect(Collectors.joining("\n"));
        }
    }
}
