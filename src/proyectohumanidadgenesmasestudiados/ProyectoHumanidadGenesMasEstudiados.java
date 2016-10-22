/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohumanidadgenesmasestudiados;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import com.csvreader.CsvWriter;

/**
 *
 * @author Fernando Castro-Chavez: fdocc@yahoo.com
 */
public class ProyectoHumanidadGenesMasEstudiados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> datos = new ArrayList<>();
        datos.add("HebraNegativa:1:TP53:25772:-:https://www.ncbi.nlm.nih.gov/gene/7157");
        datos.add("HebraPositiva:2:TNF:2770:+:https://www.ncbi.nlm.nih.gov/gene/7124");
        datos.add("HebraNegativa:3:UBC:5765:-:https://www.ncbi.nlm.nih.gov/gene/7316");
        datos.add("HebraPositiva:4:ApoE:3647:+:https://www.ncbi.nlm.nih.gov/gene/348");
        datos.add("HebraPositiva:5:EGFR:237600:+:https://www.ncbi.nlm.nih.gov/gene/1956");
        datos.add("HebraPositiva:6:VEGFA:16304:+:https://www.ncbi.nlm.nih.gov/gene/7422");
        datos.add("HebraPositiva:7:IL6:6561:+:https://www.ncbi.nlm.nih.gov/gene/3569");
        datos.add("HebraNegativa:8:TGFB1:52347:-:https://www.ncbi.nlm.nih.gov/gene/7040");
        datos.add("HebraNegativa:9:MTHFR:21198:-:https://www.ncbi.nlm.nih.gov/gene/4524");
        datos.add("HebraPositiva:10:ESR1:472929:+:https://www.ncbi.nlm.nih.gov/gene/2099");
        datos.add("HebraNegativa:11:HLA-DRB1:36859:-:https://www.ncbi.nlm.nih.gov/gene/3123");
        datos.add("HebraPositiva:12:NFKB1:115974:+:https://www.ncbi.nlm.nih.gov/gene/4790");   
        datos.add("HebraNegativa:13:IL10:7006:-:https://www.ncbi.nlm.nih.gov/gene/3586");
        datos.add("HebraPositiva:14:ACE:21320:+:https://www.ncbi.nlm.nih.gov/gene/1636");
        datos.add("HebraNegativa:15:BRCA1:125951:-:https://www.ncbi.nlm.nih.gov/gene/672");         
        
        // Lista de objetos 

        List<HebraPositiva> hebraPositivaGenes = new ArrayList<>();
        List<HebraNegativa> hebraNegativaGenes = new ArrayList<>();
        
        // Se itera sobre los datos

        for (String dato : datos) {
            String[] componentes = dato.split(":");
            String tipo = componentes[0];                     

            // Se identifica si es localidad o camioneta
            if (tipo.equals("HebraNegativa")) {
                String jerarquia = componentes[1];
                String gene = componentes[2];
                int dimensiones = Integer.parseInt(componentes[3]);
                String hebra = componentes[4];
                String entrez = componentes[5];                
                HebraNegativa l = new HebraNegativa(jerarquia, gene, dimensiones, hebra, entrez);
                hebraNegativaGenes.add(l);
            } else {
                String jerarquia = componentes[1];
                String gene = componentes[2];
                int dimensiones = Integer.parseInt(componentes[3]);
                String hebra = componentes[4]; 
                String entrez = componentes[5];                
                HebraPositiva c = new HebraPositiva(jerarquia, gene, dimensiones, hebra, entrez);
                hebraPositivaGenes.add(c);
            }
        }

        // Se muestran los resultados
        
        for (HebraNegativa l : hebraNegativaGenes) {
            //System.out.println(l);
        }

        for (HebraPositiva c : hebraPositivaGenes) {
            //System.out.println(c);
        }  
  
		String outputFile = "HumanidadGenesMasEstudiados.csv";
		
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("JERARQUIA");
				csvOutput.write("GENE");
				csvOutput.write("DIMENSIONES");
                                csvOutput.write("HEBRA");   
                                csvOutput.write("ENTREZ");                                 
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line

			// write out a few records
			csvOutput.write("1");
			csvOutput.write("TP53");
                        csvOutput.write("25772");
                        csvOutput.write("-");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/7157");                        
			csvOutput.endRecord();
			
			csvOutput.write("2");
			csvOutput.write("TNF");
                        csvOutput.write("2770");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/7124");                        
			csvOutput.endRecord();
                        
			csvOutput.write("3");
			csvOutput.write("UBC");
                        csvOutput.write("5765");
                        csvOutput.write("-");                        
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/7316");
			csvOutput.endRecord();
			
			csvOutput.write("4");
			csvOutput.write("ApoE");
                        csvOutput.write("3647");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/348");                        
			csvOutput.endRecord();

			csvOutput.write("5");
			csvOutput.write("EGFR");
                        csvOutput.write("237600");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/1956");                        
			csvOutput.endRecord();
			
			csvOutput.write("6");
			csvOutput.write("VEGFA");
                        csvOutput.write("16304");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/7422");                        
			csvOutput.endRecord();
                        
			csvOutput.write("7");
			csvOutput.write("IL6");
                        csvOutput.write("6561");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/3569");                        
			csvOutput.endRecord();
			
			csvOutput.write("8");
			csvOutput.write("TGFB1");
                        csvOutput.write("52347");
                        csvOutput.write("-");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/7040");                        
			csvOutput.endRecord();
                        
			csvOutput.write("9");
			csvOutput.write("MTHFR");
                        csvOutput.write("21198");
                        csvOutput.write("-");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/4524");                        
			csvOutput.endRecord();
                        
			csvOutput.write("10");
			csvOutput.write("ESR1");
                        csvOutput.write("472929");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/2099");                        
			csvOutput.endRecord();
			
			csvOutput.write("11");
			csvOutput.write("HLA-DRB1");
                        csvOutput.write("36859");
                        csvOutput.write("-");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/3123");                        
			csvOutput.endRecord();

			csvOutput.write("12");
			csvOutput.write("NFKB1");
                        csvOutput.write("115974");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/4790");                        
			csvOutput.endRecord();
			
			csvOutput.write("13");
			csvOutput.write("IL10");
                        csvOutput.write("7006");
                        csvOutput.write("-");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/3586");                        
			csvOutput.endRecord();
                        
			csvOutput.write("14");
			csvOutput.write("ACE");
                        csvOutput.write("21320");
                        csvOutput.write("+");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/1636");                        
			csvOutput.endRecord();
			
			csvOutput.write("15");
			csvOutput.write("BRCA1");
                        csvOutput.write("125951");
                        csvOutput.write("-");
                        csvOutput.write("https://www.ncbi.nlm.nih.gov/gene/672");                        
			csvOutput.endRecord();                        

			csvOutput.close();                        
                } catch (IOException e) {
			e.printStackTrace();
                }    
                
             try {
            String base = "";
            // Para leer y archivar los datos
            File archivo;

            archivo = new File(base+"HumanidadGenesMasEstudiados.csv");            
            FileReader fr = new FileReader(archivo);
            
             BufferedReader br = new BufferedReader(fr);
            
            List<String> genesEstudiados = new ArrayList<>();
            
            // Etapa de procesamiento           
            String linealeida = "";
            int c = 0;
            while((linealeida = br.readLine()) != null) {
                if(c > 0) //Con esto se salta el encabezado
                {
                    genesEstudiados.add(linealeida);
                }
                c++;
            }
            br.close();            

            Set<String> jerarquíasGenes = new HashSet<>();
            List<GenesEstudiadosClass> genes = new ArrayList<>();
            
            for (String jerarquías : genesEstudiados)             
            {
                String[] dato = jerarquías.split(",");
                String JERARQUIA = dato[0];
                String GENE = dato[1];
                int DIMENSIONES = Integer.parseInt(dato[2]);                              
                String HEBRA = dato[3];
                String ENTREZ = dato[4];                
                
                GenesEstudiadosClass Gen = new GenesEstudiadosClass(JERARQUIA, GENE, DIMENSIONES, HEBRA, ENTREZ);
                jerarquíasGenes.add(JERARQUIA);
//                jerarquíasGenes.add(GENE);
//                jerarquíasGenes.add(HEBRA);
                genes.add(Gen);
            }
            
            for (String JERARQUIA : jerarquíasGenes) 
            {
                File myDir = new File(base+JERARQUIA);     // Crea un objeto
                myDir.mkdir();
            }   
            
            for (GenesEstudiadosClass Gen : genes) 
            {
                File fout;
                fout = new File(base+Gen.getJERARQUIA()+"\\"+Gen.getGENE()+".txt");
                FileWriter fw = new FileWriter(fout);
                PrintWriter pw = new PrintWriter(fw);
                
                pw.println(Gen);
                System.out.println(Gen);
                pw.close();
            }   
            
double sum1 = 25772.0 + 5765 + 52347 + 21198 + 36859 + 7006 + 125951;

double sum2 = 2770.0 + 3647 + 237600 + 16304 + 6561 + 472929 + 115974 + 21320;

double diff = sum2 - sum1; 

double div = sum2 / sum1;

System.out.println("");
System.out.println("La suma de la longitud de los genes de hebra negativa o minus (-) es: " + sum1);
System.out.println("La suma de la longitud de los genes de hebra positiva o plus (+) es: " + sum2);
System.out.println("La diferencia de longitud a favor de los genes plus comparada con los genes minus es: " + diff);
System.out.println("Se concluye que hay: ¡" + div + " veces más longitud en los genes plus que en los genes minus!" );
 System.out.println(" " );           
    }catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoHumanidadGenesMasEstudiados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProyectoHumanidadGenesMasEstudiados.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
}
}

    

