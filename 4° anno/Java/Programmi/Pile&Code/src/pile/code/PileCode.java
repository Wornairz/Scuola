/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pile.code;

import java.util.Scanner;

/**
 *
 * @author Alessandro
 */
public class PileCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0, s = 0, val = 0;
        System.out.println("Inserisci 1 per una pila, 2 per una coda, 0 esci");
        if(scanner.hasNextInt()){
            x=scanner.nextInt();
        }
        if(x==1){
            Pila pila = new Pila();
            do{
                System.out.println("Inserisci 1 per aggiungere un elemento alla pila");
                System.out.println("Inserisci 2 per rimuovere l'ultimo elemento della pila");
                System.out.println("Inserisci 3 per visualizzare l'ultimo elemento della pila");
                System.out.println("Inserisci 4 per visualizzare la pila");
                System.out.println("Inserisci 0 per uscire");
                if(scanner.hasNextInt()){
                    s=scanner.nextInt();
                }
                switch(s){
                    case 1: {   
                        System.out.println("Inserisci il valore");
                        if(scanner.hasNextInt()){
                            val=scanner.nextInt();
                            pila.Push(val);
                        }
                        break;
                    }
                    case 2: pila.Pop(); break;
                    case 3: if(pila.TopElem()!=0) System.out.println(pila.TopElem()); break;
                    case 4: pila.Print(); break;
                    case 0: break;
            }
         }while(s!=0);
        }
        else if(x==2){
            Coda coda = new Coda();
            do{
                System.out.println("Inserisci 1 per accodare un elemento");
                System.out.println("Inserisci 2 per togliere dalla coda l'elemento in testa alla coda");
                System.out.println("Inserisci 3 per visualizzare l'elemento in testa alla coda");
                System.out.println("Inserisci 4 per visualizzare l'intera coda");
                System.out.println("Inserisci 0 per uscire");
                if(scanner.hasNextInt()){
                    s=scanner.nextInt();
                }
                switch(s){
                    case 1: {   
                        System.out.println("Inserisci il valore");
                        if(scanner.hasNextInt()){
                            val=scanner.nextInt();
                            coda.EnQueue(val);
                        }
                        break;
                    }
                    case 2: coda.DeQueue(); break;
                    case 3: if(coda.HeadElem()!=0) System.out.println(coda.HeadElem()); break;
                    case 4: coda.Print(); break;
                    case 0: break;
            }
            }while(s!=0);
    } 
}
}