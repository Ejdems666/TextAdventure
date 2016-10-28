/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Tobias Grundtvig
 */
public class FileIO {
    private String path;

    public FileIO(String path) {
        this.path = path;
    }
    public FileIO() {
        path = "../resources/";
    }

    public ArrayList<String> readFile(String fileName) throws IOException {
        BufferedReader buffered = new BufferedReader(new FileReader(path + fileName));
        ArrayList<String> contents = new ArrayList<>();
        try {
            String line = buffered.readLine();
            while (line != null) {
                contents.add(line);
                line = buffered.readLine();
            }
        } finally {
            buffered.close();
        }
        return contents;
    }

    public void writeFile(String fileName, String content) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(path + fileName)));
            writer.write(content);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
