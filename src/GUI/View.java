/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.*;
import compressdecompress.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author yash
 */
public class View extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
            
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select File to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 100, 200, 30);
        
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 100, 200, 30);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setSize(500, 200);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compress.method(file);
                }
                catch(Exception exp){
                    JOptionPane.showMessageDialog(null, exp.toString());
                }
            }
        }
        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.method(file);
                }
                catch(Exception exp){
                    JOptionPane.showMessageDialog(null, exp.toString());
                }
            }
        }
    }
    
    public static void main(String[] args){      
        View view = new View();
        view.setVisible(true);
    }
}
