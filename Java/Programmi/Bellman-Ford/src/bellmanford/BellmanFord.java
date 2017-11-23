package bellmanford;
/**
 *
 * @author Alessandro Catalano
 */
public class BellmanFord {
    private static int costo=0;
    public static void main(String[] args) {
        //Esempio del libro pag. 79
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");
        Nodo F = new Nodo("F");
        A.addCollegamento(B, 1);
        A.addCollegamento(F, 3);
        B.addCollegamento(F, 1);
        B.addCollegamento(E, 5);
        B.addCollegamento(C, 3);
        C.addCollegamento(D, 2);
        E.addCollegamento(D, 1);
        F.addCollegamento(E, 2);
        F.addCollegamento(D, 6);
        costo=mappa(A, E); //ritorna il costo minimo da un nodo ad un altro
        System.out.println(costo);
    }
    public static int mappa(Nodo sorg, Nodo dest){
        int size=sorg.getCollegamenti();
        Collegamento temp[] = new Collegamento[size];
        int v[] = new int[size];
        for(int i=0;i<size;i++){
            v[i]=0;
            temp[i]=sorg.visitaNodo();
            if(temp[i].getNodo().equals(dest)){
                v[i]+=temp[i].getPeso();
            }
            else{  
                v[i]+=mappa(temp[i].getNodo(), dest) + temp[i].getPeso();
            }
        }
        if(size==0) return 100000;
        else if(size==1) return v[0];
        else {
            int x=v[0];
            for(int i=1;i<size;i++){
                if(x>v[i]) x=v[i];
            }
            return x;
        }
    }
    
}
