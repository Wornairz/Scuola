/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadratirandom;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author danil
 */
public class Quadrato extends JPanel implements MouseMotionListener ,MouseListener {

    private int x,y, l=200, salvax,salvay;
    private boolean flag=true;
    private FoglioDisegno panel;
    
    Quadrato(FoglioDisegno panel)
    {
        this.panel=panel;
        Random p= new Random();
        setBackground(new Color(p.nextInt(256),p.nextInt(256),p.nextInt(256),p.nextInt(26)+230));
        Dimension schermo=Toolkit.getDefaultToolkit().getScreenSize();
        addMouseMotionListener(this);
        addMouseListener(this);
        x=p.nextInt(schermo.width-l);
        y=p.nextInt(schermo.height-l);
        setBounds(x, y, l, l);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
        if(flag)
        {
            panel.add(this, panel, 0);
            salvax=e.getXOnScreen()-x;
            salvay=e.getYOnScreen()-y;
            flag=false;
        }
        x=e.getXOnScreen()-salvax;
        y=e.getYOnScreen()-salvay;
        setLocation(x, y);
      }

    @Override
    public void mouseMoved(MouseEvent e) {
        }

    @Override
    public void mouseClicked(MouseEvent e) {
      }

    @Override
    public void mousePressed(MouseEvent e) {
       }

    @Override
    public void mouseReleased(MouseEvent e) {
        flag=true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       }

    @Override
    public void mouseExited(MouseEvent e) {
     }
}
