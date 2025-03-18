/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import mx.itam.com111020_02.colecciones.impl.arreglos.PilaArreglo;
import mx.itam.com111020_02.tarea1;

/**
 *
 * @author alan-
 */
public class Ejercicios {
    
    /**
     * Verifica si la primer pila está contenida en la segunda
     * @param p1 Pila 1
     * @param p2 Pila 2
     * @return <code>true</code> si <code>p1</code> está contenida en 
     * <code>p2</code>, y <code>false</code> en caso contrario.
     */
    public static boolean comparaPilas(PilaArreglo p1, PilaArreglo p2){
        PilaArreglo aux = new PilaArreglo(); //     Copia Pila 1
        PilaArreglo aux2 = new PilaArreglo ();//    Copia Pila 2
        
        if(p1.peek()!=null)
            return true;
        
        for(Object e: p1){
            aux.push(e);
        }
        
        
        while(aux.peek()!=null){
            for(Object e: p2){
            aux2.push(e);
            }
            while(aux2.peek()!= null && !aux2.peek().equals(aux.peek())){
                aux2.pop();
            }
            if(aux2.peek()==null)
                return false;
                            
            aux.pop();
        }
        
        return true;
    }
    
    /**
     * Recibe un entero y devuelve su forma binaria
     * @param num   El numero a convertir
     * @return      Una cadena con la representación binaria del número
     */
    public static String convierteBinario(int num){
        int divisor = num;
        int cociente = 1;
        int i;
        StringBuilder cad = new StringBuilder();
        PilaArreglo aux = new PilaArreglo();
        
        while(cociente > 0){
            cociente = divisor / 2;
            aux.push(divisor%2);
            divisor = cociente;
        }
        
        int n = aux.size();
        for(i=0;i<n;i++){
            cad.append(aux.pop());
        }
        
        return cad.toString();
    }
    
    /**
     * Quita una cantidad, dada por el usuario, de elementos
     * @param a La pila de la que se quieren quitar los elementos
     * @param n El numero de elementos que se quieren quitar
     * @return <code>true</code> si fue posible quitar todos los elementos
     * y <code>false</code> en caso contrario.
     */
    public static boolean quitaNElementos(PilaArreglo a, int n){
        int i;
        int m = a.size();
        if(m > n)
            for(i = 0; i < n ; i++){
                a.pop();
            }
        else
            return false;
        
        return true;
    }            
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        PilaArreglo uno = new PilaArreglo(5);
//        PilaArreglo dos = new PilaArreglo(10);
//        
//        for(int i = 0;i<5;i++)
//            uno.push(i);
//        
//        for(int j=0;j<10;j++)
//            dos.push(j);
//        
//        System.out.println(Ejercicios.comparaPilas(uno, dos));
        
        System.out.println(Ejercicios.convierteBinario(356));
//        
//        PilaArreglo tres = new PilaArreglo(10);
//        for(int i = 0;i<10;i++)
//            tres.push(i);
//        
//        for(Object e: tres){
//            System.out.println(e);
//        }
//        System.out.println(tres.size());
//        
//        Ejercicios.quitaNElementos(tres, 4);
//        
//        tres.multiPop(4);
//        
//        System.out.println(tres.size());
//        
//        for(Object i: tres){
//            System.out.println(tres.pop());
//        }
        
    }
    
}
