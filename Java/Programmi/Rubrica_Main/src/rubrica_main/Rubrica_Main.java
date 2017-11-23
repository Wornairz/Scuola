/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica_main;
import java.io.*;
/**
 *
 * @author Alessandro
 */
public class Rubrica_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int x;
        String nome, cognome, email, telefono, indirizzo;
        Rubrica rubrica = new Rubrica();
        do{
            System.out.println("Inserisci:");
            System.out.println("1)Inserisci nuovo contatto");
            System.out.println("2)Cancella contatto");
            System.out.println("3)Ordina in ordine alfabetico per nome");
            System.out.println("4)Ordina in ordine alfabetico per cognome");
            System.out.println("5)Visualizza contatto");
            System.out.println("6)Cerca contatto per numero di telefono");
            System.out.println("7)Visualizza tutti i contatti");
            System.out.println("0)Esci dal programma");
            x=Integer.parseInt(input.readLine());
            switch(x){
                case 1:{
                    System.out.println("Inserisci nome");
                    nome=input.readLine();
                    System.out.println("Inserisci cognome");
                    cognome=input.readLine();
                    System.out.println("Inserisci email");
                    email=input.readLine();
                    System.out.println("Inserisci telefono");
                    telefono=input.readLine();
                    System.out.println("Inserisci indirizzo");
                    indirizzo=input.readLine();
                    rubrica.Ins_contatto(nome, cognome, email, telefono, indirizzo);
                    break;
                }
                case 2: {
                    System.out.println("Inserisci il numero di telefono del contatto da eliminare");
                    nome=input.readLine();
                    rubrica.del_contatto(nome);
                    break;
                }
                case 3: {
                    System.out.println("Vuoi ordinare crescente o decrescente?");
                    email=input.readLine();
                    if(email.equals("crescente")){
                        rubrica.ord_cresc_nome();
                    }
                    else if(email.equals("decrescente")){
                        rubrica.ord_decresc_nome();
                    }
                    break;                           
                }
                case 4: {
                    System.out.println("Vuoi ordinare crescente o decrescente?");
                    email=input.readLine();
                    if(email.equals("crescente")){
                        rubrica.ord_cresc_cognome();
                    }
                    else if(email.equals("decrescente")){
                        rubrica.ord_decresc_cognome();
                    }
                    break;    
                }
                case 5: {
                    System.out.println("Inserisci il nome del contatto da cercare");
                    nome=input.readLine();
                    rubrica.vis_cont(nome);
                    break;
                }
                case 6: {
                    System.out.println("Inserisci il numero di telefono da cercare");
                    telefono=input.readLine();
                    rubrica.cerc_num_tel(telefono);
                    break;
                }
                case 7: rubrica.vis_rub(); break;
                case 0: break;
            }
        }while(x!=0);
    }
    
}
