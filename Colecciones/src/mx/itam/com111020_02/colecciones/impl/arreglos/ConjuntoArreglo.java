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

import java.util.Collection;
import mx.itam.com111020_02.colecciones.Conjunto;

/**
 * Implementación de la interfaz Conjunto utilizando como estructura de datos
 * interna un arreglo
 * @author Alan Amaya
 * @param <E> El tipo parametrizado de los elementos del conjunto
 */
public class ConjuntoArreglo<E> extends ColeccionArregloAbstracta<E> implements Conjunto<E> {

    /**
     * Constructor con parámetros
     * @param tamaño    Tamaño inicial del arreglo
     * @param factorCrecimiento Factor de crecimiento del arreglo
     */
    public ConjuntoArreglo(int tamaño, float factorCrecimiento) {
        super(tamaño, factorCrecimiento);
    }

    /**
     * Constructor con un parámetro
     * @param tamaño Tamaño inicial del arreglo.
     */
    public ConjuntoArreglo(int tamaño) {
        super(tamaño);
    }

    /**
     * Constructor vacío.
     */
    public ConjuntoArreglo() {
    }
    
    /**
     * Agrega un elemento a la cola
     * @param e El objeto que se va a agregar
     * @return <code>true</code> si el objeto se agregó correctamente y 
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean add(E e) {
        boolean res = false;
        if(!contains(e)){
            if(arreglo.length-1 == lastIndex)
                incrementaArreglo();
            arreglo[++lastIndex] = e;
            res = true;
        }            
                
        return res;
    }

    /**
     * Elimina un objeto dado del conjunto
     * @param a El elemento que se va a borrar
     * @return <code>true</code> si el objeto se eliminó correctamente y 
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean remove(Object a) {
        int i;        
        for(i=0;i<=lastIndex;i++){
            if(a==null){
                if(arreglo[i]==a)
                    break;
            }else if(a.equals(arreglo[i]))
                break;
        }
        
        if(i<=lastIndex){
            arreglo[i] = arreglo[lastIndex];
            arreglo[lastIndex] = null;
            --lastIndex;
            return true;
        }
        
        return false;
    }

    /**
     * Elimina del conjunto todos los elementos de una colección dada
     * @param c La colección con los elementos que se van a borrar
     * @return <code>true</code> si los objetos se eliminaros correctamente y 
     * <code>false</code> en caso contrario
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res=true;
        
        for(Object e: c){
            if(this.contains(e))
                remove(e);
        }
        
        return res;
    }

    /**
     * Mantiene en el conjunto solo los elementos contenidos tambien en la 
     * colección dada
     * @return <code>true</code> si la eliminación fue correcta y
     * <code>false</code> en caso contrario.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean res = true;
        int i=0;
        
        while(i<this.size()){
            if(!c.contains(arreglo[i]))
                remove(arreglo[i]);
            else
                i++;
        }
        
        return res;
    }
    
   
}
