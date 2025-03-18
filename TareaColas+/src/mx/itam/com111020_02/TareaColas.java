/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya 191165 (aamayama@itam.mx) .
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mx.itam.com111020_02;

import java.util.InputMismatchException;
import java.util.Scanner;
import mx.itam.com111020_02.colecciones.impl.arreglos.ColaArregloCircular;
import mx.itam.com111020_02.colecciones.impl.arreglos.ConjuntoArreglo;
import mx.itam.com111020_02.colecciones.impl.arreglos.PilaArreglo;

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class TareaColas {
    
    public static void main(String[] args) {
        System.out.println("    <<-- TAREA COLAS, CONJUNTOS, RECURSIÓN -->>");
        System.out.println("    BIENVENIDO");
        int opcion=0;
        Scanner scan = new Scanner(System.in);
                
        do{
            System.out.println("1.- Invertir elementos de una cola"); 
            System.out.println("2.- Pregunta 2");
            System.out.println("3.- multiDequeue(int n)");
            System.out.println("4.- Funciones de conjuntos");
            System.out.println("5.- Salir");
            try{
                System.out.println("\nOpcion: ");
                opcion = scan.nextInt();
                if(opcion>5 || opcion<1)
                    throw new IllegalArgumentException("Argumento de entrada inválido");
            }catch(IllegalArgumentException e){
                System.out.println("Error!: ");
                System.out.println(e.getMessage());
                System.exit(0);
            }catch(InputMismatchException e){
                System.out.println("Error: ");
                System.out.println("Entrada inválida");
                System.exit(0);
            }
            
            switch(opcion){
                case 1:
                    ColaArregloCircular cola = new ColaArregloCircular();
                    for(int i=0;i<10;i++)
                        cola.enqueue(i);
                    
                    System.out.println("    INVERTIR ELEMENTOS DE UNA COLA");
                    
                    System.out.println("Los valores en la cola son: ");
                    System.out.println(imprimeCola(cola));
                    
                    System.out.println("Cola invertida por método iterativo: ");
                    invierteCola(cola);
                    System.out.println(imprimeCola(cola));
                    invierteCola(cola);
                    
                    System.out.println("Cola invertida por método recursivo: ");
                    invierteColaRecursiva(cola);
                    System.out.println(imprimeCola(cola));
                    invierteColaRecursiva(cola);
                    System.out.println("\n\n");
                    break;
                case 2:
                    System.out.println("Para calcular el numero de elementos "
                            + "utilizando el primer y ultimo indice");                    
                    System.out.println("se utilizaría el siguiente código:");                    
                    System.out.println("if(!isEmpty()){\n" +
                    "   if(lastIndex>=primerIndice)\n" +
                    "       return (lastIndex-primerIndice)+1;\n" +
                    "   else\n" +
                    "       return (arreglo.length-primerIndice)+(lastIndex+1);\n" +
                    "}\n");

                    System.out.println("\n\nRestando el primer indice al ultimo "
                            + "si primero < ultimo");
                    System.out.println("o restando el primero a la longitud del "
                            + "arreglo y sumando el ultimo indice + 1");
                    System.out.println("\n\n");
                    break;
                case 3:
                    ColaArregloCircular cola2 = new ColaArregloCircular();
                    for(int i=0;i<10;i++)
                        cola2.enqueue(i);
                    
                    System.out.println("    MULTIDEQUEUE");
                    
                    System.out.println("Los valores en la cola son: \n");
                    System.out.println(imprimeCola(cola2));
                    
                    int n=0;
                    try{
                        System.out.println("\nIngrese un entero entre 1 y 10: ");
                        n = scan.nextInt();
                        if(n>10 || n<1)
                            throw new IllegalArgumentException("Entrada inválida");
                    }catch(IllegalArgumentException arg){
                        System.out.println("    Error: ");
                        System.out.println("    " + arg.getMessage());
                        System.exit(0);
                    }catch(InputMismatchException ms){
                        System.out.println("    Error: ");
                        System.out.println("    Entrada inválida");
                        System.exit(0);
                    }
                    
                    Object [] array = cola2.multiDequeue(n);
                    System.out.println("\nSacando "+n+" elementos de la cola");
                    System.out.println(". . .");
                    System.out.println(imprimeCola(cola2));
                    
                    System.out.println("\nArreglo con los elementos sacados: \n");
                    for(Object e:array)
                        System.out.print(e+" ");
                    
                    System.out.println("\n\n");
                    
                    break;

                case 4:
                    System.out.println("    OPERACIONES CON CONJUNTOS");
                    ConjuntoArreglo set1 = new ConjuntoArreglo();
                    ConjuntoArreglo set2 = new ConjuntoArreglo();
                    
                    for(int i=1;i<11;i++)
                        set1.add(i);
                                       
                    set2.add(2);
                    set2.add(4);
                    set2.add(6);
                    set2.add(8);
                    set2.add(10);
                    set2.add(12);
                    set2.add(14);
                    
                    System.out.println("\nPrimer conjunto: ");
                    System.out.println(imprimeConjunto(set1));
                    System.out.println("\nSegundo conjunto: ");
                    System.out.println(imprimeConjunto(set2));
                    
                    System.out.println("\n  UNION: ");
                    System.out.println(imprimeConjunto(union(set1,set2)));
                    
                    System.out.println("\n  INTERSECCION: ");
                    System.out.println(imprimeConjunto(interseccion(set1,set2)));
                    
                    System.out.println("\n  DIFERENCIA: ");
                    System.out.println(imprimeConjunto(diferencia(set1,set2)));
                    
                    System.out.println("\n DIFERENCIA SIMETRICA: ");
                    System.out.println(imprimeConjunto(diferenciaSimetrica(set1,set2)));
                    
                    System.out.println("\n\n");
            }
        }while(opcion!=5);
    }    
    
    public static String imprimeCola(ColaArregloCircular c){
        ColaArregloCircular aux = new ColaArregloCircular();
        StringBuilder cad = new StringBuilder();
        int n=0;
        while(!c.isEmpty()){
            aux.enqueue(c.primero());
            cad.append(c.primero()).append(" ");
            c.dequeue();
            n++;
        }
        
        int i;
        
        for(i=0;i<n;i++){
            c.enqueue(aux.primero());
            aux.dequeue();
        }
        
        return cad.toString();
    }
    
    public static void invierteCola(ColaArregloCircular c){
        PilaArreglo aux = new PilaArreglo();
        int n=0;
        while(!c.isEmpty()){
            aux.push(c.primero());
            c.dequeue();
            n++;            
        }
        
        int i;
        for(i=0;i<n;i++){
            c.enqueue(aux.pop());
        }
    }
    
    public static void invierteColaRecursiva(ColaArregloCircular c){
        if(!c.isEmpty()){
            Object e = c.primero();
            c.dequeue();
            
            if(c.size()<=1)
                c.enqueue(e);
            else{
                invierteColaRecursiva(c);
                c.enqueue(e);
            }
        }
    }
    
    public static String imprimeConjunto(ConjuntoArreglo c){
        StringBuilder cad = new StringBuilder();
        for(Object e:c){
            cad.append(e).append(" ");
        }
        
        return cad.toString();
    }
    
    public static ConjuntoArreglo union(ConjuntoArreglo a,ConjuntoArreglo b){
        ConjuntoArreglo res = new ConjuntoArreglo();
        res.addAll(a);
        res.addAll(b);
        
        return res;
    }
    
    public static ConjuntoArreglo interseccion(
            ConjuntoArreglo a, ConjuntoArreglo b
    ){
        ConjuntoArreglo res = new ConjuntoArreglo();
        res.addAll(a);
        res.retainAll(b);
        
        return res;
    }
    
    public static ConjuntoArreglo diferencia(
            ConjuntoArreglo set1, ConjuntoArreglo set2
    ){
        ConjuntoArreglo res = new ConjuntoArreglo();
        res.addAll(set1);
        res.removeAll(set2);
        
        return res;
    }
    
    public static ConjuntoArreglo diferenciaSimetrica(ConjuntoArreglo set1, ConjuntoArreglo set2){
        ConjuntoArreglo res = new ConjuntoArreglo();
        res = diferencia(union(set1,set2),interseccion(set1,set2));    
        
        return res;
    }
        
}
