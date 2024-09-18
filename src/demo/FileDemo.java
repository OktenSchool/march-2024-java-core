package demo;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileDemo {

    public static void main(String[] args) {
        System.out.println(readFromFile("test.txt"));
        writeToFile("test.txt", "content from FileDemo");
        System.out.println(readFromFile("test.txt"));
    }

    @SneakyThrows
    public static void writeToFile(String fileName, String content) {
        Path filePath = Paths.get(fileName);
        Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @SneakyThrows
    public static String readFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
        return Files.readString(filePath);
    }
}
