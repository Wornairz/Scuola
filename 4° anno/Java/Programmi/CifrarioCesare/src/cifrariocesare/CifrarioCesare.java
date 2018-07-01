/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrariocesare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author Alessandro
 */
public class CifrarioCesare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci la parola o frase da cifrare");
        String daCifrare = tastiera.readLine();
        System.out.println("Inserisci la chiave di cifratura");
        int chiave = Integer.parseInt(tastiera.readLine());
        final int minchar = 33;
        final int maxchar = 127;
        //System.out.println(Arrays.toString(daCifrare.getBytes()));
        //System.out.println(Arrays.toString(Character.toChars(daCifrare.codePointAt(0))));
        char[] cifrata = new char[daCifrare.length()];
        for(int i=0;i<daCifrare.length();i++){
            if(daCifrare.codePointAt(i)+chiave>=maxchar){
                cifrata[i]=(char) (daCifrare.codePointAt(i)+chiave-maxchar+minchar);
            }
            else cifrata[i]=(char) (daCifrare.codePointAt(i)+chiave);
        }
        System.out.print("La parola o frase cifrata e': "); System.out.println(cifrata); 
        String leggiCifrata = "";
        for(int i=0;i<cifrata.length;i++){
            if(cifrata[i]-chiave<minchar){
                leggiCifrata += (char) (cifrata[i]-chiave+maxchar-minchar);
            }
            else leggiCifrata += (char) (cifrata[i]-chiave);
        }
        System.out.println("La stringa originale e' " + leggiCifrata);
    }
    
}
