/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com111020_02.pruebaconjuntos;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import mx.itam.com111020_02.colecciones.impl.arreglos.ConjuntoArreglo;

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class PruebaConjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Buscador de dominios SPAM");
        System.out.println("Ingresa el nombre del dominio");
                        
        Set<String> conjuntoITAM, conjuntoJAVA;
        conjuntoITAM = cargaDominios("\"C:\\Users\\alan-\\Downloads\\tlds-alpha-by-domain.txt\"");
        conjuntoJAVA = new HashSet<>();
        conjuntoJAVA.addAll(conjuntoITAM);
        
        Scanner r = new Scanner(System.in);
        String nombreDominio;
        
        nombreDominio = r.next();
        
        System.out.println("Buscando el dominio: " + nombreDominio);
        
        long inicio,fin;
        
        System.out.println("    En ITAM...");
        
        inicio = System.nanoTime();
        
        if(conjuntoITAM.contains(nombreDominio))
            System.out.println("El dominio: "+nombreDominio+" no es SPAM");
        else
            System.out.println("POSIBLE SPAM!");
        
        fin = System.nanoTime();
        
        System.out.printf("Tiempo: %g seg",(fin-inicio)*1.0000E-9);
        
        
        System.out.println("\n    En JAVA...");
        
        inicio = System.nanoTime();
        
        if(conjuntoITAM.contains(nombreDominio))
            System.out.println("El dominio: "+nombreDominio+" no es SPAM");
        else
            System.out.println("POSIBLE SPAM!");
        
        fin = System.nanoTime();
        
        System.out.printf("Tiempo: %g seg",(fin-inicio)*1.0000E-9);
        
    }
    
    private static ConjuntoArreglo<String> cargaDominios(String nombreArchivo){
        ConjuntoArreglo<String> dominios = new ConjuntoArreglo();        
        
        try{
            File arch = new File(nombreArchivo);
            Scanner read = new Scanner(arch);
            
            read.next();
            
            while(read.hasNext()){
                dominios.add(read.next());
            }
            
            
        }catch (Exception e)        {
            
        }
        
        return dominios;
    }
    
}
