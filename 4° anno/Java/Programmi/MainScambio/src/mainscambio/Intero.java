/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainscambio;

/**
 *
 * @author Alessandro
 */
public class Intero {

    private int info;
    private Intero next; 
    
    public Intero(int info) {
        this.info = info;
        next=null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Intero getNext() {
        return next;
    }

    public void setNext(Intero next) {
        this.next = next;
    }      
}
