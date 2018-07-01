/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincorsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro
 */
public class MainCorsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Corridore c1 = null, c2 = null, c3 = null, c4 = null;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Inserisci in ordine: Nome, Cognome, età");
                c1 = new Corridore(buff.readLine(), buff.readLine(), Integer.parseInt(buff.readLine()));
                System.out.println("Inserisci in ordine: Nome, Cognome, età");
                c2 = new Corridore(buff.readLine(), buff.readLine(), Integer.parseInt(buff.readLine()));
                System.out.println("Inserisci in ordine: Nome, Cognome, età");
                c3 = new Corridore(buff.readLine(), buff.readLine(), Integer.parseInt(buff.readLine()));
                System.out.println("Inserisci in ordine: Nome, Cognome, età");
                c4 = new Corridore(buff.readLine(), buff.readLine(), Integer.parseInt(buff.readLine()));
            } catch (IOException ex) {
                Logger.getLogger(MainCorsa.class.getName()).log(Level.SEVERE, null, ex);
            }
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}
