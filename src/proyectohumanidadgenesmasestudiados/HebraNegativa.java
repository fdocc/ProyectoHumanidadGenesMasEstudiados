/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohumanidadgenesmasestudiados;

/**
 *
 * @author Fer
 */
public class HebraNegativa {
    private String jerarquia;
    private String gene;
    private int dimensiones;
    private String hebra; 
    private String entrez;    
    
    protected HebraNegativa(String jerarquia, String gene, int dimensiones, String hebra, String entrez) {
        this.jerarquia = jerarquia;
        this.gene = gene;
        this.dimensiones = dimensiones;
        this.hebra = hebra;  
        this.entrez = entrez;        
    }
    
    public String toString() {
        String r = "";
        r = "\nJerarquia: " + jerarquia +
            "\nGene: " + gene +
            "\nTamaño  : " + dimensiones +
            "\nHebra  : " + hebra +  
            "\nEntrez  : " + entrez;        
        return r;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    public int getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int dimensiones) {
        this.dimensiones = dimensiones;     
    }

    public String getHebra() {
        return hebra;
    }

    public void setHebra(String hebra) {
        this.hebra = hebra;    
    }  
    
    public String getEntrez() {
        return entrez;
    }

    public void setEntrez(String entrez) {
        this.entrez = entrez;    
    }     
}