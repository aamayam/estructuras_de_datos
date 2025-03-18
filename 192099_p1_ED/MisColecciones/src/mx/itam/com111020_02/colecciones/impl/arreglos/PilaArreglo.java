/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com111020_02.colecciones.impl.arreglos;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import mx.itam.com111020_02.colecciones.Pila;

/**
 * Implementación de la interfaz Pila utilizando arreglos de Java
 * 
 * @author Frida CANO 192099
 */
public class PilaArreglo<E> implements Pila<E> {
   
    /**
     * Este arreglo es la estructura en donde guardamos los elementos de la pila
     */
    private E[]laPila;
    
    /**
     * Indica la cabeza de la pila
     */
    private int cabeza;
    private float factorCrecimiento;

    public PilaArreglo(int tamInicial, float factorCrecimiento) {
        if (factorCrecimiento > 1)
            this.factorCrecimiento = factorCrecimiento;
        else
            throw new IllegalArgumentException("Argumento de factor de crecimiento inválido");
            
        if(tamInicial < 0)
            tamInicial = -tamInicial;
        
        laPila = (E[]) new Object[tamInicial];
        cabeza = -1;
    }
    
    //public PilaArreglo
    public PilaArreglo(){
        this(10);
    }
    public PilaArreglo(int tamInicial) {
        if(tamInicial < 0)
            tamInicial = -tamInicial;
        
        laPila = (E[]) new Object[tamInicial];
        cabeza = -1;
    }
    /**
     * 
     * {@inheritDoc }
     */
    @Override
    public boolean push(E nuevoElemento) {
        boolean valorRegreso;
        
        if (cabeza == laPila.length - 1)
            incrementaArreglo();
        
        if (nuevoElemento != null){
            laPila[++cabeza] = nuevoElemento;
            valorRegreso = true;
        }
        else
            valorRegreso = false;
        
        return valorRegreso;
    }

    /**
     * 
     * Elimina el elemento que se encuantra en la cabeza de la pila
     * 
     * @return El objeto que fue quitado de la cabeza de la pila ó 
     * <code>null</code> si la pila está vacía
     * 
     */
    @Override
    public E pop() {
        E valorRegreso;
        
        if (cabeza >= 0){
            valorRegreso = laPila[cabeza];
            laPila[cabeza--] = null;
        } else
            valorRegreso = null;
        
        return valorRegreso;
    }
    
    public boolean multiPop(int n){
        int m = size();
        boolean res = false;
        if(m > n){
            for (int i = 0; i < n; ++i){
                pop();
            }
            res = true;
        }
        return res;
    }
        

    /**
     * 
     * @return 
     */
    @Override
    public E peek() {
        E valorRegreso;
        
        valorRegreso = pop();
        push(valorRegreso);
        
        return valorRegreso;
    }

    @Override
    public int size() {
        return cabeza + 1;
    }

    @Override
    public boolean isEmpty() {
        return cabeza < 0;
    }
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public boolean contains(Object o) {
        for(int i = 0; i <= cabeza; ++i) {
            if (laPila[i].equals(o))
                return true;
        }
        
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(laPila, cabeza + 1);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(E e) {
        return push(e);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Solo se puede eliminar el objeto que está en la cabeza de la pila"); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsAll(Collection<?> c) {
         if (c == null)
            return false;
        
         if (c.size() == 0)
            return true;

         for (Object obj : c){
            if (!contains(obj))
            return false;
         }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
           for (E obj : c)
               add(obj);
           
           return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        Arrays.fill(laPila, null);
        cabeza = -1;
     }
    
    private void incrementaArreglo(){
        laPila = Arrays.copyOf(laPila, (int) (laPila.length * factorCrecimiento));
    }
    
    @Override
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            private int indice = cabeza;
            
            @Override
            public boolean hasNext(){
                return indice >= 0;
            }
            
            @Override
            public E next(){
                if(indice < 0)
                    throw new NoSuchElementException("La pila no tiene más elementos");
                
                return laPila[indice--];
            }
        };
    }
}
