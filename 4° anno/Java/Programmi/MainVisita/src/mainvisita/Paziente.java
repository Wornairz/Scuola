/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainvisita;

/**
 *
 * @author Alessandro
 */
public class Paziente {

    private String nome, cognome;
    private Paziente next;
    
    public Paziente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        next=null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Paziente getNext() {
        return next;
    }

    public void setNext(Paziente next) {
        this.next = next;
    }
}
