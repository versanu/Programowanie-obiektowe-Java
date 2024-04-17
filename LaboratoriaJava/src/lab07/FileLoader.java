package lab07;

import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;

import javax.swing.JFileChooser;

public class FileLoader {
	private File selectedFile;
    private String fileContent;
    
    public void chooseAndLoadFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(null);
        
        if (option == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            loadFileContent();
        } else {
            System.out.println("File selection canceled.");
        }
    }

    private void loadFileContent() {
        try (InputStreamReader isr = new InputStreamReader(
                new FileInputStream(selectedFile), Charset.forName("UTF-8").newDecoder())) {

            StringBuilder contentBuilder = new StringBuilder();
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = isr.read(buffer, 0, buffer.length)) != -1) {
                contentBuilder.append(buffer, 0, bytesRead);
            }

            fileContent = contentBuilder.toString();
            System.out.println("File loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading file: " + e.getMessage());
        }
    }

    public String getFileContent() {
        return fileContent;
    }

    public static void main(String[] args) {
        FileLoader fileLoader = new FileLoader();
        fileLoader.chooseAndLoadFile();

        // Example usage: printing the loaded file content
        String content = fileLoader.getFileContent();
        if (content != null) {
            System.out.println("Loaded file content:\n" + content);
        }
    }
}
