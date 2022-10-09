/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question1;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shawn
 */
public class Gui {

    JFrame f;
    JPanel panel;
    JButton loadButton;
    JButton saveButton;
    JOptionPane sortOrder;
    JButton searchStudent;

    public Gui() {
        //Setting up Frame
        f = new JFrame();
        f.setSize(800, 800);
        f.setLocation(300, 100);
        f.setBackground(Color.GRAY);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.getContentPane();
        f.setVisible(true);

        //Setting up panel
        panel = new JPanel();
        panel.setBackground(Color.GRAY);

        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        sortOrder = new JOptionPane("Sorting Order");
        searchStudent = new JButton("Search");

        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(sortOrder);
        panel.add(searchStudent);
        f.add(panel);
    }
}
