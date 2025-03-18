/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com102011_02;

import mx.itam.com111020_02.colecciones.impl.arreglos.ConjuntoArreglo;

/**
 * Contiene los métodos de la funcionalidad del programa. 
 * @author Senior Developer: Frida Cano 192099 (fcanofal@itam.mx)
 * Junior Develeper: Alan Amaya 191165 (aamayama@itam.mx)
 */
public class EvaluadorSoluciones {
    
    /**
     * 
     * @param col   Columna donde se va a colocar a la primera reina
     * @return      Un conjunto con las valores ordenados de las columanas que
     * representan la solución; cada columna asociada con su indice (fila)
     */
    public static ConjuntoArreglo nReinasSol(int col){        
        ConjuntoArreglo filasOcp = new ConjuntoArreglo();
        ConjuntoArreglo columnasOcp = new ConjuntoArreglo();
        int [] sol = new int [8];
                
        
        filasOcp.add(0);
        columnasOcp.add(col-1);
        sol[0]=col-1;
                       
        columnasOcp = nReinasRec(1,filasOcp,columnasOcp,sol);
        
        return columnasOcp;
    }
    
    /**
     * Evalua si la la posición actual es 'segura'
     * @param x1    La fila de la primera reina
     * @param y1    La columna de la primera reina
     * @param x2    La fila actual
     * @param y2    La columna actual
     * @return  <code>true</code> si la posición está amenazada y <code>false</code>
     * si la posición no está amenazada (es segura).
     */
    public static boolean revisaDiagonal(int x1, int y1, int x2, int y2){
        return (Math.abs(x1-x2)-Math.abs(y1-y2))==0;
    }
    
    /**
     * Método recursivo para encontrar la solución.
     * @param nivel Indica el nivel (fila) actual que se está evaluando.
     * @param filas Conjunto con las filas ya ocupadas.
     * @param columnas  Conjunto con las columnas ya ocupadas.
     * @param sol   Arreglo con las soluciones hasta ahora encontradas (Columnas).
     * @return  El conjunto de Columnas ocupadas.
     */
    public static ConjuntoArreglo nReinasRec(
            int nivel,
            ConjuntoArreglo filas, 
            ConjuntoArreglo columnas,            
            int[]sol
    ){
        if(nivel==8)
            ;
        else{
            int j;
            for(j=0;j<8;j++){
                if(evaluaPosicion(nivel,j,filas,columnas,sol)){
                    filas.add(nivel);
                    columnas.add(j);
                    sol[nivel]=j;                    
                    nReinasRec(nivel+1,filas,columnas,sol);
                    if(buscaCero(sol)!=7 && sol[7]!=0)
                        break;
                }                                 
                
            }  
            if(j==8){
                filas.remove(nivel-1);
                columnas.remove(sol[nivel-1]);                
            }
        }
        
        return columnas;
    }
    
    /**
     * Evalua si la posición actual es segura.
     * @param x Fila que se va a evaluar.
     * @param y Columna que se va a evaluar. 
     * @param filas Conjunto con las filas ya ocupadas.
     * @param column    Conjunto con las columnas ya ocupadas.
     * @param sol   Arreglo con las soluciones actuales (Columnas).
     * @return  <code>true</code> si la posición es segura y <code>false</code>
     * en caso contrario.
     */
    public static boolean evaluaPosicion(
            int x, 
            int y,            
            ConjuntoArreglo filas,
            ConjuntoArreglo column,
            int [] sol
    ){
        boolean estadoDiag = true;
        
        // REVISA LA DIAGONAL CON TODAS LAS REINAS ANTERIORMENTE COLOCADAS
        // SI LA REINA ACTUAL NO SE ENCUENTRA EN ALGUNA DIAGONAL DE LAS
        // ANTERIORES REINAS, ENTONCES estadoDiag = TRUE
        for(int i=0;i<x;i++)
            if(revisaDiagonal(i,sol[i],x,y))
                estadoDiag = false; 
        
        if(estadoDiag && !filas.contains(x) && !column.contains(y))
            return true;
        
        return false;
    }
    
    /**
     * Imprime el conjunto solución.
     * @param c Conjunto solución que se va a imprimir.
     * @return Un <code>String</code> que representa el conjunto solución.
     */
    public static String imprimeConjunto(ConjuntoArreglo c){
        StringBuilder cad = new StringBuilder();
        Object[] arreglo = c.toArray();
        
        for(Object e: arreglo){
            cad.append((int)e +1).append(" ");
        }
        
        return cad.toString();
    }
    
    /**
     * Busca un cero en el arreglo solución. Se parte del supuesto de que 
     * siempre habrá al menos un 0.
     * @param array El arreglo que contiene las soluciones encontradas
     * @return El indice donde se encuentra el 0.
     */
    public static int buscaCero(int[]array){
        int index = -1;        
        int i=0;
        
        while(i<8 && array[i]!=0){
            i++;
        }
        
        index = i;
        
        return index;
    }
    
 }

    
