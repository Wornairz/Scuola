package bellmanford;
import java.util.Vector;
/**
 *
 * @author Alessandro Catalano
 */
public class Nodo {

    public String getName() {
        return name;
    }
    private Vector<Collegamento> collegamenti;
    private String name;
    public Nodo(String name) {
        collegamenti = new Vector<Collegamento>();
        this.name=name;
    }

    public void addCollegamento(Nodo next, int peso){
        collegamenti.add(new Collegamento(next,peso));
    }
    public Collegamento visitaNodo(){
        return collegamenti.remove(0);
    }
    public int getCollegamenti(){
        return collegamenti.size();
    }
}
