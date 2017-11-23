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

public class TextFile {
private char mode; // R=read, W=write 
private BufferedReader reader; 
private BufferedWriter writer; 
public TextFile(String filename, char mode) throws IOException { 
if (mode == 'W' || mode == 'w') {
     this.mode = 'W';
  writer = new BufferedWriter(new FileWriter(filename)); 
} else { 
   this.mode = 'R'; 
  reader = new BufferedReader(new FileReader(filename)); } 
} 
public void toFile(String line) throws FileException, IOException 
{
    if (this.mode == 'R') 
    throw new FileException("Read-only "+ "file!");
   writer.write(line); 
   writer.newLine(); 
} 
public String fromFile() throws FileException, IOException { 
    String tmp; 
      if (this.mode == 'W') throw new FileException("Write-only "+ "file!"); 
            tmp=reader.readLine();
if (tmp == null) 
  throw new FileException("End of file!");
 return tmp; 
} 
public void closeFile() throws IOException { 
if (this.mode == 'W') 
   writer.close(); 
else // this.mode == 'R' 
  reader.close(); 
}
}