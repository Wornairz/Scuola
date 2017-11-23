/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.lista;

/**
 *
 * @author Tina
 */



public class Contatto { 
private String nome;  
private char sesso; 
private String telefono;
public Contatto(String nome, char sesso, String telefono) { 
this.nome = nome;
this.sesso = sesso;
this.telefono = telefono;
}

public Contatto (Contatto contatto) { 
    this.nome = contatto.getNome();
    this.sesso = contatto.getSesso(); 
    this.telefono = contatto.getTelefono();
}
public void setNome(String nome){ 
    this.nome=nome;
}
public String getNome() { 
    return nome;
}
public void setSesso(char sesso) { 
    this.sesso=sesso;
}
public char getSesso() { 
    return sesso;
}
public void setTelefono(String telefono){ 
    this.telefono=telefono;
}
public String getTelefono() { 
    return telefono;
}
@Override
public String toString(){
return nome + "," + sesso + "," + telefono;
} 

}