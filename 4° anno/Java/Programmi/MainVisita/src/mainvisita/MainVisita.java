/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainvisita;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
/**
 *
 * @author Alessandro
 */
public class MainVisita {
    private static ListaPazienti lista;
    private static JFrame finestra;
    private static JTextArea areapaz;
    private static boolean aperta=false;
    public static void main(String[] args) {
        finestra = new JFrame("Sala d'Attesa");
        lista = new ListaPazienti();
        finestra.getContentPane().setLayout(new GridLayout(3,1));
        JButton aggpaz = new JButton("Aggiungi un paziente alla lista");
        JButton visita = new JButton("Visita un paziente");
        areapaz= new JTextArea();
        areapaz.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(areapaz);
        aggpaz.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!aperta){
                    new FramePazienti();
                    aperta=true;
                }
            }
            
        });
        visita.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(lista.EliminaInTesta()) aggiorna_lista();
                else JOptionPane.showMessageDialog(finestra, "Nessun cliente da visitare", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        });
        finestra.add(scrollpane);
        finestra.add(aggpaz); finestra.add(visita);
        finestra.setBounds(400,400, 300, 500);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
    }
    private static class FramePazienti{
        JFrame frame;
        JButton addbtn;
        JLabel nomelb;
        JLabel cognomelb;
        JTextField nometf;
        JTextField cognometf;
        FramePazienti(){
            frame = new JFrame("Aggiungi un paziente");
            addbtn = new JButton("Aggiungi");
            nomelb = new JLabel("Nome ");
            cognomelb = new JLabel("Cognome ");
            nometf = new JTextField();
            cognometf = new JTextField();
            addbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Paziente p = new Paziente(nometf.getText(), cognometf.getText());
                    if(nometf.getText().equals("") || cognometf.getText().equals("")){
                        JOptionPane.showMessageDialog(frame, "Devi inserire nome e cognome", "Errore", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        lista.InserisciInCoda(p);
                        nometf.setText("");
                        cognometf.setText("");
                        aggiorna_lista();
                    }
                }
            });
            frame.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    aperta=false;
                }

                
            });
            frame.getContentPane().setLayout(new GridLayout(4,2));
            frame.add(nomelb); frame.add(nometf);
            frame.add(cognomelb); frame.add(cognometf);
            frame.add(addbtn);
            frame.setBounds(700,400, 300, 500);
            frame.setVisible(true);
        }
        
    }
    public static void aggiorna_lista(){
        areapaz.setText("");
        for(int i=0;i<lista.getElementi();i++){
            Paziente temp=lista.PazienteInPosizione(i+1);
            areapaz.append("Paziente " + (i+1) + "\n" + "Nome :" + temp.getNome() + "\n" + "Cognome: " + temp.getCognome() + "\n");
            areapaz.append("-----------\n");
        }
    }
}
