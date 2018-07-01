/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negozio;
import java.util.Vector;

/**
 *
 * @author Alessandro
 */
public class Magazzino {
    private Vector<Articolo> articoli = new Vector(1,1);
    private Vector<Movimento> entrata = new Vector(1,1);
    private Vector<Movimento> uscita = new Vector(1,1);
    
    public void add_articolo(Articolo oggetto){
        articoli.addElement(oggetto);
    }
    public void vis_mag(){
        if(articoli.size()>0){
            Articolo oggetto;
            int i;
            for(i=0;i<articoli.size();i++){
                System.out.println("-----Prodotto " + (i+1) + "-----");
                oggetto = (Articolo) articoli.elementAt(i);
                System.out.println("Categoria: " + oggetto.getCategoria());
                System.out.println("Codice: " + oggetto.getCodice());
                System.out.println("Descrizione: " + oggetto.getDescrizione());
                System.out.println("Giacenza: " + oggetto.getGiacenza());
                System.out.println("Prezzo unitario: "+oggetto.getP_unit());
            }
        }
        else System.out.println("Nessun articolo nel magazzino");
    }
    public boolean esistente(String codice){
        int i;
        Articolo oggetto;
        boolean controllo = false;
        for(i=0;i<articoli.size();i++){
            oggetto = (Articolo) articoli.elementAt(i);
            if(oggetto.getCodice().equals(codice)){
                controllo = true;
            }
        }
        return controllo;
    }
    public void mov_entrata(Movimento m_entrata){
        int i;
        Articolo art;
        entrata.addElement(m_entrata);
        for(i=0;i<entrata.size();i++){
            art = (Articolo) articoli.elementAt(i);
            if(m_entrata.getCodice().equals(art.getCodice())){
                art.setGiacenza(art.getGiacenza()+m_entrata.getQuantità());
                articoli.removeElementAt(i);
                articoli.addElement(art);
            }
        }
    }
    public void mov_uscita(Movimento m_uscita){
        int i;
        Articolo art;
        uscita.addElement(m_uscita);
        for(i=0;i<uscita.size();i++){
            art = (Articolo) articoli.elementAt(i);
            if(m_uscita.getCodice().equals(art.getCodice())){
                art.setGiacenza(art.getGiacenza()+m_uscita.getQuantità());
                articoli.removeElementAt(i);
                articoli.addElement(art);
            }
        }
        
    }
    public void vis_mov_entrata(){
        int i;
        Movimento movimento;
        if(entrata.size()>0){
            for(i=0;i<entrata.size();i++){
                movimento = (Movimento) entrata.elementAt(i);
                System.out.println("Data: " + movimento.getData());
                System.out.println("Codice: " + movimento.getCodice());
                System.out.println("Quantità: " + movimento.getQuantità());
            }
        }
    }
    public void vis_mov_uscita(){
        int i;
        Movimento movimento;
        if(uscita.size()>0){
            for(i=0;i<uscita.size();i++){
                movimento = (Movimento) uscita.elementAt(i);
                System.out.println("Data: " + movimento.getData());
                System.out.println("Codice: " + movimento.getCodice());
                System.out.println("Quantità: " + movimento.getQuantità());
            }
        }
    }
}
