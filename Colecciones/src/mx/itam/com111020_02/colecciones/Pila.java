/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com111020_02.colecciones;

import java.util.Collection;

/**
 * Interfaz básica para implementar el TDA Pila
 * @param <E> Tipo parametrizado de los elementos que guarda la pila
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public interface Pila <E> extends Collection<E>{
    
    /**
     * Inserta un nuevo elemento en la cabeza de la Pila
     * @param nuevoObjeto   El objeto que se va a agregar
     * @return <code>true</code> si el objeto fue insertado exitosamente;
     * <code>false</code> en otro caso
     */
    boolean push(E nuevoObjeto);
    
    /**
     * Elimina el elemento que se encuentra en la cabeza
     * @return El objeto que fue quitado de la arreglo o
     * <code> null</code>  si la arreglo está vacia
     */
    E pop();
    
    /**
     * Elimina consecutivamente una cantidad dada de elementos 
     * de la pila
     * @param n El número de elementos que se quieren quitar
     * @return <code>true</code> si los elementos se eliminaron correctamente y
     * <code>false</code> en caso contrario.
     */
    boolean multiPop(int n);
    
    /**
     * Regresa el primer objeto sin modificar la pila
     * @return El objeto que se encuentra en la cabeza de la pila
     */
    E peek();
    
    
}
