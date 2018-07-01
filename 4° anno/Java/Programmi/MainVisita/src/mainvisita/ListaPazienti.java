/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainvisita;

/**
 *
 * @author Alessandro
 */
public class ListaPazienti {
    
    private Paziente head; 
    private int elementi;
    
    ListaPazienti(){
        head=null;
        elementi=0;
    }
    public void InserisciInCoda(Paziente p){
        if(head==null){
            head=p;
        }
        else{
            Paziente temp=head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(p);
        }
        elementi++;
    }
    public boolean EliminaInTesta(){
        if(head==null) return false;
        else {
            head=head.getNext();
            elementi--;
            return true;
        }
    }
    public Paziente PazienteInPosizione(int pos){
        if(pos<=1) return head;
        else if(pos<=elementi){
            Paziente temp = head;
            for(int i=1;i<pos;i++){
                temp=temp.getNext();
            }
            return temp;
        }
        else return null;
    }
    public int getElementi(){
        return elementi;
    }
}