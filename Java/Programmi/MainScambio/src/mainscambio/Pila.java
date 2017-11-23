/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainscambio;

/**
 *
 * @author Alessandro
 */
public class Pila {
    private Intero head, tail;
    private int elementi;
    
    public Pila(){
        head=null;
        tail=null;
        elementi=0;
    }
    
    public void InserisciInCoda(int valore){
        Intero p = new Intero(valore);
        if(head==null){
            head=p;
        }
        else if(tail==null){
            tail=p;
            head.setNext(tail);
        }
        else{
            tail.setNext(p);
            tail=tail.getNext();
        }
        elementi++;
    }
   public void EliminaInCoda() 
    {
        Intero ps=head, pp=head; // variabili per scorrere la lista
        if (pp==null) // lista vuota? 
            return;
        while(ps.getNext() != null) {
            pp=ps;  
            ps = ps.getNext(); 
        } 
        if (pp==head) // solo un nodo nella lista? 
            head=null;
        else 
        {
         pp.setNext(null);
         elementi--;
    }
}
    public void visualizza(){
        Intero temp = head;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while(temp!=null){
            System.out.println(temp.getInfo());
            temp=temp.getNext();
        }
    }
}
