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
package mx.itam.com111020_02.colecciones.impl.arreglos;

import java.util.Collection;
import mx.itam.com111020_02.colecciones.Cola;

/**
 * Implementación de la interfaz Cola utilizando como estructura de datos
 * interna un arreglo
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 * @param <E> Tipo de datos
 */
public class ColaArregloCircular<E> extends ColeccionArregloAbstracta<E> implements Cola<E>{
    
    private int primerIndice;
    
    private int cuantos;

    /**
     * Constructor con parámetros
     * @param tamaño    Tamaño inicial del arreglo
     * @param factorCrecimiento Factor de crecimiento del arreglo
     */
    public ColaArregloCircular(int tamaño, float factorCrecimiento) {
        super(tamaño, factorCrecimiento);
        
        primerIndice = -1;
        cuantos = 0;
    }

    /**
     * Constructor con un parámetro
     * @param tamaño Tamaño inicial del arreglo.
     */
    public ColaArregloCircular(int tamaño) {
        this(tamaño,2);
    }

    /**
     * Constructor vacío.
     */
    public ColaArregloCircular() {
        this(10,2);
    }
      
    /**
     * Agrega un elemento a la cola
     * @param e El objeto que se va a agregar
     * @return <code>true</code> si el objeto se agregó correctamente y 
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean add(E e) {
        return enqueue(e);
    }

    /**
     * No implementado
     * @param o --
     * @return --
     */
    @Override
    public boolean remove(Object o) {
        if(!isEmpty() && primero().equals(o))
            return dequeue();
        
        throw new UnsupportedOperationException(
                "Solo se puede eliminar el primer elemento de la cola"
        );
    }

    /**
     * No implementado
     * @param o --
     * @return --
     */
    @Override
    public boolean removeAll(Collection<?> o) {
        throw new UnsupportedOperationException(
                "Solo se puede eliminar el primer elemento de la cola"
        );
    }

    /**
     * No implementado
     * @param o --
     * @return --
     */
    @Override
    public boolean retainAll(Collection<?> o) {
        throw new UnsupportedOperationException(
                "Operación no soportada por el TDA Cola"
        );
    }

    /**
     * Agrega un elemento a la cola
     * @param elemento El elemento que se va a agregar
     * @return <code>true</code> si el objeto se agregó correctamente y 
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean enqueue(E elemento) {
        if(size()==arreglo.length)
            incrementaArreglo();
        
        if(elemento!=null){
        lastIndex = calcularSiguienteIndice(lastIndex);
        arreglo[lastIndex] = elemento;
        
        ++cuantos;
        
        if(primerIndice < 0)
            primerIndice = 0;
        
        return true;
        }
        
        return false;
    }

    /**
     * Elimina el primer elemento de la cola
     * @return <code>true</code> si el objeto se eliminó correctamente y 
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean dequeue() {                
        if(cuantos > 0) {
            arreglo[primerIndice] = null;
            
            --cuantos;
            
            if(cuantos > 0)
                primerIndice = calcularSiguienteIndice(primerIndice);
            else
                primerIndice = lastIndex = -1;
        
            return true;       
        }
        
        return false;
    }

    /**
     * hace multiples eliminaciones 
     * @param n el numero de elimincaciones que se van a hacer
     * @return Un arreglo con los elementos eliminados
     */
    @Override
    public E[] multiDequeue(int n) {
        E[] res = (E[]) new Object[n];
        
        if(!isEmpty()){
            ColaArregloCircular cola = new ColaArregloCircular();
            cola = multiDequeueRecursivo(n,cola);
            for(int i = 0; i<n;i++){                
                res[i]=(E) cola.primero();
                cola.dequeue();
            }
        }
        
        return res;
    }  
   
    /**
     * Devuelve el primer elemento de la cola
     * @return El primer elemento de la cola
     */
    @Override
    public E primero() {
        if(cuantos!=0)
            return arreglo[primerIndice];
        
        return null;
    }

    /**
     * Devuelve el último elemento de la cola
     * @return El último elemento de la cola
     */
    @Override
    public E ultimo() {
        if(cuantos!=0)
            return arreglo[lastIndex];
        
        return null;
    }
    
    /**
     * Calcula el siguiete índice en el arreglo circular
     * @param indiceActual El indice actual
     * @return El siguiente índice
     */
    private int calcularSiguienteIndice(int indiceActual){
        return (indiceActual + 1) % arreglo.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void incrementaArreglo() {
        E[] masLargo = (E[])(new Object[(int)(arreglo.length*getFactorCrecimiento())]);
        
        for(int i=0;i<cuantos;i++){
            masLargo[i]=arreglo[primerIndice];
            primerIndice = calcularSiguienteIndice(primerIndice);
        }
        
        primerIndice = 0;
        lastIndex = cuantos-1;
        
        arreglo=masLargo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        if(!isEmpty()){
            if(lastIndex>=primerIndice)
                return (lastIndex-primerIndice)+1;
            else
                return (arreglo.length-primerIndice)+(lastIndex+1);
        }
        
        return 0;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void clear() {
        super.clear();
        primerIndice = -1;
        cuantos = 0;
    }

    /**
     * {@inheritDoc }     
     */
    @Override
    public boolean contains(Object arg0) {
        for(int i = 0;i <= cuantos ; i++){
            Object elemento = arreglo[calcularSiguienteIndice(i+primerIndice-1)];
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
     * Evalua si la cola está vacía
     * @return <code>true</code> si la cola está vacía y
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return cuantos==0;
    }
    
    /**
     * Hace multiples eliminaciones de manera recursiva
     * @param n numero de eliminaciones por hacer
     * @param c La cola de la que se van a eliminar los objetos
     * @return La cola despues de la eliminación
     */
    private ColaArregloCircular multiDequeueRecursivo(int n,ColaArregloCircular c){                
        if(n==1){
            c.enqueue(primero());
            dequeue();
        }else{
            c.enqueue(primero());
            dequeue();                  
            multiDequeueRecursivo(--n,c);
        } 
        
        return c;
    }
}
