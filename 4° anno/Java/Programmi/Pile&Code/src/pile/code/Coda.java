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
public class Coda {
    private int[] Coda = new int[10];
    private int head = 0, tail = 0;
    
    private boolean Full(){
        return (head==tail) && Coda[head]!=0;//tail-1?
    }
    private boolean Empty(){
        return head==tail && Coda[head]==0;
    }
    public void EnQueue(int val){
        if(!Full()){
            Coda[tail]=val;
            tail++;
            if(tail>9){
                tail=0;
            }
            System.out.println("Elemento inserito con successo");
        }
    }
    public void DeQueue(){
        if(!Empty()){
            Coda[head]=0;
            head++;
            if(head>9){
                head=0;
            }
            System.out.println("Elemento rimosso con successo");
        }
    }
    public int HeadElem(){
        return Coda[head];
    }
    public void Print(){
        if(!Empty()){
        int i;
        if(head<tail){
            System.out.print("head" + head + "--> |");
            for(i=head;i<tail;i++){
                System.out.print(Coda[i]+"|");
            }
            System.out.println("<-- tail" + tail);
        }
        else if(head>=tail){
            System.out.print("head" + head + " --> |");
            for(i=head;i<9;i++){
                System.out.print(Coda[i]+"|");
            }
            for(i=0;i<tail;i++){
                System.out.print(Coda[i]+"|");
            }
            System.out.println("<-- tail" + tail);
        }
        }
    }
}
