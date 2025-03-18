/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

import java.util.Scanner;
import java.lang.Exception;
import mx.itam.com111020_02.colecciones.impl.arreglos.PilaArreglo;

/**
 *
 * @author Alan Amaya (191165)
 */
public class Parcial1 {
    
    /**
     * Este metodo devuelve una cadena vacia si los perentesis de la cadena
     * dada están correctamente balanceados
     * @param cadena : La cadena que se va a evaluar
     * @return Un cadena vacia si esta bien balanceada o una descripcion de
     * que parentesis no están balanceados
     */
    public static String RevisaParentesisMultiples (String cadena){
        int n = cadena.length();
        PilaArreglo aux = new PilaArreglo(n);
        int i;
        
        for(i=0;i<n;i++){
            switch (cadena.charAt(i)){
                case '(':
                    aux.push(')');
                    break;
                case '[':
                    aux.push(']');
                    break;
                case '{':
                    aux.push('}');
                    break;
                default:
//                    if(cadena.charAt(i)==')' || cadena.charAt(i)==']' || cadena.charAt(i)=='}'){
//                        if(aux.peek()==null)
//                            return false;
//                        else if(aux.peek().equals(cadena.charAt(i)))
//                            aux.pop();
//                        else
//                            return false;
//                    }                
                    if(cadena.charAt(i)==')'){
                        if(aux.peek()==null)
                            return "Parentesis no están balanceados (falta '(' )";
                        else if(aux.peek().equals(cadena.charAt(i)))
                            aux.pop();
                        else
                            return "Parentesis no estan balanceados (falta '(' )";                        
                    }else if(cadena.charAt(i)==']'){
                        if(aux.peek()==null)
                            return "Corchetes no están balanceados (falta '[' )";
                        else if(aux.peek().equals(cadena.charAt(i)))
                            aux.pop();
                        else
                            return "Corchetes no estan balanceados (falta '[' )";                        
                    }else if(cadena.charAt(i)=='}'){
                        if(aux.peek()==null)
                            return "Llaves no están balanceadas (falta '{' )";
                        else if(aux.peek().equals(cadena.charAt(i)))
                            aux.pop();
                        else
                            return "Llaves no estan balanceados (falta '{' )";                        
                    }
                    
                    
            }
        }
        
        if(!aux.isEmpty()){
            if(aux.peek().equals(')'))
                return "Parentesis no están balanceados (falta ')' )";
            else if(aux.peek().equals(']'))
                return "Parentesis no están balanceados (falta ']' )";
            else if(aux.peek().equals('}'))
                return "Parentesis no están balanceados (falta '}' )";
            
        }            
        
        return "";
    }
    
    /**
     * Este método convierte un numero entero dado a su expresión binaria
     * @param num : El número que se quiere convertir en binario
     * @return Un <code>String</code> con la expresión binaria del numero
     */
    public static String convierteBinario (int num){
        StringBuilder cad = new StringBuilder();
        if(num<0){
            cad.append('-');
            num *= -1;
        }
        int divisor = num;
        int cociente = 1;
        int i;        
        PilaArreglo aux = new PilaArreglo();
        
        while(cociente > 0){
            cociente = divisor / 2;
            aux.push(divisor%2);
            divisor = cociente;
        }
        
        int n = aux.size();
        for(i=0;i<n;i++){
            cad.append(aux.pop());
        }
        
        return cad.toString();
    }
    
    /**
     * Cuenta el numero de veces que aparece un número en la pila
     * @param pila La pila en la que se va a buscar
     * @param n el número que se va a buscar
     * @return el numero de veces que aparece el numero
     */
    public static int cuentaRepetido(PilaArreglo pila, int n){         
        PilaArreglo aux = new PilaArreglo();
        boolean end = true;
        int res = 0, i=0;
        
        while(end){
            int a = n + 1;
            try{
                a = (int) pila.pop();
            }catch (Exception e){
                end = false;
                i--;
            }
            aux.push(a);
            if(a == n)
                res++;
            i++;
        }
        
        for(int j=0;j<i;j++){
            pila.push(aux.pop());
        }
        
        return res;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int res;
        PilaArreglo test = new PilaArreglo();
        test.push(1);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(4);
        test.push(5);
        test.push(5);
        test.push(6);
        test.push(6);
        test.push(7);
        test.push(8);
        test.push(9);       
        
        do{
            System.out.println("BIENVENIDO A MI EXAMEN PARCIAL!!!");
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. Ejercicio 4");
            System.out.println("5. Salir");
            System.out.println("Opción: ");
            res = scan.nextInt();
            
            if(res > 0){
                switch (res){
                    case 1:
                        System.out.println("<--- EJERCICIO 1 --->");
                        System.out.println("<-- Tipo de Dato:   -->");
                        System.out.println("Conjunto finito de elementos con"
                                + " operaciones definidas\n");
                        System.out.println("<-- Tipo de Dato Abstracto:     -->");
                        System.out.println("Conjunto de elementos que "
                                + "representan un objeto matemático o de la "
                                + "vida real, con operaciones específicas "
                                + "definidas\n");
                        System.out.println("<-- Estructura de datos:    -->");
                        System.out.println("Se refiere a la organización de "
                                + "un programa según sus elementos internos "
                                + "como son: clases, métodos, interfaces\n");
                        
                        System.out.println("<--- FIN EJERCICIO 1 --->");
                        break;
                    case 2:
                        System.out.println("<--- EJERCICIO 2 --->");
                        String cadena;
                        String resp;
                        System.out.println("Ingresa una cadena para evaluar: ");
                        cadena = scan.next();
                        resp = RevisaParentesisMultiples(cadena);
                        
                        if(resp.isEmpty())
                            System.out.println("La cadena está correctamente balanceada\n\n");
                        else
                            System.out.println(resp+"\n\n");
                        
                        System.out.println("<--- FIN EJERCICIO 2 --->");
                        
                        break;
                    case 3:
                        System.out.println("<--- EJERCICIO 3 --->");
                        int num;
                        System.out.println("Ingresa un número entero: ");
                        try{
                            num = scan.nextInt();
                            
                            System.out.println("La expresión binaria del numero es:");
                            System.out.println(convierteBinario(num));
                        }catch (Exception e){                            
                            System.out.println("Entrada inválida");
                        }      
                        
                        System.out.println("<--- FIN EJERCICIO 3 --->");
                        
                        break;
                    case 4:
                        System.out.println("<--- EJERCICIO 4 --->");
                        System.out.println("ingresa un numero: ");
                        try{
                            int num2 = scan.nextInt();
                            System.out.println("<-- Pila original -->");
                            for(Object m:test)
                                System.out.println(m);
                            
                            System.out.println("\n");
                        
                            System.out.println("Numero de veces que aparece"
                                + " el número es: "+cuentaRepetido(test,num2));
                        
                            System.out.println("\n<-- Pila despues del metodo -->");
                            for(Object m:test)
                                System.out.println(m);
                        }catch(Exception i){
                            System.out.println("Entrada inválida");
                        }
                        
                        System.out.println("<--- FIN EJERCICIO 4 --->");
                        
                        break;
                    case 5:
                        System.out.println("Saliendo . . .");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }while (res!=5);
        
        
    }
    
}
