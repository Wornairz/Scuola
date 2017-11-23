package libreria;
public class Libro {
    private int numero_pagine;
    private float prezzo;
    private String titolo;
    Libro(){
        numero_pagine=0;
        prezzo=0f;
        titolo = "";
    }
   public void setpagine(int numero_pagine){
       this.numero_pagine = numero_pagine;
   }
   public void setprezzo(float prezzo){
       this.prezzo = prezzo;
   }
   public void settitolo(String titolo){
       this.titolo = titolo;
   }
   public int getpagine(){
       return numero_pagine;
   }
   public float getprezzo(){
       return prezzo;
   }   
   public String gettitolo(){
       return titolo;
   }
}
