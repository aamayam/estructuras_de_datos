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
import mx.itam.com111020_02.colecciones.Pila;

/**
 * Implementación de la interfaz Pila utilizando estructuras enlazadas.
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 * @param <E> El tipo de datos de los elementos de la Pila.
 */
public class PilaEnlazada<E> extends ColeccionEnlazadaAbstracta<E> implements Pila<E>{

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
     * Regresa un arreglo de tipo T con los elementos de la pila. (No soportado)
     * @param <T>   El tipo de datos de la Pila.
     * @param o     El arreglo donde se van a guardar los elementos.  
     * @return      El arreglo con los elementos de la pila.
     */
    @Override
    public <T> T[] toArray(T[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Regresa un arreglo de tipo Object con los elementos de la Pila.
     * (No soportado por este TDA)
     * 
     * @return  El arreglo con los elementos de la Pila.
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Elimina todos los elementos de la Pila contenidos tambien en una
     * colección específica dada. (No soportado por este TDA).
     * 
     * @param c La colección con los elementos que van a ser eliminados
     * @return  <code>true</code> si la elimininación se llevó a cabo con
     * éxito y <code>false</code> en caso contrario.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Conserva en la Pila solo aquellos elementos de esta que tambien estén
     * contenidos en una colección específica dada. (No soportado por este TDA)
     * 
     * @param c La colección con los elementos que deben ser conservados.
     * @return  <code>true</code> si la elimininación se llevó a cabo con
     * éxito y <code>false</code> en caso contrario.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Inserta un nuevo elemento en la cabeza de la Pila
     * @param nuevoObjeto   El objeto que se va a agregar
     * @return <code>true</code> si el objeto fue insertado exitosamente;
     * <code>false</code> en otro caso
     */
    @Override
    public boolean push(E nuevoObjeto) {
        return insertaPrimero(nuevoObjeto);
    }

    /**
     * Elimina el elemento que se encuentra en la cabeza
     * @return El objeto que fue quitado de la arreglo o
     * <code> null</code>  si la arreglo está vacia
     */
    @Override
    public E pop() {
        Nodo<E> cabeza = getPrimero();
        E valorRegreso;
        
        if(cabeza!=null){
            valorRegreso = cabeza.getValor();        
            setPrimero(cabeza.getSiguiente());
            
            setCuantos(getCuantos()-1);
        }else
            valorRegreso = null;
        
        return valorRegreso;
    }

    /**
     * Regresa el primer objeto sin modificar la pila
     * @return El objeto que se encuentra en la cabeza de la pila
     */
    @Override
    public E peek() {
        Nodo<E> cabeza = getPrimero();
        
        return cabeza!=null ? cabeza.getValor() : null;
    }

    /**
     * Elimina un elemento específico dado.
     * @param valor El elemento que se va a eliminar
     * @return  Devuelve <code>true</code> si el elemento se eliminó 
     * correctamente y <code>false</code> en caso contrario.
     */
    @Override
    public boolean eliminarElemento(Object valor) {
        throw new UnsupportedOperationException("Metodo no soportado en Pila");
    }

    /**
     * Inserta un nuevo elemento al final de la colección.
     * @param nuevoValor    El elemento que se va a agregar.
     * @return  Devuelve <code>true</code> si el elemento se insertó
     * correctamente y <code>false</code> en caso contrario.
     */
    @Override
    public boolean insertaUltimo(E nuevoValor) {
        throw new UnsupportedOperationException("Metodo no soportado en Pila");
    }

    /**
     * Elimina consecutivamente una cantidad dada de elementos 
     * de la pila
     * @param n El número de elementos que se quieren quitar
     * @return <code>true</code> si los elementos se eliminaron correctamente y
     * <code>false</code> en caso contrario.
     */   
    @Override
    public boolean multiPop(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
