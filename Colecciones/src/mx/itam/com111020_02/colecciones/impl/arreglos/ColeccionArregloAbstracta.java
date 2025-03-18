/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya .
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
package mx.itam.com111020_02.colecciones.impl.arreglos;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase genérica abstracta en la que se implementa estructuras de datos
 * y metodos comunes para todas las implementaciones de colecciones
 * basada en arreglos
 * 
 * @author Alan Amaya 
 * @param <E> El tipo parametrizado de elementos de la colección
 */
abstract public class ColeccionArregloAbstracta<E> implements Collection<E> {
     /**
     * Contiene los elementos del conjunto
     */
    protected E [] arreglo;
    /**
     * El lugar donde se guarda el ultimo elemento
     */
    protected int lastIndex;

    /**
     * El factor de crecimiento
     */
    protected float factorCrecimiento;
    
    /**
     * Constructor con parámetros
     * @param tamaño    Tamaño inicial del arreglo
     * @param factorCrecimiento Factor de crecimiento del arreglo
     */
    public ColeccionArregloAbstracta(int tamaño,float factorCrecimiento){
        if(factorCrecimiento > 0)
            this.factorCrecimiento = factorCrecimiento;
        else
            throw new IllegalArgumentException("Arumento invalido");
        
        if(tamaño < 0)
            tamaño *= -1;
        
        arreglo = (E[]) new Object[tamaño];
        lastIndex = -1;
    }
    
    /**
     * Constructor con un parámetro
     * @param tamaño Tamaño inicial del arreglo.
     */
    public ColeccionArregloAbstracta(int tamaño) {
        if(tamaño < 0)
            tamaño = -tamaño;
        arreglo = (E[]) new Object [tamaño];
        lastIndex = -1;
    }
    
    /**
     * Constructor vacío.
     */
    public ColeccionArregloAbstracta(){
        this(10);
    }
    
    /**
     * Obtiene el factor de crecimiento usado por el metodo
     * (@code incrementaArreglo) 
     * @return El factor de crecimietno usado por el método
     */
    public float getFactorCrecimiento() {
        return factorCrecimiento;
    }
            
    /**
     * Incrementa la longitud del arreglo.
     */
    protected void incrementaArreglo() {
        float factorCrecimiento = 2;
        
        arreglo = Arrays.copyOf(
                arreglo,
                (int) (arreglo.length * factorCrecimiento)
        );
    }
     
    /**
     * Calcula el numero de elementos en la colección
     * @return Un entero con el número de elementos de la colección
     */
    @Override
    public int size() {
        return lastIndex+1;
    }

    /**
     * Evalua si la colección está vacía
     * @return <code>true</code> si la colección está vacía y
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return lastIndex==-1;
    }
    
    /**
     * Evalua si la colección contiene un elemento específico dado.
     * @param arg0  El elemento que se busca
     * @return <code>true</code> si la colección contiene el elemento y
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean contains(Object arg0) {
        for(int i = 0;i <= lastIndex ; i++){
            Object elemento = arreglo[i];
            if(arg0==null){
                if(elemento==arg0)
                    return true;                
            }else if(arg0.equals(elemento)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Construye un iterador para la colección
     * @return El objeto tipo <code>Iterator</code>
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = lastIndex;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                if (index < 0)
                    throw new NoSuchElementException("No hay más elementos");
                return arreglo[index--];
            }                    
        };
    }
    
    /**
     * Convierte la colección en un arreglo de tipo Object[]
     * @return El arreglo tipo Object[] con los valores de la colección.
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arreglo,lastIndex + 1);
    }
    
    /**
     * Convierte la colección en un arreglo de tipo parametrizado T[]
     * @param <T> El tipo de dato de los elementos de la colección.
     * @param a El arreglo de tipo  T 
     * @return El arreglo dado con los elementos de la colección.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < lastIndex + 1)
            a = Arrays.copyOf(a, lastIndex + 1);
        
        int i = 0;
        for (E objeto : this)
            a[i++] = (T) objeto;
        
        for (int j = i; j < a.length; ++j)
            a[j] = null;
        
        return a;

    }
    
    /**
     * Evalua si la colección contiene todos los elementos de otra dada
     * @param c La colección que se busca contener
     * @return <code>true</code> si la colección contiene todos los elementos y
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if(c==null)
            return false;
        
        if(c.isEmpty())
            return true;
        
        for(Object obj : c) {
            if(!contains(obj))
                return false;
        }
        return true;
    }
    
    /**
     * Vacía la colección
     */
    @Override
    public void clear() {
        Arrays.fill(arreglo, null);
        lastIndex = -1;
    }
    
    /**
     * Agrega a la colección todos los elementos de otra dada
     * @param c La segunda colección
     * @return <code>true</code> si la colección se agregó correctamente y
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean valorregreso = false;
        
        for (E obj : c) {
            if (add(obj))
                valorregreso = true;
        }
        
        return valorregreso;
    }
    
}
