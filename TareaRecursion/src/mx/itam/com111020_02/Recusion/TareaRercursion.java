/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya 191165 (aamayama@itam.mx).
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
package mx.itam.com111020_02.Recusion;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class TareaRercursion {
    
    public static int numCatalanRecursivo1(int n){        
        if(n==0)
            return 1;
        else if(n==1)
            return 1;
                      
        int cat=0;
        int i;
        int m=n-1;
            
        for(i=0;i<=m;i++){
            cat+= numCatalanRecursivo1(i)*numCatalanRecursivo1(m-i);
        }       
        
        return cat;
    }
    
    public static int numCatalanRecursivo2(int n){
        if(n==0)
            return 1;
        
        int m = n-1;
        double aux = (double) (2*(2*m+1))/(m+2);
        double cat = aux*numCatalanRecursivo2(m);
        return (int)cat;
    }
    
    public static int numCatalanIterativo(int n){
        int cat = 1;
        int i;
        
        for(i=1;i<=n;i++){
            int m = i-1;
            double aux = (double) (2*(2*m+1))/(m+2);
            cat *= aux;
        }
        
        return cat;
    }
    
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
                        
        System.out.println("<---- NÚMEROS DE CATALÁN: ---->");
        try{
            System.out.print("Ingresa un entero positivo: ");             
            int n = lee.nextInt();
            
            if(n<=0)
                throw new InvalidParameterException();
            
            long inicio, fin;
            int cat;
            
            inicio = System.nanoTime();
            cat = numCatalanRecursivo1(n);
            fin = System.nanoTime();
            
            
            System.out.println("El numero de Catalán obtenido con el método 1"
                    + " recursivo de "+n+" es: " + cat);
            System.out.println("Calculado en "+(fin-inicio) + "* 10E-9 segundos");
                        
            inicio = System.nanoTime();
            cat = numCatalanRecursivo2(n);
            fin = System.nanoTime();
                        
            System.out.println("El numero de Catalán obtenido con el método 2"
                    + " recursivo de "+n+" es: " + cat);
            System.out.println("Calculado en "+(fin-inicio) + "* 10E-9 segundos"); 
            
            inicio = System.nanoTime();
            cat = numCatalanIterativo(n);
            fin = System.nanoTime();
                        
            System.out.println("El numero de Catalán obtenido con el método"
                    + " iterativo de "+n+" es: " + cat);
            System.out.println("Calculado en "+(fin-inicio) + "* 10E-9 segundos"); 
        }catch(InvalidParameterException e){
            System.out.println("El número debe ser mayor que 0");            
            System.exit(0);
        }catch(InputMismatchException o){
            System.out.println("Entrada inválida");
            System.exit(0);
        }
    }
}

