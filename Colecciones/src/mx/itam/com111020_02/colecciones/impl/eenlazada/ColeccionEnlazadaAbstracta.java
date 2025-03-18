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
import java.util.Iterator;

/**
 * Clase abstracta que representa cualquier colección basada en estructuras 
 * enlazadas (lineales) con operaciones básicas de inserción, borrado, busqueda.
 * 
 * @param <E>   Tipo parametrizado de los valores que se guardan en la 
 * colección.
 * 
 * @author Alan Amaya 191165 (aamayama@itam.mx) 
 */
public abstract class ColeccionEnlazadaAbstracta<E> implements Collection<E>{
    
    /**
     * Objeto tipo Nodo que representa al primero elemento en la colección
     */
    protected Nodo<E> primero;
    
    /**
     * Indica el número de elementos en la colección
     */
    protected int cuantos;

    /**
     * Constructor sin parámetros. 
     * Inicializa la colección con la primera referencia en <code>null</code> 
     */
    public ColeccionEnlazadaAbstracta() {
        primero = null;
        cuantos = 0;
    }

    /**
     * Agrega un elemento en el primer nodo
     * @param primero El primero nodo de la colección
     */
    protected void setPrimero(Nodo<E> primero) {
        this.primero = primero;
    }

    /**
     * Agrega el número de elementos de la colección
     * @param cuantos El número de elementos.
     */
    protected void setCuantos(int cuantos) {
        this.cuantos = cuantos;
    }
    
    /**
     * Obtiene el primero nodo de la colección
     * @return El primer nodo de la colección
     */
    protected Nodo<E> getPrimero() {
        return primero;
    }

    /**
     * Devuelve el total de elementos en la colección
     * @return Un <code>int</code> que representa el numero de nodos enlazados 
     * en la colección.
     */
    public int getCuantos() {
        return cuantos;
    }
        
    /**
     * Inserta un nuevo elemento al principio de la colección
     * @param nuevoValor    El nuevo valor que se va a agregar.
     * @return Devuelve <code>true</code> si el elemento se insertó 
     * correctamente o <code>false</code> en caso contrario.
     */
    public boolean insertaPrimero(E nuevoValor){
        boolean valorRegreso;
        
        if(nuevoValor != null){
            Nodo<E> nuevoPrimero = new Nodo<>(nuevoValor,primero);
            
            primero = nuevoPrimero;
            
            ++cuantos;
            valorRegreso = true;
        }else{
            valorRegreso = false;
        }
        
        return valorRegreso;
    }
    
    /**
     * Inserta un nuevo elemento al final de la colección.
     * @param nuevoValor    El elemento que se va a agregar.
     * @return  Devuelve <code>true</code> si el elemento se insertó
     * correctamente y <code>false</code> en caso contrario.
     */
    public boolean insertaUltimo(E nuevoValor){
        boolean valorRegreso;
        
        if(nuevoValor!=null){
            Nodo<E> previo, actual;
            
            previo = actual = primero;
            
            while(actual!=null){
                previo = actual;
                actual = actual.getSiguiente();
            }
            
            Nodo<E> nuevoUltimo = new Nodo(nuevoValor,null);
            
            if(previo!=null)
                previo.setSiguiente(nuevoUltimo);
            else
                primero = nuevoUltimo;
            
            ++cuantos;
            valorRegreso = true;
        }else{
            valorRegreso = false;
        }
        
        return valorRegreso;
    }
    
    /**
     * Elimina un elemento específico dado.
     * @param valor El elemento que se va a eliminar
     * @return  Devuelve <code>true</code> si el elemento se eliminó 
     * correctamente y <code>false</code> en caso contrario.
     */
    public boolean eliminarElemento(Object valor){
        boolean valorRegreso = false;
        
        if(valor!=null){
            Nodo<E> previo,actual;
            
            previo = actual = primero;
            
            while(actual!=null){
                if(valor.equals(actual.getValor())){
                    if(actual==primero)
                        primero = actual.getSiguiente();
                    else
                        previo.setSiguiente(actual.getSiguiente());
                    
                    --cuantos;
                    valorRegreso = true;
                    
                    break;
                }
                
                previo = actual;
                actual = actual.getSiguiente();
            }            
                        
        }
        
        return valorRegreso;
    }
    
    /**
     * Busca un elemento dado en la colección.
     * @param valor El objeto que se está buscando.
     * @return  Devuelve <code>true</code> si el elemento se encuentra en la 
     * colección y <code>false</code> en caso contrario.
     */
    public boolean buscarElemento(Object valor){
        boolean valorRegreso = false;
        
        if(valor!=null){
            Nodo<E> actual;
            
            actual = primero;
            
            while(actual!=null){
                if(valor.equals(actual.getValor())){                    
                    valorRegreso = true;
                    
                    break;
                }                
                
                actual = actual.getSiguiente();
            }
        }else
            valorRegreso = false;
        
        return valorRegreso;
    }

    /**
     * Hace <code>null</code> el primer nodo para dejar vacia la colección.
     */
    @Override
    public void clear(){
        primero = null;
    }

    /**
     * Agrega a la colección todos los elementos contenidos en una colección
     * dada.
     * @param c La colección de la que se tomarán los elementos.
     * @return <code>true</code> si los elementos son agregados correctamente
     * y <code>false</code> en caso contrario. 
     */
    @Override
    public boolean addAll(Collection<? extends E> c){
        boolean valorRegreso = false;
        
        for (E obj : c) {
            if (add(obj))
                valorRegreso = true;
        }
        
        return valorRegreso;
    }

    /**
     * Evalua que la colección contenga todos los elementos de una colección 
     * específica dada.
     * @param c La colección con los elementos que se van a buscar.
     * @return  <code>true</code> si todos los elementos de <code>c</code> 
     * están contenidos en la colección y code <code>false</code> en caso
     * contrario.
     */
    @Override
    public boolean containsAll(Collection<?> c){
        if (c == null)
            return false;
        
        if (c.isEmpty())
            return true;
        
        for (Object obj : c) {
            if (!contains(obj))
                return false;
        }
        
        return true;
    }

    /**
     * Elimina un objeto de la colección
     * @param o El objeto que se va a eliminar.
     * @return  Devuelve <code>true</code> si el elemento se eliminó 
     * correctamente y <code>false</code> en caso contrario.
     */
    @Override
    public  boolean remove(Object o){
        return eliminarElemento(o);
    }

    /**
     * Agrega un elemento a la colección.
     * @param o El elemento que se va agregar.
     * @return  Devuelve <code>true</code> si el elemento se insertó
     * correctamente y <code>false</code> en caso contrario.
     */
    @Override
    public abstract boolean add(E o);

    /**
     * Llena un arreglo con todos los elementos de la colección.
     * @param <T>   El tipo parametrizado de los elementos de la colección.
     * @param a     El arreglo en el que se van a guardar los elementos de la
     * colección
     * @return      Un arreglo de tipo T en con los elementos de la colección.
     */
    @Override
    public abstract <T> T[] toArray(T[] a);

    /**
     * Crea un arreglo con los elementos de la colección.
     * @return  Un arreglo de tipo Object con los elementos de la colección.
     */
    @Override
    public abstract Object[] toArray();

    /**
     * Genera un iterador para la colección.
     * @return  Un objeto de tipo Iterator.
     */
    @Override
    public  Iterator<E> iterator(){
        return new Iterator<E>(){
            Nodo<E> actual = primero;
            
            public boolean hasNext(){
                return actual!=null;
            }
            
            public E next(){
                E valor = actual.getValor();
                
                actual = actual.getSiguiente();
                
                return valor;
            }
            
        };
    }

    /**
     * Evalua si la colección contiene un elemento específico dado.
     * @param o El objeto que se está buscando
     * @return <code>true</code> si el elemento está contenido en la colección
     * y <code>false</code> en caso contrario.
     */
    @Override
    public boolean contains(Object o){
        return buscarElemento(o);
    }

    /**
     * Evalua si la colección está vacía.
     * @return <code>true</code> si la colección está vacía y <code>false</code>
     * en caso contrario.
     */
    @Override
    public boolean isEmpty(){
        return primero==null;
    }

    /**
     * Calcula el tamaño de la colección.
     * @return  Un <code>int</code> con el número de elementos de la colección.
     */
    @Override
    public int size(){
        return cuantos;
    }    
}
