/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincorsa;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro
 */
public class Corridore extends Thread{
    private String nome, cognome;
    private int bonus, eta;
    Corridore(String nome, String cognome, int eta){
        setName(nome + " " + cognome);
        this.nome=nome;
        this.cognome=cognome;
        this.eta=eta;
        if(eta<=18) bonus=4000;
        else if(eta>18 && eta<=35) bonus=3000;
        else if(eta>35 && eta<=60) bonus=2000;
        else if(eta>60) bonus=1000;
    }

    @Override
    public void run() {
        try {
                Thread.sleep(bonus);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corridore.class.getName()).log(Level.SEVERE, null, ex);
            }
        for(int i=0;i<10;i++){
            
        try {
                Thread.sleep(eta*10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Corridore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(getName() + " arrivato");
    }
    
}
