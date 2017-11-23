package fileoggetti;
import java.io.*;

class ScriviDati
{
  public static void main(String argv[])
  {
    Persona p1, p2, p3;
    p1 = new Persona("Mario", 31);
    p2 = new Persona("Anna", 25);
    p3 = new Persona("Luigi", 57);

    try
    {
      FileOutputStream f = new FileOutputStream("elenco.dat");
      ObjectOutputStream fOUT = new ObjectOutputStream(f);

      fOUT.writeObject(p1);
      fOUT.writeObject(p2);
      fOUT.writeObject(p3);
      fOUT.flush();
      f.close();
    }
    catch(Exception e)
    {
      System.out.println("Eccezione: "+e.getMessage());
    }
  }
}
