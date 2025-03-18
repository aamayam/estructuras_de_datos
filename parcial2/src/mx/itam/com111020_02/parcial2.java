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
package mx.itam.com111020_02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import mx.itam.com111020_02.colecciones.impl.arreglos.ConjuntoArreglo;

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class parcial2 {
    
    public static void main(String[] args) {
        System.out.println("    SEGUNDO PARCIAL");
        System.out.println("    BIENVENIDO");
        System.out.println("    ALAN AMAYA MARTÍNEZ     CU: 191165");
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        
        do{
            System.out.println("    Selecciona una opción: ");
            System.out.println("    1.- Producto Cartesiano");
            System.out.println("    2.- Union recursiva de onjuntos");
            System.out.println("    3.- Pregunta 3");
            System.out.println("    4.- Salir");
            System.out.println("    Opcion: ");
            
            try{
                opcion = scan.nextInt();
                
                if(opcion>4 || opcion<1)
                    throw new IllegalArgumentException("    Entrada inválda");
            }catch(IllegalArgumentException e){
                System.out.println("    Error:");
                System.out.println(e.getMessage()+"\n\n");                
            }catch(InputMismatchException in){
                System.out.println("    Error: ");
                System.out.println("Argumento inválido");
                System.exit(0);
            }
            
            switch(opcion){
                case 1:
                    System.out.println("    PRODUCTO CARTESIANO\n");
                    ConjuntoArreglo set1 = new ConjuntoArreglo();
                    for(int i=1;i<6;i++)
                        set1.add(i);
                    
                    ConjuntoArreglo set2 = new ConjuntoArreglo();
                    set2.add(1);
                    set2.add(2);
                    set2.add(3);
                    set2.add(4);
                    
                    System.out.println("    Primer conjunto: ");
                    System.out.println("    "+imprimeConjunto(set1));
                    System.out.println("    Segundo conjunto: ");
                    System.out.println("    "+imprimeConjunto(set2));
                    
                    System.out.println("    Producto cartesiano");
                    System.out.println("    "+imprimeConjunto(productoCartesiano(set1,set2)));
                    System.out.println("\n\n");
                    
                    break;
                case 2:
                    System.out.println("    UNION RECURSIVA\n");
                    ConjuntoArreglo set3 = new ConjuntoArreglo();
                    for(int i=1;i<6;i++)
                        set3.add(i);
                    
                    ConjuntoArreglo set4 = new ConjuntoArreglo();
                    set4.add(5);
                    set4.add(6);
                    set4.add(7);
                    set4.add(8);
                    
                    System.out.println("    Primer conjunto: ");
                    System.out.println("    "+imprimeConjunto(set3));
                    System.out.println("    Segundo conjunto: ");
                    System.out.println("    "+imprimeConjunto(set4));
                    System.out.println("    Imprimiendo union de conjuntos");
                    System.out.println("    "+imprimeConjunto(unionRec(set3,set4)));
                    System.out.println("\n\n");
                    break;
                case 3:
                    System.out.println("    PREGUNTA 3");
                    System.out.println("    El total de elementos de la cola "
                            + "se puede obtener con el siguiente algoritmo\n\n");
                    System.out.println("    if(!isEmpty()){");
                    System.out.println("        if(ultimo>primero)");
                    System.out.println("            return (ultimo-primero)+1;");
                    System.out.println("        else");
                    System.out.println("            return (arreglo.length - primero) + (ultimo+1);");
                    System.out.println("    }else");
                    System.out.println("        return 0;\n\n");
            }
            
        }while (opcion!=4);
        
    }
    
    public static ConjuntoArreglo<ArrayList<Integer>> productoCartesiano(
            ConjuntoArreglo<Integer> conjunto1, 
            ConjuntoArreglo<Integer> conjunto2
    ){
        ConjuntoArreglo<ArrayList<Integer>> res = new ConjuntoArreglo();
               
        for(int obj:conjunto1){
            for(int obj2:conjunto2){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(obj);
                temp.add(obj2);
                res.add(temp);
            }
        }
        
        return res;
    }
    
    public static ConjuntoArreglo unionRec(
            ConjuntoArreglo conjunto1, 
            ConjuntoArreglo conjunto2
    ){
        ConjuntoArreglo res = new ConjuntoArreglo();
        res.addAll(conjunto1);
        Object [] array = conjunto2.toArray();
        int n = conjunto2.size();
        
                        
        res = unionRecursiva(array, res, n);
        
        return res;
    }
    
    private static ConjuntoArreglo unionRecursiva(            
            Object [] array,
            ConjuntoArreglo res,
            int n
    ){
        if(n==0)
            return res;
        if(n==1){
            if(!res.contains(array[0]))
                res.add(array[0]);
        }else{
            if(!res.contains(array[n-1]))
                res.add(array[n-1]);
            
            n--;
            unionRecursiva(array,res,n);
        }
        
        return res;
    }
    
    public static String imprimeConjunto(ConjuntoArreglo c){
        StringBuilder cad = new StringBuilder();
        for(Object e:c){
            cad.append(e).append(" ");
        }
        
        return cad.toString();
    }
        
}
