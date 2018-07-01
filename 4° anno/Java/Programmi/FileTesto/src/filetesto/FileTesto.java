/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetesto;
import java.io.*; 
/**
 *
 * @author Tina
 */
public class FileTesto {


public static void main(String args[]) throws IOException { 
TextFile out = new TextFile("file.txt",'R');
 try { 
    out.toFile("Riga 1");      
    out.toFile("Riga 2"); 
    out.toFile("Riga 3"); 
}catch (FileException exception) { 
  System.out.println(exception.getMatter()); } 
out.closeFile(); 
TextFile in = new TextFile("file.txt",'R'); 
String line;
try { 
while (true) {
line = in.fromFile(); 
System.out.println(line); 
} } catch (FileException exception) { System.out.println(exception.getMatter()); 
} 
out.closeFile(); } 
} 



