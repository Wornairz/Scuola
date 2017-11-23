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
public class ListaScambia {
    
    private Intero head; 
    private int elementi;
    
    ListaScambia(){
        head=null;
        elementi=0;
}
public void InserisciInCoda(int valore){
    Intero p = new Intero(valore);
    if(head==null){
        head=p;
    }
    else{
        Intero temp=head;
        while(temp.getNext()!=null){
            temp=temp.getNext();
        }
        temp.setNext(p);
    }
    elementi++;
}
    public void visualizza(){
        Intero temp = head;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while(temp!=null){
            System.out.println(temp.getInfo());
            temp=temp.getNext();
        }
    }
    public void ordina(){
        /*Intero temp=head;
        int v[] = new int[elementi];
        int i;
        for(i=0;i<elementi;i++){
            v[i]=temp.getInfo();
            temp=temp.getNext();
        }
        for(i=0;i<elementi-1;i++){
            for(int j=i+1;j<elementi;j++){
                if(v[i]>v[j]){
                    int tmp=v[i];
                    v[i]=v[j];
                    v[j]=tmp;
                }
            }
        }
        temp=head;
        for(i=0;i<elementi;i++){
            temp.setInfo(v[i]);
            temp=temp.getNext();
        }*/
        Intero temp=head;
        int var=0;
        for(int i=0;i<elementi;i++){
            while(temp.getNext()!=null){
                if(temp.getInfo()>temp.getNext().getInfo()){
                    var=temp.getNext().getInfo();
                    temp.getNext().setInfo(temp.getInfo());
                    temp.setInfo(var);
                }
                temp=temp.getNext();
            }
        }
    }
    public int getElementi(){
        return elementi;
    }
}
