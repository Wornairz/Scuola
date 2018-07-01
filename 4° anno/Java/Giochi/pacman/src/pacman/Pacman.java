package pacman;
import javax.swing.*;
import java.awt.*;

public class Pacman extends JComponent{
    private int x=0,y=0;
    private final int r=40;
    private final Image sopra, sotto, destra, sinistra, sopra2, sotto2, destra2, sinistra2, death;
    public Pacman(){
        x=360;
        y=600;
        sopra = new ImageIcon(".//Immagini//sopra.gif").getImage().getScaledInstance(r, r, WIDTH);
        sotto = new ImageIcon(".//Immagini//sotto.gif").getImage().getScaledInstance(r, r, WIDTH);
        destra = new ImageIcon(".//Immagini//destra.gif").getImage().getScaledInstance(r, r, WIDTH);
        sinistra = new ImageIcon(".//Immagini//sinistra.gif").getImage().getScaledInstance(r, r, WIDTH);
        sopra2 = new ImageIcon(".//Immagini//sopra.png").getImage().getScaledInstance(r, r, WIDTH);
        sotto2 = new ImageIcon(".//Immagini//sotto.png").getImage().getScaledInstance(r, r, WIDTH);
        destra2 = new ImageIcon(".//Immagini//destra.png").getImage().getScaledInstance(r, r, WIDTH);
        sinistra2 = new ImageIcon(".//Immagini//sinistra.png").getImage().getScaledInstance(r, r, WIDTH);
        death = new ImageIcon(".//Immagini//death.gif").getImage().getScaledInstance(r, r, WIDTH);
    }
    public void dis_pac(Graphics g, String dire, boolean ostacolo){
        switch(dire){
            case "up": {
                if(!ostacolo){
                    g.drawImage(sopra, x, y, this);
                }
                else g.drawImage(sopra2, x, y, this);
                break;
            }
            case "down": {
                if(!ostacolo){
                    g.drawImage(sotto, x, y, this); 
                }
                else g.drawImage(sotto2, x, y, this);
                break;
            }
            case "right": {
                if(!ostacolo){
                    g.drawImage(destra, x, y, this);    
                }
                else g.drawImage(destra2, x, y, this);
                break;
            }
            case "left":{
                if(!ostacolo){
                    g.drawImage(sinistra, x, y, this);
                }
                else g.drawImage(sinistra2, x, y, this);
                break;
            }
            case "morte":{
                g.drawImage(death, x, y, this);
                break;
            }
        }
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
