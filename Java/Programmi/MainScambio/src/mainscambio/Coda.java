package mainscambio;
public class Coda {
    private Intero head, tail;
    private int elementi;
    public Coda(){
        head=null;
        tail=null;
        head.setNext(tail);
        elementi=0;
    }
    public void InserisciInCoda(Intero p){
        if(head==null){
            head=p;
        }
        else if(tail==null){
            tail=p;
        }
        else{
            tail.setNext(p);
            tail=tail.getNext();
        }
        elementi++;
    }
    public void EliminaInTesta(){
        if(head==null){
            return;
        }
        else{
            head=head.getNext();
        }
    }
}
