/*
 * The MIT License
 *
 * Copyright 2021 Alan Amaya 191165 (aamayama@itam.mx) .
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
package mx.itam.com111020_02.ed;
import mx.itam.com111020_02.colecciones.Cola;
import mx.itam.com111020_02.colecciones.impl.eenlazada.ColaEnlazada;
/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class prueba2 {
    
    public static <T> boolean cuenta(ColaA c, T obj, int n){
        boolean res = true;
        ColaA<T> aux = new ColaA<>();
               
        try{
            copiaCola(c,aux);
            int cont = 0;
            while (!aux.estaVacia() || cont < n){
                if(aux.consultaPrimero().equals(obj))
                    cont++;
                else
                    aux.quita();
        }
        
        if(cont != n)
            res = false;
        }catch(ExcepcionColeccionVacia e){
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    
    public static void copiaCola(ColaA a, ColaA b){
        
    }
}
