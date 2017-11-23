/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsathreadgrafica;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author Alessandro
 */
public class Corridore extends JComponent implements Runnable{

    
    private int x, alt, y,larg, pos;
    private boolean stop=false;
    private final Image corridore;
    private Random r ;
    Corridore(int alt, int larg){
        r = new Random();
        x=0; pos=0;
        this.alt=alt;
        this.larg=larg;
        corridore = new ImageIcon("destra.gif").getImage().getScaledInstance(larg, alt, WIDTH);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void disegna(Graphics g) {
        if(pos==0) g.drawImage(corridore, x, y, this);
        else {
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD , 30));
            g.drawString("" + pos, larg, y+(alt/2));
        }
    }
    
    public int getAltezza(){
        return alt;
    }
    public int getLarghezza(){
        return larg;
    }
    @Override
    public void run() {
        while((x+larg)<CorsaThreadGrafica.finestra.getWidth())
        { 
            setX(getX()+r.nextInt(5));
            try { Thread.sleep(20); } catch (InterruptedException ex) {}
        }
        pos=Mappa.arrivato();
    }
    
}
