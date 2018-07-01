package bellmanford;
/**
 *
 * @author Alessandro Catalano
 */
public class Collegamento {
    private Nodo next;
    private int peso;
    Collegamento(){
        next = null;
        peso = 0;
    }
    Collegamento(Nodo next, int peso){
        this.next=next;
        this.peso=peso;
    }
    public Nodo getNodo(){
        return next;
    }
    public int getPeso(){
        return peso;
    }
}
