package javaapplication1;
import javax.swing.*;
import java.awt.*;
public class Personaggio extends JComponent{

    private int x=0,y=0;
    boolean norm=true; //Se è in modalià normale o no
    private final int altezza=64,larghezza=45;
    private Image sopran,soprac, sotton,sottoc,destran,destrac,sinistran,sinistrac,deathn,deathc, pg;
    public Personaggio(int y,int x){
        this.x=x;
        this.y=y;
        /*sopran= new ImageIcon(".//Immagini//sopra.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        sotton= new ImageIcon(".//Immagini//sotto.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);*/
        destran= new ImageIcon(".//Immagini//destra.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        sinistran= new ImageIcon(".//Immagini//sinistra.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        /*deathn= new ImageIcon(".//Immagini//death.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        soprac= new ImageIcon(".//Immagini//sopra.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        sottoc= new ImageIcon(".//Immagini//sotto.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        destrac= new ImageIcon(".//Immagini//destra.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        sinistrac= new ImageIcon(".//Immagini//sinistra.gif").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        deathc= new ImageIcon(".//Immagini//death.gif").getImage().getScaledInstance(larghezza,altezza, WIDTH);*/
        pg = new ImageIcon(".//Immagini//fermo.png").getImage().getScaledInstance(larghezza, altezza, WIDTH);
        
    }
    public void dis_pg(Graphics g, String dire, boolean ostacolo){
        g.setColor(Color.BLACK);
        switch(dire){
            case "sopra":
                    if(norm)
                    {
                        g.drawImage(pg, x, y, this);
                        g.setColor(Color.BLACK);
                    }
                break;
            case "sotto": 
                    if(norm)
                    {
                        g.drawImage(pg, x, y, this);
                        g.setColor(Color.BLACK);
                    } 
                break;
            case "destra": 
                if(!ostacolo)
                    if(norm)
                    {
                        g.drawImage(destran, x, y, this);
                        g.setColor(Color.BLACK);
                        
                    }
                break;
            case "sinistra":
                if(!ostacolo)
                    if(norm)
                    {
                        g.drawImage(sinistran, x, y, this);
                        g.setColor(Color.BLACK);
                    }
                
                break;
            /*case "morte":
                if(!ostacolo)
                    if(norm)
                    deathn.flush();
                    else
                     deathc.flush();   
                else 
                    if(norm)
                        g.drawImage(deathn, x, y, this);
                else
                     g.drawImage(deathc, x, y, this); */
            default: g.drawImage(pg, x, y, this); break;
        }
        if(ostacolo){
            g.drawImage(pg,x,y,this);
        }
    }
    
    public int getAltezza() {
        return altezza;
    }

    public int getLarghezza() {
        return larghezza;
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
}
