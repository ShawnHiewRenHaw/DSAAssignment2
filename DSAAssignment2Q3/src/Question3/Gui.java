/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question3;

import java.awt.Color;
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
    JButton sortOrder;
    JTextField jTFattachString;
    FileReaderWriter fileRW;

    public Gui() {
        //Setting up Frame
        f = new JFrame();
        f.setSize(500, 200);
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

            }
        });

        panel.add(loadButton);
        panel.add(sortOrder);
        f.add(panel);
        f.setVisible(true);
        fileRW = new FileReaderWriter();
    }
}
