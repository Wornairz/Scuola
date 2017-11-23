package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Fantasma extends JComponent{

  
    private int x=0,y=0;
    private final int r=40;
    private Image up,down,left,right;
    Fantasma(String colore){
        if(colore.equals("red")){
            setX(360);
            setY(280);
        }
        if(colore.equals("orange")){
            setX(320);
            setY(360);
        }
        if(colore.equals("pink")){
            setX(360);
            setY(360);
        }
        if(colore.equals("blue")){
            setX(400);
            setY(360);
        }
        up=new ImageIcon(".\\Immagini\\"+colore+" up.gif").getImage().getScaledInstance(r, r, WIDTH);
        down=new ImageIcon(".\\Immagini\\"+colore+" down.gif").getImage().getScaledInstance(r, r, WIDTH);
        left=new ImageIcon(".\\Immagini\\"+colore+" left.gif").getImage().getScaledInstance(r, r, WIDTH);
        right=new ImageIcon(".\\Immagini\\"+colore+" right.gif").getImage().getScaledInstance(r, r, WIDTH);
    }
    public void dis_fantasma(Graphics g, String direzione){
        if(direzione.equals("up"))          g.drawImage(up, x, y, this);
        else if(direzione.equals("down"))   g.drawImage(down, x, y, this);
        else if(direzione.equals("left"))   g.drawImage(left, x, y, this);
        else if(direzione.equals("right"))   g.drawImage(right, x, y, this);     
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
    public int getR() {
        return r;
    }
}
