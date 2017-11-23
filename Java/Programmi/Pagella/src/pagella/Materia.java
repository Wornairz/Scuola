/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagella;
import java.util.Vector;
/**
 *
 * @author Alessandro
 */
public class Materia {

    private String nome;
    Vector v = new Vector (1,1);
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void addvoto(String tipo, int voto){
        Prova prova = new Prova();
        int i=0;
        prova.setVoto(voto);
        prova.setTipo(tipo);
        v.addElement(prova);
    }
    public void allvoti(){
        Prova prova = new Prova();
        int i;
        System.out.println("------ " +nome+" ------");
        for(i=0;i<v.size();i++){
            prova = (Prova) v.elementAt(i);
            System.out.println(prova.getTipo()+ ": " + prova.getVoto());
        }
    }
    public float media(){
        Prova prova = new Prova();
        int i;
        float media = 0;
        for(i=0;i<v.size();i++){
            prova=(Prova) v.elementAt(i);
            media+=prova.getVoto();
        }
        return (media/v.size());
    }
}
