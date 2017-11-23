package punto_retta;

import java.io.*;

public class Punto_Retta {

    public static void main(String[] args) throws IOException {
        Punto punto = new Punto();
        float d;
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci le cordinate (x;y) del punto");
        punto.setXY(Float.parseFloat(kb.readLine()), Float.parseFloat(kb.readLine()));
        System.out.println("Inserisci le cordinate (x;y) del secondo punto");
        d=punto.distanza(Float.parseFloat(kb.readLine()), Float.parseFloat(kb.readLine()));
        System.out.println("La distanza tra i due punti e' " + d);
    }  
}
