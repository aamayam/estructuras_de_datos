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
package mx.itam.com111020_02.colecciones.impl.eenlazada;

import java.util.Collection;
import mx.itam.com111020_02.colecciones.Cola;

/**
 * Implementación de la interfaz Cola utilizando estructuras enlazadas
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 * @param <E> El tipo de datos de los elementos de la Cola
 */
public class ColaEnlazada<E> extends ColeccionEnlazadaAbstracta<E> 
        implements Cola<E>{
    
    /**
     * Ultimo elemento de la Cola.
     */
    private E ultimoValor;
    
    /**
     * Constructor sin parámetros.
     * Inicializa la Cola con el ultimo elemento en <code>null</code>.
     */
    public ColaEnlazada(){
        ultimoValor = null;
    }

    /**
     * Agrega un elemento a la colección.
     * @param e El elemento que se va agregar.
     * @return  Devuelve <code>true</code> si el elemento se insertó
     * correctamente y <code>false</code> en caso contrario.
     */
    @Override
    public boolean add(E e) {
        return enqueue(e);
    }

    /**
     * Llena un arreglo con todos los elementos de la colección.
     * @param <T>   El tipo parametrizado de los elementos de la colección.
     * @param a     El arreglo en el que se van a guardar los elementos de la
     * colección
     * @return      Un arreglo de tipo T en con los elementos de la colección.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Crea un arreglo con los elementos de la colección.
     * @return  Un arreglo de tipo Object con los elementos de la colección.
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * (No soportado)     
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * (No soportado)     
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Inserta un nuevo elemento al final de la colección.
     * @param nuevoValor    El elemento que se va a agregar.
     * @return  Devuelve <code>true</code> si el elemento se insertó
     * correctamente y <code>false</code> en caso contrario.
     */
    @Override
    public boolean insertaUltimo(E nuevoValor) {
        boolean valorRegreso;
        
        valorRegreso = super.insertaUltimo(nuevoValor);
        
        if(valorRegreso)
            ultimoValor = nuevoValor;
        
        return valorRegreso;
    }
        
    /**
     * Introduce un nuevo elemento al final de la cola
     * @param elemento  El elemento agregado
     * @return (@code true) si la operación es exitosa y (@code false) en caso
     * contrario
     */
    @Override
    public boolean enqueue(E elemento) {
        return insertaUltimo(elemento);
    }

    /**
     * Elimina el elemento que está en la cabeza de la cola
     * @return (@code true) si la operación es exitosa y (@code false) en caso
     * contrario
     */
    @Override
    public boolean dequeue() {
        Nodo<E> primero = getPrimero();
        boolean valorRegreso;
        
        if(primero!=null){            
            setPrimero(primero.getSiguiente());
            valorRegreso = true;
            
            setCuantos(getCuantos()-1);
        }else
            valorRegreso = false;
        
        return valorRegreso;
    }

    /**
     * Devuelve el primer elemento de la Cola
     * @return Objeto de tipo E que representa el primer elemento de la Cola
     */
    @Override
    public E primero() {
        Nodo<E> primero = getPrimero();
        
        return primero!=null ? primero.getValor() : null;
    }

    /**
     * Devuelve el último elemento de la Cola
     * @return Objeto de tipo E que representa el último elemento de la Cola
     */
    @Override
    public E ultimo() {
        return getCuantos()!= 0 ? ultimoValor : null;
    }

    /**
     * Hace múltiples eliminaciones en la Cola
     * @param n El número de eliminaciones que se van a realizar
     * @return Un arreglo de tipo E con los elementos que se eliminaron.
     */
    @Override
    public E[] multiDequeue(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Elimina un elemento específico dado.
     * @param valor El elemento que se va a eliminar
     * @return  Devuelve <code>true</code> si el elemento se eliminó 
     * correctamente y <code>false</code> en caso contrario.
     */
    @Override
    public boolean eliminarElemento(Object valor) {
        throw new UnsupportedOperationException("No soportado en Cola");
    }

    /**
     * Inserta un nuevo elemento al principio de la colección
     * @param nuevoValor    El nuevo valor que se va a agregar.
     * @return Devuelve <code>true</code> si el elemento se insertó 
     * correctamente o <code>false</code> en caso contrario.
     */
    @Override
    public boolean insertaPrimero(E nuevoValor) {
        throw new UnsupportedOperationException("No soportado en Cola");
    }
    
    
}
