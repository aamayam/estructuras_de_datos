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
package mx.itam.com111020_02.colecciones;

import java.util.Collection;

/**
 * Interfaz básica para implementar el TDA Cola
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 * @param <E>   El tipo de datos de los objetos de la colección
 */
public interface Cola<E> extends Collection<E>{
    
    /**
     * Introduce un nuevo elemento al final de la cola
     * @param elemento  El elemento agregado
     * @return (@code true) si la operación es exitosa y (@code false) en caso
     * contrario
     */
    boolean enqueue(E elemento);
    
    /**
     * Elimina el elemento que está en la cabeza de la cola
     * @return (@code true) si la operación es exitosa y (@code false) en caso
     * contrario
     */
    boolean dequeue();
    
    /**
     * Hace múltiples eliminaciones en la Cola
     * @param n El número de eliminaciones que se van a realizar
     * @return Un arreglo de tipo E con los elementos que se eliminaron.
     */
    E[] multiDequeue(int n);
    
    /**
     * Devuelve el primer elemento de la Cola
     * @return Objeto de tipo E que representa el primer elemento de la Cola
     */
    E primero();
    
    /**
     * Devuelve el último elemento de la Cola
     * @return Objeto de tipo E que representa el último elemento de la Cola
     */
    E ultimo();
    
}
