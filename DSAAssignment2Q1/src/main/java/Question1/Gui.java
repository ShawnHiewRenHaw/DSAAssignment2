/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author shawn
 */
public class Gui {

    JFrame f;
    JPanel panel;
    JButton loadButton;
    JButton saveButton;
    JButton sortOrder;
    JButton searchStudent;
    JTextField jTFattachString;
    FileReaderWriter fileRW;

    public Gui() {
        //Setting up Frame
        f = new JFrame();
        f.setSize(800, 800);
        f.setLocation(300, 100);
        f.setBackground(Color.GRAY);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.getContentPane();

        //Setting up panel
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);

        //Load File Button
        loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JFileChooser txtFileChooser = new JFileChooser(new File("."));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("", "txt");
                txtFileChooser.setFileFilter(filter);
                int stateTxtFileChooser = txtFileChooser.showOpenDialog(null);

                if (stateTxtFileChooser == JFileChooser.APPROVE_OPTION) {
                    String fileName = txtFileChooser.getSelectedFile().getPath();
                    fileRW.readFile(fileName);
                }
            }
        });

        //Save File Button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String outputFileContent = "";
                for (int i = 0; i < fileRW.lineNumber; i++) {
                    outputFileContent += (fileRW.lineData[i] + " " + jTFattachString.getText() + "\n");
                }

                JFileChooser txtFileChooser = new JFileChooser(new File("output.txt"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("", "txt");
                txtFileChooser.setFileFilter(filter);
                int stateTxtFileChooser = txtFileChooser.showSaveDialog(null);
                if (stateTxtFileChooser == JFileChooser.APPROVE_OPTION) {
                    String fileName = txtFileChooser.getSelectedFile().getPath();
                    fileRW.writeFile(fileName, outputFileContent);
                }
            }
        });

        //Sorting Order of Displayed results
        sortOrder = new JButton("Sorting Order");
        sortOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String[] sortingOrder = new String("By Name Ascending, By Name Descending, By Marks Ascending, By Marks Descending").split(", ");
                String messageInput;
                messageInput = (String) JOptionPane.showInputDialog(null, "Sorting Order", "Sorting Order", JOptionPane.PLAIN_MESSAGE, null, sortingOrder, null);
                if (messageInput.equalsIgnoreCase("By Name Ascending")) {
                    jTFattachString.setText(messageInput);
                }
            }
        });

        //Student Search
        searchStudent = new JButton("Search");

        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(sortOrder);
        panel.add(searchStudent);
        f.add(panel);
        f.setVisible(true);
        fileRW = new FileReaderWriter();
    }
}
