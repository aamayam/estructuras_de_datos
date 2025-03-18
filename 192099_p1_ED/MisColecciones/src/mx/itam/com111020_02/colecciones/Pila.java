/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com111020_02.colecciones;

import java.util.Collection;

/**
 *
 * Interfaz básica para implementar el TDA Pila
 * 
 * Esta interface es compatible con  el marco de trabajo de colecciones de Java
 * 
 * @param <E> Tipo parametrizado de los elementos que guarda la pila
 * 
 * @author Frida CANO 192099
 */
public interface Pila<E> extends Collection<E> {
    /**
     * 
     * @param nuevoelemento
     * @return 
     */
    boolean push(E nuevoelemento);
    
    
    /**
     * Elimina el elemento que se encuentra en la cabeza de la pila
     * 
     * @return El objeto que fue quitado
     */
    E pop();
    
    
    /**
     * Regresa el objeto que se encuentra en la cabeza de la pila
     * 
     * @return El objeto que se encuentra en la cabeza de la pila
     */
    E peek();
    
    boolean multiPop(int n);
}
