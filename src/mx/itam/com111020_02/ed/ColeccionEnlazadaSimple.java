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
package mx.itam.com111020_02.ed;

import java.util.Collection;
import java.util.Random;
import java.util.Scanner;
import mx.itam.com111020_02.colecciones.impl.arreglos.ConjuntoArreglo;
import mx.itam.com111020_02.colecciones.impl.eenlazada.ColeccionEnlazadaAbstracta;
import mx.itam.com111020_02.colecciones.impl.eenlazada.Nodo;

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 * @param <E> Tipo de datos 
 */
public class ColeccionEnlazadaSimple<E> extends ColeccionEnlazadaAbstracta<E>{

    @Override
    public boolean add(E o) {
        if(this.isEmpty())
            return insertaPrimero(o);
        else{
            return insertaUltimo(o);
        }
    }
    
    public boolean eliminaSiguienteDe(E info){
        boolean valorRegreso = false;
        
        if(info!=null && !this.isEmpty()){
            Nodo<E> actual;
            actual = this.primero;
        
            while(!actual.getValor().equals(info)){
                actual = actual.getSiguiente();
            }
        
            if(actual!=null){
                if(actual.getSiguiente()!=null){
                    valorRegreso = 
                            eliminarElemento(actual.getSiguiente().getValor());
                }                
            }
        }
        
        return valorRegreso;
    }
    
    public boolean eliminaAnteriorA(E info){
        boolean valorRegreso = false;
        
        if(info!=null && !this.isEmpty()){
            Nodo<E> actual,previo,ant;
            ant = previo = actual = primero;
            
            if(actual.getValor().equals(info))
                return false;
                       
            while(!actual.getValor().equals(info)){
                ant = previo;
                previo = actual;
                actual = actual.getSiguiente();
            }
            
            if(actual!=null){
                ant.setSiguiente(actual);
                valorRegreso = true;
            }
        }
        
        return valorRegreso;
    }
    
    public boolean insertaAntesDe(E refer, E valor){
        boolean valorRegreso = false;
        
        if(valor!=null && !this.isEmpty()){
            Nodo<E> actual,previo,nuevo;
            actual = previo = primero;
            
            if(actual.getValor().equals(refer)){                
                nuevo = new Nodo<>(valor,actual);                
                this.setPrimero(nuevo);
                cuantos++;
                return true;
            }
            
            while(!actual.getValor().equals(refer)){
                previo = actual;
                actual = actual.getSiguiente();
            }
            
            if(actual!=null){
                nuevo = new Nodo<>(valor,actual);
                previo.setSiguiente(nuevo);
                cuantos++;
                valorRegreso = true;
            }
        }
        
        return valorRegreso;
    }
    
    public int eliminaTodosRepetidos(){
        int eliminados = 0;
        
        if(!this.isEmpty()){
            ConjuntoArreglo<E> aux = new ConjuntoArreglo<>();
            Nodo<E> actual,previo;
            actual = previo = primero;
            
            while(actual!=null){
                if(aux.contains(actual.getValor())){
                    previo.setSiguiente(actual.getSiguiente());
                    eliminados++;
                    actual = actual.getSiguiente();
                }else{
                    aux.add(actual.getValor());
                    previo = actual;
                    actual = actual.getSiguiente();
                }                                                    
            }
        }
        
        return eliminados;
    }
    
    public static void main(String[] args) {
        ColeccionEnlazadaSimple<Integer> c1 = new ColeccionEnlazadaSimple<>();
        Random ran = new Random();
        Scanner lee = new Scanner(System.in);
        int val;
        
        try{
            System.out.println("EJERCICIOS.");
            System.out.println("Ingrese el número de elementos inicial para la"
                    + " colección (los elementos se generan aleatoriamente)");
            System.out.print("Num. inicial: ");
            val = lee.nextInt();
            int i;
            
            for(i = 0 ; i<val;i++){
                c1.add(ran.nextInt(10));
            }
            
            for(int e : c1){
                System.out.print(e + " ");
            }
            System.out.println("\n");
            
            System.out.println("Aplicando el método: "
                    + " eliminaSiguienteDe(E e)");
            int op;
            System.out.println("Ingrese un numero para probar: ");
            op = lee.nextInt();
            if(c1.eliminaSiguienteDe(op)){
                for(int e : c1){
                    System.out.print(e + " ");
                }
            }else{
                System.out.println("Imposible realizar la operación");
            }
            System.out.println("\n");    
            
            System.out.println("Aplicando el método: "
                    + " eliminaAneriorA(E e)");
            System.out.print("Ingresa un entero: ");
            int op3 = lee.nextInt();
            if(c1.eliminaAnteriorA(op3)){
                for(int e : c1){
                    System.out.print(e + " ");
                }
            }else{
                System.out.println("Imposible realizar la operación");
            }            
            System.out.println("\n");
            
            System.out.println("Aplicando el método; "
                    + "insertaAntesDe(E ref, E val)");
            int op2;
            System.out.print("Ingresa la referencia: ");
            op = lee.nextInt();
            System.out.print("Ingresa el valor: ");
            op2 = lee.nextInt();
            if(c1.insertaAntesDe(op, op2)){
                for(int e : c1){
                    System.out.print(e + " ");
                }
            }else{
                System.out.println("Imposible...");
            }
            System.out.println("\n");
            
            System.out.println("Eliminando repetidos...");            
            val = c1.eliminaTodosRepetidos();
            for(int e : c1){
                System.out.print(e + " ");
            }
            System.out.println("\n");
            System.out.println(val + " eliminados");
            
        }catch(Exception e){
            System.out.println("Error... Try again");
            System.exit(0);
        }
    }
    
        @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
