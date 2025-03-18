/*
 * The MIT License
 *
 * Copyright 2020 alan-.
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

import java.util.ArrayList;
import java.util.Scanner;
import mx.itam.com111020_02.colecciones.impl.arreglos.PilaArreglo;

/**
 *
 * @author <a href="mailto: aamayama@itam.mx">Alan Amaya (191165)</a> 
 */
public class tarea1 <T>{
    
    
    /**
     * 
     * @param cadena
     * @return <code>true</code> si la cadena está bien balanceada y 
     * <code>false</code> en caso contrario
     */
    public static boolean revisaParentesis(String cadena){
        int n = cadena.length(),i;
        PilaArreglo pila = new PilaArreglo(n);
        
        for(i=0;i<n;i++){
            if(cadena.charAt(i)=='(')
                pila.push('(');
            else if(cadena.charAt(i)==')')
                if(pila.pop()==null)
                    return false;            
        }      
        if(!pila.isEmpty())
            return false;
                
        return true;
        }
    
    /**
     * 
     * @param pila  : La pila que se va a voltear
     * @return una nueva pila con los elementos invertidos 
     */
    public static PilaArreglo inviertePila(PilaArreglo pila){
        int n = pila.size();
        int i;
        PilaArreglo res = new PilaArreglo(n);
        
        for(i=0;i<n;i++){
            res.push(pila.pop());
        }
        
        return res;
    }
    
    /**
     * No implementado totalmente
     * @param e 
     */
    public static void volteaPila(PilaArreglo e){
        ArrayList aux = new ArrayList();
        int n = e.size(),i;
        for(i=0;i<n;i++){
            aux.add(e.pop());
            System.out.println(aux.get(i));
        }
        
        for(i=0;i<n;i++){
            e.push(aux.get(i));
        }        
    }
    
    public static boolean revisaParentesis2(String cadena){
        int n = cadena.length();
        PilaArreglo aux = new PilaArreglo(n);
        int i;
        
        for(i=0;i<n;i++){
            switch (cadena.charAt(i)){
                case '(':
                    aux.push(')');
                    break;
                case '[':
                    aux.push(']');
                    break;
                case '{':
                    aux.push('}');
                    break;
                default:
                    if(cadena.charAt(i)==')' || cadena.charAt(i)==']' || cadena.charAt(i)=='}'){
                        if(aux.peek()==null)
                            return false;
                        else if(aux.peek().equals(cadena.charAt(i)))
                            aux.pop();
                        else
                            return false;
                    }                       
                    
            }
        }
        
        if(!aux.isEmpty())
            return false;
        
        return true;
    }
    
    public static void main (String[] args){
        Scanner read = new Scanner(System.in);
        int opcion;        
        String cad;
        do{
           System.out.println("TAREA 1");
        System.out.println("Seleccione una opción:");
        System.out.println("1.- Verificar parentesis -()-");
        System.out.println("2.- Verificar parentesis -(),[],{}-");
        System.out.println("3.- Invertir una estructura tipo Pila");
        System.out.println("4.- Salir");
        System.out.println("\nSelección: ");
        
        opcion = read.nextInt();
        
        switch(opcion) {
               case 1:
                   System.out.println("Ingrese la cadena para verificar: ");
                   cad = read.next();
                   System.out.println(tarea1.revisaParentesis(cad));                   
                   break;
               case 2:
                   System.out.println("Ingrese la cadena para verificar: ");
                   cad = read.next();
                   System.out.println(tarea1.revisaParentesis2(cad));
                   break;
               case 3:                   
                   PilaArreglo prueba = new PilaArreglo(10);
                   int i;
                   for(i=1;i<11;i++){
                       prueba.push(i);
                   }
                   
                   System.out.println("La cadena original es: ");
                   for(Object e: prueba){
                       System.out.println(e);
                   }
                                      
                   System.out.println("La cadena invertida es: ");
                   for(Object a: tarea1.inviertePila(prueba)){
                       System.out.println(a);
                   }
                   
                   break;
               case 4:
                   System.out.println("Saliendo . . .");
                   break;
               default :
                   System.out.println("Opción no válida");
                   break;
           }
        }while(opcion!=4);
        
        
        
//        System.out.println(tarea1.revisaParentesis("(()(())())"));
//        
//        PilaArreglo ejemplo = new PilaArreglo(10);
//        for(int i=0; i< 10; i++){
//            ejemplo.add(i);
//        }
//        
//        
//        System.out.println("pila original\n");
//        for(Object e : ejemplo){
//            System.out.println(e);
//        }
//        
//        System.out.println("Pila volteada con el método 1\n");
//        for(Object e : tarea1.inviertePila(ejemplo)){
//            System.out.println(e);
//        }
//        
//        System.out.println("Pila volteada con el método 2");
//        tarea1.volteaPila(ejemplo);
//        for(Object e: ejemplo){
//            System.out.println(e);
//        }
//        
//        System.out.println(tarea1.revisaParentesis2("([{}])"));
    }
}