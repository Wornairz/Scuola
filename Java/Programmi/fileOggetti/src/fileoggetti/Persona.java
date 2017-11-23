package fileoggetti;
import java.io.*;

class Persona implements Serializable
{
  public String nome;
  public int eta;

  // costruttore
  public Persona(String nome, int eta)
  {
    this.nome = nome;
    this.eta = eta;
  }
}
