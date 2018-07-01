/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainscambio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro
 */
public class MainScambio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Pila lista = new Pila();
        int scelta=0, prova = 0;
        boolean flag;
        do{
            System.out.println("Inserisci 0 per uscire dal programma");
            System.out.println("Inserisci 1 per inserire in coda alla lista");
            System.out.println("Inserisci 2 per effettuare l'ordinamento");
            System.out.println("Inserisci 3 per visualizzare la lista");
            do{
                flag=false;
                try {
                    scelta=Integer.parseInt(buffer.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(MainScambio.class.getName()).log(Level.SEVERE, null, ex);
                }catch (NumberFormatException ex){
                    flag=true;
                    System.out.println("Inserisci un numero, non una stringa");
                }
            }while(flag==true);
            if(scelta<0 || scelta>3){
                System.out.println("Inserisci un numero corretto");
            }
            else{
                switch(scelta){
                    case 0: System.exit(0); break;
                    case 1: {
                        System.out.println("Inserisci il numero da inserire in coda");
                        do{
                            flag=false;
                            try {
                                prova=Integer.parseInt(buffer.readLine());
                            } catch (IOException ex) {
                                Logger.getLogger(MainScambio.class.getName()).log(Level.SEVERE, null, ex);
                            }catch (NumberFormatException ex){
                                flag=true;
                                System.out.println("Inserisci un numero, non una stringa");
                            }
                        }while(flag==true);
                        lista.InserisciInCoda(prova);
                        break;
                    }
                    case 2: {
                        lista.EliminaInCoda();
                        System.out.println("Ordinamento effettuato!");
                        break;
                    }
                    case 3: {
                        lista.visualizza();
                        break;
                    }
                }
            }
        }while(scelta!=0);
    }
    
}
