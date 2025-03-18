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

/**
 * Representa la unidad fundamental de una estructura enlazada.
 * Un nodo contiene un elemento que representa su valor y una referencia a
 * otro nodo del mismo tipo.
 * 
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 * @param <E> El tipo del elemento que es el valor del nodo.
 */
public class Nodo<E> {
    
    protected E valor;
    
    protected Nodo<E> siguiente;

    public Nodo(E valor, Nodo<E> siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

    public Nodo() {
        this(null,null);
    }

    public E getValor() {
        return valor;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return valor.toString();
    }
    
    
}
