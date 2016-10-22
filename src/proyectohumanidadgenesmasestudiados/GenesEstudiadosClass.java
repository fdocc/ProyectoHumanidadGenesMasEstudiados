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
public class GenesEstudiadosClass {
   private String JERARQUIA, GENE, HEBRA, ENTREZ;
    private int DIMENSIONES;
    
    public  GenesEstudiadosClass(String JERARQUIA, String GENE, int DIMENSIONES, String HEBRA, String ENTREZ)
    {
        this.JERARQUIA = JERARQUIA;
        this.GENE = GENE;
        this.DIMENSIONES = DIMENSIONES;
        this.HEBRA = HEBRA;
        this.ENTREZ = ENTREZ;        
    }

    /**
     * @return the JERARQUÍA
     */
    public String toString() {
        String r = "";
        r = " \nJerarquía   : " + JERARQUIA +
            " \nGene   : " + GENE +
            " \nDimensiones   : " + DIMENSIONES +                
            " \nHebra   : " + HEBRA +
            " \nEntrez   : " + ENTREZ;        
        return r;
    }
    
    public String getJERARQUIA() {
        return JERARQUIA;
    }

    public void setJERARQUIA(String JERARQUIA) {
        this.JERARQUIA = JERARQUIA;
    }

    public String getGENE() {
        return GENE;
    }

    public void setGENE(String GENE) {
        this.GENE = GENE;
    }

    public int getDIMENSIONES() {
        return DIMENSIONES;
    }

    public void setDIMENSIONES(int DIMENSIONES) {
        this.DIMENSIONES = DIMENSIONES;
    } 
    
        public String getHEBRA() {
        return HEBRA;
    }

    public void setHEBRA(String HEBRA) {
        this.HEBRA = HEBRA;
    }
    
        public String getENTREZ() {
        return ENTREZ;
    }

    public void setENTREZ(String ENTREZ) {
        this.ENTREZ = ENTREZ;
    }     
}
