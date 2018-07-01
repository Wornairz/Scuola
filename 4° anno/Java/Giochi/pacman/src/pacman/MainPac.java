package pacman;
import java.awt.*;
import javax.swing.*;

public class MainPac {
    static JFrame finestra;
    Mappa gioco=new Mappa();
    public MainPac(){
        finestra=new JFrame();
        finestra.setResizable(false);
        Dimension schermo=Toolkit.getDefaultToolkit().getScreenSize();
        finestra.setLocation(((int)schermo.getWidth()-760)/2,((int)schermo.getHeight()-800)/2);
        gioco=new Mappa();
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.add(gioco);
        finestra.pack();
        finestra.setVisible(true);
    }
    public static void main(String[] args) {
        new MainPac();
    } 
}