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
package ejercicios;

import mx.itam.com111020_02.colecciones.impl.arreglos.PilaArreglo;

/**
 * Ejercicios de Pilas
 * @author Alan Amaya
 */
public class pilasForever {
    
    public static int numElementos (PilaArreglo pila){
        PilaArreglo aux = new PilaArreglo();
        int n=0;
        boolean next = true;
        
        while(next){
            next = aux.push(pila.pop());
            n++;
        }
        
        n--;
        for(int i = 0; i<n;i++){
            pila.push(aux.pop());
        }
        
        return n;
    }
    
    public static void eliminaRepetidos (PilaArreglo pila){
        PilaArreglo aux = new PilaArreglo();    
        int n;
        
        while(pila.peek()!=null){
            aux.push(pila.pop());
            if(pila.peek()==null)
                break;
            else while(pila.peek().equals(aux.peek())){
                pila.pop();
            }
        }
        
        n = aux.size();
        for(int i = 0; i<n ; i++){
            pila.push(aux.pop());
        }
    }
    
    public static void main(String[] args) {
//        PilaArreglo ejm = new PilaArreglo();
//        for(int i = 1; i < 11 ; i++)
//            ejm.push(i);
//        
//        System.out.println("<-- Pila -->");
//        
//        for(Object e: ejm)
//            System.out.println(e);
//        
//        System.out.println("\nNúmero de elementos: " + numElementos(ejm) + "\n");
//        
//        System.out.println("<-- Pila -->");
//        
//        for(Object e : ejm)
//            System.out.println(e);
        
        PilaArreglo dos = new PilaArreglo();
        dos.push(1);
        dos.push(2);
        dos.push(3);
        dos.push(3);
        dos.push(4);
        dos.push(4);
        dos.push(4);
        dos.push(4);
        dos.push(5);
        dos.push(5);
        dos.push(6);
        
        System.out.println("<--- Pila original --->");
        System.out.println("tamaño: " + dos.size());
        for(Object e: dos)
            System.out.println(e);
        
        eliminaRepetidos(dos);
        
        System.out.println("<--- Pila reducida --->");
        System.out.println("tamaño: " + dos.size());
        for(Object e:dos)
            System.out.println(e);
        
    }
}
