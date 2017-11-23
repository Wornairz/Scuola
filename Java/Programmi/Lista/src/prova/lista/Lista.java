
package prova.lista;


public class Lista 
{
private Nodo head; // riferimento al nodo iniziale della lista
private int elementi; // numero di elementi (nodi) della lista

public Lista() { 
    head = null;
    elementi = 0;
}

public void visitaLista() { 
    Nodo p = head;

while(p != null) { 
    esamina(p.getInfo());
   p = p.getNext();
}
}
public void visitaListaRic() { 
    visitaRicorsivaLista(head);
}

private void visitaRicorsivaLista(Nodo p) {
if (p == null) return;
esamina(p.getInfo());
visitaRicorsivaLista(p.getNext()); 
}

private void esamina(Object info){
  System.out.println(info);
  System.out.println(info.toString());
    System.out.println();
  
}


public void inserisciInTesta(Object o) {
Nodo pn = new Nodo(o); // creazione nuovo nodo riferito da pn

pn.setNext(head); 
head = pn; 
elementi++;
}
public void inserisciInCoda(Object o) {
   
Nodo p = head; // riferimento per scorrere la lista 
Nodo pn = new Nodo(o); // creazione nuovo nodo
if (p==null) // lista vuota? 
    inserisciInTesta(o);
else {
while (p.getNext()!=null) // scorrimento lista
   p = p.getNext();
pn.setNext(null); // il nuovo nodo e’ l’ultimo della lista

p.setNext(pn); 
elementi++;
}
}
// pn diviene il nuovo ultimo nodo // aggiornamento del numero di nodi
public void inserisciInPosizione(int posizione, Object o) { 
    
    Nodo p = head;
 // riferimento per scorrere la lista Nodo 
    Nodo pn = new Nodo(o); // creazione nuovo nodo
int i = 1; // indice di posizione
if ((posizione<=1) || (head==null)) 
    inserisciInTesta(o);
else
  if (posizione>elementi)
    inserisciInCoda(o); 
 else {
    while(i<posizione-1){ // scorrimento lista fino alla posizione 
     p=p.getNext();
    i++;}
    pn.setNext(p.getNext()); // pn riferisce il nodo successivo
    p.setNext(pn); 
    elementi++;
 }
}
//il nuovo nodo viene collegato // aggiornamento del numero di nodi
public void eliminaInTesta() { 
    if (head==null) // lista vuota?
        return;
    head = head.getNext(); // head riferisce il secondo nodo della lista
    elementi--; // aggiorna del numero dei nodi
}
public void eliminaInCoda() 
{
 Nodo ps=head, pp=head; // variabili per scorrere la lista
 if (pp==null) // lista vuota? 
     return;
 while(ps.getNext() != null) {
     pp=ps;  
     ps = ps.getNext(); 
 } 
 if (pp==head) // solo un nodo nella lista? 
     eliminaInTesta();
 else 
 {
  pp.setNext(null);
  elementi--;
}
}

public void eliminaInPosizione(int n) {
Nodo pp, ps;
if ((n==1)) 
    eliminaInTesta();
else
    if (n==elementi)
       eliminaInCoda(); 
    else {
       pp = getNextPosizione(n-1);
       if (pp==null) // riferimento valido?
           return;
       ps = pp.getNext();
       pp.setNext(ps.getNext()); 
       elementi--;
    }
}

private Nodo getNextPosizione(int n){
Nodo p = head;
int i = 1; // variabile usata come indice di posizione
if ((n>elementi) || (n<1)) // posizione corretta? 
    return null;
else // scorrimento lista fino alla posizione n-esima
     while ((p.getNext()!=null) && (i<n)) { 
         p = p.getNext();
         i++;
     } 
return p;
}



}
