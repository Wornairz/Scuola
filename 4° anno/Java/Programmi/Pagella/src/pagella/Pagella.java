/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagella;

import java.io.*;

/**
 *
 * @author Alessandro
 */
public class Pagella {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Alunno alunno = new Alunno();
        int x, voto, i;
        String tipo;
        boolean flag;
        System.out.println("Inserisci il tuo nome e cognome");
        alunno.setNome(input.readLine());
        
        do{
            System.out.println("Alunno: " + alunno.getNome());
            System.out.println("Inserisci");
            System.out.println("1) Aggiungi voto");
            System.out.println("2) Visualizza tutti i voti di una materia");
            System.out.println("3) Visualizza l'elenco delle materie e le relative posizioni");
            System.out.println("4) Calcola media di una materia");
            System.out.println("0) Esci da programma");
            x=Integer.parseInt(input.readLine());
            switch(x){
                case 1: {
                    System.out.println("Inserisci la materia di cui vuoi inserire il voto");
                    tipo=input.readLine();
                    tipo=tipo.toLowerCase();
                    flag=false;
                    for(i=0;i<10;i++){
                        if(alunno.materia[i].getNome().equals(tipo))
                        {
                            System.out.println("Inserisci il tipo");
                            tipo=input.readLine();
                            System.out.println("Inserisci il voto");
                            voto=Integer.parseInt(input.readLine());
                            alunno.materia[i].addvoto(tipo, voto);
                            flag=true;
                        }
                    }
                    if(!flag){
                        System.out.println("Materia inesistente");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Inserisci la materia di cui vuoi visualizzare il voto");
                    tipo=input.readLine();
                    tipo=tipo.toLowerCase();
                    flag=false;
                    for(i=0;i<10;i++){
                        if(alunno.materia[i].getNome().equals(tipo))
                        {
                            alunno.materia[i].allvoti();
                            flag=true;
                        }
                    }
                    if(!flag){
                        System.out.println("Materia inesistente");
                    }
                    break;
                }
                case 3: {
                    for(i=0;i<10;i++){
                        System.out.println("Materia " + (i+1) + ":" + alunno.materia[i].getNome());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Inserisci la materia di cui vuoi calcolare la media");
                    tipo=input.readLine();
                    tipo=tipo.toLowerCase();
                    flag=false;
                    for(i=0;i<10;i++){
                        if(alunno.materia[i].getNome().equals(tipo))
                        {
                            if(alunno.materia[i].media()!=0) System.out.println("La media di " + alunno.materia[i].getNome() + " è " + alunno.materia[i].media());
                            else System.out.println("Inserisci prima un voto");
                            flag=true;
                        }
                    }
                    if(!flag){
                        System.out.println("Materia inesistente");
                    }
                    
                }
                case 0: break;
                default: System.out.println("Numero errato"); break;
            }
        }while(x!=0);
    }
    
}
