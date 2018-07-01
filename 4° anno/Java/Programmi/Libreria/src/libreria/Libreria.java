package libreria;
import java.io.*;
public class Libreria {

   
public static void main(String[] args) throws IOException {
    BufferedReader tastiera=new BufferedReader(new InputStreamReader(System.in));
    String input;
   int S,dim=0,i;
   Libro libro[]=new Libro[10];
   do{
   System.out.println("1 Inserimento\n2 Visualizza\n3 Esci");
   input=tastiera.readLine();
   S=Integer.parseInt(input);
   switch(S){
       case 1:{
           libro[dim]=new Libro();
           System.out.println("Inserisci il titolo, numero pagine e prezzo");
           input=tastiera.readLine();
           libro[dim].settitolo(input);
           input=tastiera.readLine();
           libro[dim].setpagine(Integer.parseInt(input));
           input=tastiera.readLine();
           libro[dim].setprezzo(Float.parseFloat(input));
           dim++;
           break;
       }
       case 2:{
           if(dim>0){
               for(i=0;i<dim;i++){
                   System.out.println("Il titolo e': " + libro[i].gettitolo());
                   System.out.println("Il numero delle pagine e':" + libro[i].getpagine());
                   System.out.println("Il prezzo e': " + libro[i].getprezzo());
               }
           }
           else{
               System.out.println("Inserisci prima dei libri");
           }
           break;
       }
       case 3: break;
       default: System.out.println("Errore"); break;
   }
    }while(dim<10 && S!=3);
   }
    
}
