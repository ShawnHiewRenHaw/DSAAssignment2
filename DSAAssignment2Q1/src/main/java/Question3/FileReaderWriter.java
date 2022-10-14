/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question3;

import Question1.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author shawn
 */
public class FileReaderWriter {

    public String name;
    public String[] lineData;
    public int lineNumber;

    public FileReaderWriter() {
        lineData = new String[1000];
    }

    public void readFile(String fileName) {
        File f = new File(fileName);
        try {
            Scanner myScanner = new Scanner(f);
            lineNumber = 0;
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                lineData[lineNumber] = line;
                lineNumber++;
            }
            myScanner.close();
        } catch (IOException e) {
            System.out.println("Cannot read the file " + e.getMessage());
        }
    }

    //System.getProperty("line.separator");
    public void writeFile(String fileName, String c) {
        File f = new File(fileName);

        try {
            f.createNewFile();
            FileWriter writer = new FileWriter(f);
            writer.write(c);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Cannot write to the file" + e.getMessage());
        }
    }
}
