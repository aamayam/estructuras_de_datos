/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.itam.com111020_02.colecciones.impl.arreglos.PilaArreglo;

/**
 * MAIN: Primer Parcial
 * 
 * @author FRIDA CANO (192099)
 */
public class Parcial1 {
    
    public static String revisarParentesisMultiples(String cad){
        PilaArreglo pila = new PilaArreglo();
        boolean par = true;
        String res = "";
        char pk;
        int n = cad.length();
        
        for(int i = 0; i < n; ++i){
            if(cad.charAt(i) == '(' || cad.charAt(i) == '{' || cad.charAt(i) == '['){
                pila.push(cad.charAt(i));
            }
            switch (cad.charAt(i)){
                
                case ')':
                    pk = (char)pila.peek();
                    if( pk!= '('){
                        par = false;
                        res = "ERROR: Los parentesis '(' no están bien balanceados";                      
                    }else{
                        pila.pop();
                        par = true;
                    }
                    break;
                case '}':
                    pk = (char)pila.peek();
                    if(pk!= '{'){
                        par = false;
                        res = "ERROR: Los parentesis '{' no están bien balanceados";
                    }else{
                        pila.pop();
                        par = true;
                    }
                    break;
                case ']':
                    pk = (char)pila.peek();
                    if(pk!= '['){
                        par = false;
                        res = "ERROR: Los parentesis '[' no están bien balanceados";
                    }else{
                        pila.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        if(!par || pila.peek()==null){
            res = "";
        }
        return res;
    }
    
    public static StringBuilder intAbin(int num){
        PilaArreglo pila = new PilaArreglo();
        StringBuilder res = new StringBuilder();
        int n;
        int aux;
        
        while (num != 2 && num != 3){

            aux = num%2;
            
            if (aux == 0){
                pila.push("0");
            }
            else{
                pila.push("1");
            }
            num = num / 2;
        }
        if (num == 2){
           pila.push("0");
           pila.push("1");
        }
        else if (num == 3){
            pila.push("1");
            pila.push("1");
        }
        
        n= pila.size();
        for(int i = 0; i < n; ++i){
            res.append(pila.pop());
        }

        return res;
    }
    
    public static int numElemXenPila(PilaArreglo pila, int n){
        PilaArreglo pilaAux = new PilaArreglo();
        int l = pila.size();
        int res = 0;
        int m;
        
        for(int i = 0; i < l; ++i){
            m = (int)pila.pop();
            if(m == n){
                pilaAux.push(m);
                ++res;
            }
        }
        for(int j = 0; j < l; ++j){
            pila.push(pilaAux);
        }
        return res;
    }
    public static PilaArreglo convertirCadApila(String cadena){
    PilaArreglo pila = new PilaArreglo();

    for (int i = 0; i < cadena.length(); ++i){
        pila.push(cadena.charAt(i));
    }
    return pila;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Bienvenido");
       System.out.println("PRIMER EXAMEN PARCIAL");
       System.out.println();
       
       int opcion, finalizar = 0;
       int numInt, numFin = 0;
       
       do {
           System.out.println("MENÚ");
           System.out.println("1.- Conceptos básicos");
           System.out.println("2.- Revisar Parentesis Múltiples");
           System.out.println("3.- Convertir de entero a binario");
           System.out.println("4.- Cuántos elementos igual a n existen en la pila");
           System.out.println("0.- Finalizar");
           
           System.out.println("Opción");
           System.out.flush();
           
           Scanner lec;
           
           String entrada = "";
           
           lec = new Scanner(System.in);
           
            try {
                
                entrada = lec.next();
                opcion = Integer.parseInt(entrada);
            }
            
             catch (NumberFormatException numfex) { 

               opcion = -2; 

               System.out.printf("Opción %s inválida, por favor vuelva a intentar", entrada); 

               System.out.println(); 

           } 

 

           if (opcion >= 0) { 

                switch (opcion) { 

                    case 0: 

                        System.out.println("Finalizando pruebas. . ."); 

                        System.exit(0); 
                        
                    case 1:
                        
                        System.out.println("Ejercicio 1: CONCEPTOS BÁSICOS");
                        System.out.println("Tipo de Dato: ");
                        System.out.println("Es un conjunto finito de valores con ciertas operaciones");
                        System.out.println();
                        System.out.println("Tipo de Dato Abstracto: representacion de un objeto abstracto o real ");
                        System.out.println("");
                        System.out.println();
                        System.out.println("Estructura de datos: ");
                        System.out.println("Conjunto de objetos que utilizamos para implementar un TDA");   
                        System.out.println("FIN DEL EJERCICIO 1");
                        System.out.println();
                    
                    case 2: 
                        
                        System.out.println("Ejercicio 2: REVISAR SI LOS (), {} O [] DE UNA CADENA ESTÁN BALANCEADOS");
                        System.out.println("Ingrese la cadena que se va a revisar sin espacios:");
                        String cad2 = lec.next() + lec.nextLine();
                        String res = revisarParentesisMultiples(cad2);
                        if (res == ""){
                            System.out.println("La cadena está bien balanceada");
                        }else{
                            System.out.println(res);
                        }
                        System.out.println("Fin del ejercico 2");
                        System.out.println();
                        break;
                    
                    case 3:
                        
                            System.out.println("Ejercicio 3: Conversión de número entero a número binario");
                            System.out.println("Ingrese numero entero");
                            System.out.println();
                            String num = "";
                            StringBuilder res3 = new StringBuilder();
                            try {
                                num = lec.next();
                                numInt = Integer.parseInt(num);
                                res3 = intAbin(numInt);
                                System.out.println(res3);
                            }

                             catch (NumberFormatException numfex) { 

                               numInt = -2; 

                               System.out.printf("Opción %s inválida, por favor vuelva a intentar. Ingrese un número ENTERO", num); 

                               System.out.println(); 
                            }
                            
                            break;
                    case 4:
                        
                        System.out.println("Ejercicio 4: NUMERO DE ELEMENTOS N EN PILA");
                        System.out.println("La pila es:");
                        String cad4 = "1223465733338909928394822211124477";
                        int m, n;
                        PilaArreglo pila = new PilaArreglo();
                        pila = convertirCadApila(cad4);
                        for(Object e: pila){
                            System.out.println(e);
                        }
                        System.out.println("¿QUÉ ENTERO QUIERES BUSCAR?");
                        n = lec.nextInt();
                        m = numElemXenPila(pila, n);
                        System.out.println("HAY"+m+"ELEMENTOS");
                        
                        break;
                    default: 

                        System.out.println("Opción no implementada."); 

                } 

           } else 

                System.out.printf("Número de opción negativo inválido: %d", opcion); 

            

            System.out.println(); 

        } while (opcion != finalizar); 

    }
    
}
