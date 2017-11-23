package corsathreadgrafica;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CorsaThreadGrafica{
    static JFrame finestra;
    Mappa gioco;
    int scommessa;
    public CorsaThreadGrafica(){
        scommessa=0;
        Dimension schermo=Toolkit.getDefaultToolkit().getScreenSize();
        String s = (String)JOptionPane.showInputDialog(finestra, "inserisci il numero di corridori (max 10)", "Selezione numero corridori", JOptionPane.QUESTION_MESSAGE);
        sceltascommessa(schermo, Integer.parseInt(s));
        if(scommessa>0 && scommessa<=10){
            finestra=new JFrame("Corsa");
            finestra.setBounds(0,0, schermo.width, schermo.height);
            finestra.setResizable(false);
            gioco=new Mappa(Integer.parseInt(s), schermo);
            finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            finestra.add(gioco);
            finestra.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new CorsaThreadGrafica();
    } 
    public void sceltascommessa(Dimension schermo, int n_corr){
        JFrame finscelta = new JFrame("Scommessa");
        Image[] immagini = new Image[n_corr];
        JButton[] bottoni = new JButton[n_corr];
        finscelta.setLayout(new GridLayout(n_corr+1, 1));
        finscelta.setBounds((schermo.width/2)-100, (schermo.height/2)-250, 200, 500);
        finscelta.add(new JLabel("Scegli un corridore su cui puntare"));
        for(int i=0;i<n_corr;i++){
            //immagini[i]=new ImageIcon(".//Immagini//corridore (" + (i+1) + ")").getImage().getScaledInstance(200, 100, 1);
            immagini[i]=new ImageIcon("corridore").getImage().getScaledInstance(200, 100, 1);
            bottoni[i]=new JButton(new ImageIcon(immagini[i]));
            finscelta.add(bottoni[i]);
        }
        finscelta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finscelta.setVisible(true);
    }
    public class Bott_Scommessa extends JButton{

        private int n;
        Bott_Scommessa(Icon icon, int n){
            super(icon);
            this.n=n;
        }
        @Override
        public void addActionListener(ActionListener l) {
            super.addActionListener(l);
            
        }
        
    }
}
