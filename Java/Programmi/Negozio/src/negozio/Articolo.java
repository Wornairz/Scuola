/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negozio;

/**
 *
 * @author Alessandro
 */
public class Articolo {
    
    private String categoria, codice, descrizione;
    private int giacenza, scortaminima;
    private float p_unit;
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    public int getScortaminima() {
        return scortaminima;
    }

    public void setScortaminima(int scortaminima) {
        this.scortaminima = scortaminima;
    }

    public float getP_unit() {
        return p_unit;
    }

    public void setP_unit(float p_unit) {
        this.p_unit = p_unit;
    }
}
