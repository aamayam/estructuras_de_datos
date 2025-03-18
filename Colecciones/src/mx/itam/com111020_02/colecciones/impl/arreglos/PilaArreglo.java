/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya (191165).
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

import java.util.Collection;
import mx.itam.com111020_02.colecciones.Pila;

/**
 *
 * Implementacion de la intefaz Pila utilizando arreglos de java
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 * @param <E> generic class for the stack's objects
 */
public class PilaArreglo <E> extends ColeccionArregloAbstracta<E> implements Pila<E> {

    public PilaArreglo(int tamaño, float factorCrecimiento) {
        super(tamaño, factorCrecimiento);
    }

    public PilaArreglo(int tamaño) {
        super(tamaño);
    }

    public PilaArreglo() {
    }
    
    /**
     * Inserta un nuevo elemento en la cabeza de la Pila
     * @param nuevoObjeto   El objeto que se va a agregar
     * @return <code>true</code> si el objeto fue insertado exitosamente;
     * <code>false</code> en otro caso
     */
    @Override
    public boolean push(E nuevoObjeto) {
        boolean res;
        
        if(lastIndex == arreglo.length -1)
            incrementaArreglo();
        
        if(nuevoObjeto != null){
            arreglo[++lastIndex] = nuevoObjeto;            
            res = true;
        }else
            res = false;
        
        return res;
    }

    /**
     * Elimina el elemento que se encuentra en la cabeza
     * @return El objeto que fue quitado de la arreglo o
     * <code> null</code>  si la arreglo está vacia
     */
    @Override
    public E pop() {
        E objetoRegresado;
        if(lastIndex >=0 ){
            objetoRegresado = arreglo[lastIndex];
            arreglo[lastIndex--] = null;
        }else
            objetoRegresado = null;
        
        return objetoRegresado;
    }
    
    /**
     * Elimina una cantidad dada de elementos de la arreglo
     * @param n el numero de elementos que se van a quitar
     * @return <code>true</code> si la operación se realizó con éxito y
     * <code>false</code> en caso contrario
     */
    public boolean multiPop(int n){
        int m = this.size();
        int i;
        if(m>n){
            for(i=0;i<n;i++)
                this.pop();
        }
        else 
            return false;
        
        return true;
    }
    
    /**
     * Regresa el primer objeto sin modificar la pila
     * @return El objeto que se encuentra en la cabeza de la pila
     */
    @Override    
    public E peek() {
        E valorRegresado;
        
        valorRegresado = pop();
        push(valorRegresado);
        
        return valorRegresado;
    }

    /**
     * Agrega un elemento a la arreglo
     * @param e El elemento que se desea agregar a la arreglo
     * @return <code>true</code> si la asición sucedió con éxito y
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean add(E e) {
        return push(e);
    }

    /**
     * No implementado aun
     * @param arg0 elemento por eliminar
     * @return <code>true</code> si la eliminación fue correcta y
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean remove(Object arg0) {
        throw new UnsupportedOperationException("Solo se puede eliminar el "
                + "objeto que está en la cabeza");
    }

    /**
     * No implementado aun
     * @param arg0 colección con los elementos por eliminar
     * @return <code>true</code> si la eliminación fue correcta y
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean removeAll(Collection<?> arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * No implementado aun
     * @param c con elementos por mantener
     * @return <code>true</code> si la eliminación fue correcta y
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
