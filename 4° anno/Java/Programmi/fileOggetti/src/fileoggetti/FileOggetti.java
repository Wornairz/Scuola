/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoggetti;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Tina
 */
public class FileOggetti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
    
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
  

    
// leggi
    
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
    

