/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corsathreadgrafica;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Alessandro
 */
public class Mappa extends JPanel implements ActionListener{
    
    private final int n_corr;
    private static int c;
    private Corridore corridore[];
    private Timer timer;
    Mappa(int n_corr, Dimension schermo){
        timer = new Timer(30, this);
        this.n_corr=n_corr;
        setPreferredSize(new Dimension(CorsaThreadGrafica.finestra.getWidth(), CorsaThreadGrafica.finestra.getHeight()));
        corridore = new Corridore[n_corr];
        for (int i = 0; i < n_corr; i++) {
            new Thread(corridore[i]=new Corridore(schermo.height/n_corr, schermo.width/n_corr/2)).start();
            corridore[i].setY(i*schermo.height/n_corr);
        }
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < n_corr; i++) {
            corridore[i].disegna(g);
        }
    }
    public static int arrivato(){
        c++;
        return c;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            repaint();
    }
}
