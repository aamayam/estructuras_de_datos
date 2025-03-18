/*
 * COPYRIGHT 2020 - A.AMAYA
 */
package mx.itam.com111020_02.ed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Clase que contiene el método <code>main</code> que muestra
 * el menú de ejecución de pruebas
 * @author Alan Amaya (191165) <href"mailto: aamayam@itam.mx"> 
 */
public class EjecutorPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("BIENVENIDO!");        
        System.out.println();
        
        int laopcion;
        int opcionfinalizar = 5;
        
        do{
            System.out.println("Menu Principal:");

            System.out.println("1.- Uso de tipos parametrizados con comodin "
                    + "(Colecciones)");
            System.out.println("2.- Recursión");
            System.out.println("3.- multiplicacion recursiva");
            System.out.println("4.- Momparaciones");
            System.out.println("5.- Fianlizar");

            System.out.println();
            System.out.print("Opción: ");
            System.out.flush();
            
            BufferedReader lector;
            String entrada = "";

            lector = new BufferedReader(new InputStreamReader(System.in));

           try {
               entrada = lector.readLine();
               laopcion = Integer.parseInt(entrada);
           } catch (IOException ex) {
               laopcion = -1;
               Logger.getLogger(EjecutorPruebas.class.getName()).log(Level.SEVERE, null, ex);
               System.out.printf("Error al intentar leer opción de la entrada estandar");
               System.out.println();
           } catch (NumberFormatException numfex) {
               laopcion = -2;
               Logger.getLogger(EjecutorPruebas.class.getName()).log(Level.SEVERE, null, numfex);
               System.out.printf("Opción %s inválida, por favor vuelva a intentar", entrada);
               System.out.println();
           }

           if (laopcion > 0) {
                switch (laopcion) {
                    case 1:
                        mostrarTiposParametrizados_Com();
                        break;
                    case 2:
//                        resolverFactorial();
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        comparaciones();
                    case 5:
                        System.out.println("Finalizando pruebas. . .");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no implementada.");
                }
           } else
                System.out.printf("Número de opción negativo inválido: %d", laopcion);
           
            System.out.println();
        }while (laopcion != opcionfinalizar);
    }
    private static void mostrarTiposParametrizados_Com() {
        Collection<Persona> personas;
        Collection<Empleado> empleados;
        
        personas = new LinkedList<>();
        empleados = new HashSet<>();
        
        personas.add(new Persona("Alan",12,170,"M"));
        personas.add(new Persona("Alan2",12,170,"M"));
        
        empleados.add(new Empleado("Jefe",0,"COM","Miguel",0,0,"M"));
        empleados.add(new Empleado("Ing. Soft",0,"COM","Bill Gates",0,0,"M"));
        
        System.out.println("Las personas son: ");
        for(Persona p : personas)
            System.out.println(p);
        
        System.out.println("Los empleados son: ");
        for(Empleado e : empleados)
            System.out.println(e);
        
        personas.addAll(empleados);
        System.out.println("Personas y empleados juntos son: ");
        for (Persona p : personas)
            System.out.println(p);
    }
    
    static int mult(int n, int m){
        if(m==0)
            return 0;
        if(m==1)
            return n;
        
        return n + mult(n,m-1);
    }
    
    public static void comparaciones(){
        System.out.println("Comparaciones en Java");
        
        Jugador[] jugadores = {
            new Jugador(1,43,"M. Jordan"),
            new Jugador(7,43,"C. Berkley"),
            new Jugador(4,21,"D. Robinson")
        };
        
        System.out.println("Antes de ordenar: ");
        System.out.println(Arrays.toString(jugadores));
    }
    
   
}
