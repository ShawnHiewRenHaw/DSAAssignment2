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
import javax.swing.JTextArea;
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
    BinaryTree bTree;
    JTextField searchBar;

    public Gui() {
        //Setting up Frame
        f = new JFrame();
        f.setSize(1000, 500);
        f.setLocation(300, 100);
        f.setBackground(Color.GRAY);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.getContentPane();

        //Setting up panel
        panel = new JPanel();
        panel.setBackground(Color.GRAY);

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
                    int i = 0;
                    String newStudentString = "";
                    bTree = new BinaryTree(0, null);
                    while (fileRW.lineData[i] != null) {
                        System.out.println(fileRW.lineData[i]);
                        newStudentString = fileRW.lineData[i];
                        String[] split = newStudentString.split(", ");
                        Student newStudent = new Student(split[0], Integer.parseInt(split[1]));
                        newStudent.setKey(split[0]);
                        Node newNode = new Node(newStudent);
                        if (bTree.getRoot() == null) {
                            bTree.setRoot(newNode);
                            System.out.println(newNode.getData().toString());
                        } else {
                            bTree.add(newNode);
                            System.out.println(newNode.getData().toString());
                        }
                        ++i;
                    }
                }
            }
        });

        //Save File Button
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String outputFileContent = "";
                outputFileContent = bTree.getOutput();
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
                String[] sortingOrder = new String("By Name Ascending, By Name Descending").split(", ");
                String messageInput;
                messageInput = (String) JOptionPane.showInputDialog(null, "Sorting Order", "Sorting Order", JOptionPane.PLAIN_MESSAGE, null, sortingOrder, null);
                if (messageInput.equalsIgnoreCase("By Name Ascending")) {
                    System.out.println("Name Ascend");
                    bTree.traversal();
                } else if (messageInput.equalsIgnoreCase("By Name Descending")) {
                    System.out.println("Name Descend");
                    bTree.reverseOrder();
                }
            }
        });

        //Student Search Bar
        searchBar = new JTextField(25);
        searchBar.setSize(100, 200);

        //Student Search Button
        searchStudent = new JButton("Search");
        searchStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String input = searchBar.getText();
                bTree.findNode(input);
                JOptionPane.showMessageDialog(null, bTree.getFound(), "Search Student", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(sortOrder);
        panel.add(searchStudent);
        panel.add(searchBar);
        f.add(panel);
        f.setVisible(true);
        fileRW = new FileReaderWriter();
    }
}
