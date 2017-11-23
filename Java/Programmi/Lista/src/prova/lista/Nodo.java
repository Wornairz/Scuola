
package prova.lista;

public class Nodo 
{ private Object info; 
  private Nodo next;
  
  public Nodo () { 
    info = null;
    next = null;
} 

public Nodo (Object oggetto) { 
    info = oggetto;
    next = null;
} 

public void setInfo(Object oggetto) { 
    info = oggetto;
}

public Object getInfo() { 
return info;
}
public void setNext(Nodo next) { 
    this.next = next;
}

public Nodo getNext() { 
    return next;
}

}
