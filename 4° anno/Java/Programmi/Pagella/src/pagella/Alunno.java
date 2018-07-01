/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagella;

/**
 *
 * @author Alessandro
 */
public class Alunno {

    
    private String nome;
    Materia[] materia = new Materia[10];
    private int i;
    
    Alunno(){
        for(i=0;i<10;i++){
            materia[i] = new Materia();
        }
        materia[0].setNome("matematica");
        materia[1].setNome("italiano");
        materia[2].setNome("storia");
        materia[3].setNome("informatica");
        materia[4].setNome("sistemi");
        materia[5].setNome("tps");
        materia[6].setNome("religione");
        materia[7].setNome("telecomunicazioni");
        materia[8].setNome("educazione fisica");
        materia[9].setNome("inglese");
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public float media(int i){
        return materia[i].media();
    }
}
