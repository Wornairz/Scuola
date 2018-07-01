/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paroletesto;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Alessandro
 */
public class ParoleTesto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader("ciao.txt"));
        Scanner sc = new Scanner(System.in);
        String temp, temp2,cont = "";
        char c;
        int conta=0;
        System.out.println("Inserisci parola da cercare");
        temp=sc.next();
        temp2=reader.readLine();
        temp2+=' ';
        while(temp2!=null)
        {
            for (int i = 0; i < temp2.length(); i++)
            {
               
               c=temp2.charAt(i);
               if(c==' ')
               {
                   
                    if(cont.equals(temp))
                    {
                        conta++;
                        
                    }
                  cont="";
                }
               else cont+=c;
            }
            temp2=reader.readLine();
            if(temp2!=null)
            temp2+=' ';
        }
        System.out.println("" + conta);
    }
    
}
