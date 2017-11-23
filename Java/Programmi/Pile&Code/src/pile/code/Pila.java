/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pile.code;

/**
 *
 * @author Alessandro
 */
public class Pila {
    private int dim=0;
    private int[] Pila = new int [10];
    boolean error;
    private boolean Empty(){
        return (dim==0);
    }
    private boolean Full(){
        return (dim==10);
    }
    public void Push(int x){
        if(!Full()){
            Pila[dim]=x;
            dim++;
            System.out.println("Elemento aggiunto con successo!");
        }
    }
    public void Pop()
    {
        if(!Empty()){
            Pila[dim-1]=0;
            dim--;
            System.out.println("Elemento rimosso con successo!");
        }              
                
    }
    public int TopElem(){
        if(!Empty()){
            return Pila[dim-1];
        }
        return 0;
    }
    public void Print(){
        int i;
        for(i=dim-1;i>=0;i--){
            System.out.println(Pila[i]);
        }
    }
}
