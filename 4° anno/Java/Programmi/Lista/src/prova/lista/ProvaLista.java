
package prova.lista;




public class ProvaLista {
    public static void main(String[] args) {
        
      Contatto i1 = new Contatto("Bianchi Giovanni",'M',"0586 854822"); 
      Contatto i2 = new Contatto("Rossi Marta",'F',"0586 844853"); 
      Contatto i3 = new Contatto("Neri Marco",'M',"0586 444722"); 
      Contatto i4 = new Contatto("Verdi Roberta",'F',"0586 974824"); 
      Lista f = new Lista();
      f.inserisciInTesta(i1) ; 
      f.inserisciInTesta(i2); 
      f.inserisciInCoda(i3) ;
      f.inserisciInPosizione(2, i4);
      System.out.println("Visita ricorsiva: "); 
      f.visitaLista(); 
      System.out.println("------------------");
      System.out.println(f.toString()); 
      System.out.println("------------------"); 
      f.eliminaInPosizione(2);
      System.out.println(f.toString()); 
      System.out.println("------------------"); 
      f.eliminaInCoda();

System.out.println(f.toString()); 
System.out.println("------------------"); 
f.eliminaInTesta();


System.out.println(f.toString()); 
        System.out.println("------------------"); 
        f.eliminaInPosizione(5);

System.out.println(f.toString());
System.out.println("------------------");
f.eliminaInPosizione(1);
System.out.println(f.toString()); 
System.out.println("------------------"); 
f.eliminaInPosizione(1);

   
    }
    
}
