/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negozio;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro
 */
public class Negozio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino();
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        String compara = null;
        int x = 0;
        do{
            System.out.println("Fai scelta");
            try {
                x=Integer.parseInt(tastiera.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Negozio.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch(x){
                case 1: {
                    Articolo articolo = new Articolo();
                    try {
                        System.out.println("Inserisci categoria");
                        articolo.setCategoria(tastiera.readLine());
                        System.out.println("Inserisci codice");
                        articolo.setCodice(tastiera.readLine());
                        if(magazzino.esistente(articolo.getCodice())){
                            System.out.println("Il codice" + articolo.getCodice() +  "già esistente");
                            break;
                        }
                        System.out.println("Inserisci descrizione");
                        articolo.setDescrizione(tastiera.readLine());
                        System.out.println("Inserisci scorta minima");
                        articolo.setScortaminima(Integer.parseInt(tastiera.readLine()));
                        System.out.println("Inserisci giacenza");
                        articolo.setGiacenza(Integer.parseInt(tastiera.readLine()));
                        System.out.println("Inserisci prezzo unitario");
                        articolo.setP_unit(Float.parseFloat(tastiera.readLine()));
                    } catch (IOException ex) {
                        Logger.getLogger(Negozio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    magazzino.add_articolo(articolo);
                    break;
                }
                case 2: magazzino.vis_mag(); break;
                case 3: {
                    Movimento mov = new Movimento();
                    System.out.println("Movimento in entrata o in uscita?");
                    try {
                        compara=tastiera.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(Negozio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    compara=compara.toLowerCase();
                    if(compara.equals("entrata")){
                        try {
                            System.out.println("Inserisci la data del movimento");
                            mov.setData(tastiera.readLine());
                            System.out.println("Inserisci il codice");
                            compara=tastiera.readLine();
                            if(!magazzino.esistente(compara)){
                                System.out.println("Codice inesistente");
                            }
                            else mov.setCodice(compara);
                            mov.setQuantità(Integer.parseInt(tastiera.readLine()));
                        } catch (IOException ex) {
                            Logger.getLogger(Negozio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        magazzino.mov_entrata(mov);
                    }
                    else if(compara.equals("uscita")){
                        try {
                            System.out.println("Inserisci la data del movimento");
                            mov.setData(tastiera.readLine());
                            System.out.println("Inserisci il codice");
                            compara=tastiera.readLine();
                            if(!magazzino.esistente(compara)){
                                System.out.println("Codice inesistente");
                            }
                            else mov.setCodice(compara);
                            mov.setQuantità(Integer.parseInt(tastiera.readLine()));
                        } catch (IOException ex) {
                            Logger.getLogger(Negozio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        magazzino.mov_uscita(mov);
                    }
                    else System.out.println("Errore, riprova.");
                    break;
                }
                case 4: {
                    System.out.println("Movimenti in entrata o in uscita?");
                    try {
                        compara=tastiera.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(Negozio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    compara=compara.toLowerCase();
                    if(compara.equals("entrata")){
                        magazzino.vis_mov_entrata();
                    }
                    else if(compara.equals("uscita")){
                        magazzino.vis_mov_uscita();
                    }
                    else System.out.println("Errore");
                    break;
                }
                case 0: break;
                default: System.out.println("Errore"); break;
            }
        }while(x!=0);
    }
    
}
