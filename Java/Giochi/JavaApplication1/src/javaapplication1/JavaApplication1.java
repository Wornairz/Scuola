/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class JavaApplication1 {
    Mappa gioco;
    JFrame finestra;
    Thread cs;
    JavaApplication1() {
        finestra=new JFrame();
        Dimension schermo=Toolkit.getDefaultToolkit().getScreenSize();
        finestra.setSize(schermo);
        finestra.setResizable(false);
        finestra.setUndecorated(true);
        gioco = new Mappa(schermo);
        finestra.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), new Point(0,0) , ""));
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.add(gioco);
        finestra.setVisible(true);
        
    }
    public static void main(String[] args) {    
        new JavaApplication1();
    } 
}