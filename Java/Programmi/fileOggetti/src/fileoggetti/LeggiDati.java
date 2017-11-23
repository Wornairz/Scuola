package fileoggetti;
import java.io.*;


class LeggiDati
{
  public static void main(String argv[]) throws ClassNotFoundException
  {
    Persona p;
    try
    {
           FileInputStream f = new FileInputStream("elenco.dat"); 
            ObjectInputStream fIN = new ObjectInputStream(f);
            /* Ciclo infinito per leggere i dati */
            while (true)
            {
                try
                {
                    p = (Persona) fIN.readObject();
                    System.out.println("\nNome: "+p.nome);
                    System.out.println("Eta': "+p.eta);
                }
                catch(EOFException e)
                {
                    /* Interrompe il ciclo */
                    break;
                } 
            } 
    }
    catch(IOException  e)
    {
      System.out.println("Eccezione: "+e.getMessage());
    }
  }
}
