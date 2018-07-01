/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrariocesarealfabeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alessandro
 */
public class CifrarioCesareAlfabeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci la parola o frase da cifrare");
        String daCifrare = tastiera.readLine();
        System.out.println("Inserisci la chiave di cifratura");
        int chiave = Integer.parseInt(tastiera.readLine());
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
        char[] cifrata = new char[daCifrare.length()];
        for(int i=0;i<daCifrare.length();i++){
            if(daCifrare.codePointAt(i)-97+chiave>=alfabeto.length()){
                cifrata[i] = alfabeto.charAt(daCifrare.codePointAt(i)-97+chiave-alfabeto.length());
            }
            else{
                cifrata[i] = alfabeto.charAt(daCifrare.codePointAt(i)-97+chiave);
            }
        }
        System.out.print("La parola o frase cifrata e': "); System.out.println(cifrata); 
        
        
    }
    
}
