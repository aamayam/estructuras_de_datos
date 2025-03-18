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
package mx.itam.com111020_02.ed;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class pruebas<E> {
    
     public static ArrayList<Integer> generaLista(double[]a,double[]b,int n){
        int i;
        ArrayList <Integer> res = new ArrayList<>();
        
        for(i=0;i<n;i++){
            if(a[i]%b[i]==0 || b[i]%a[i]==0)
                ;
            else
                res.add(i);
        }
        
        return res;
    }
     
    public static void main(String[] args) {
//        double [] a = {20,3,23,12,44,6,32,4,2};
//        double [] b = {2,21,15,22,31,66,5,70,20};
//        
//        ArrayList <Integer> x = new ArrayList();
//        
//        x = generaLista(a,b,9);
//        
//        System.out.println(x);
        
//        int [][] c = {{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
//        System.out.println(imprimeMatriz(c,4,3));
//        invierteMatrizXRenglon(c,4);
//        System.out.println(imprimeMatriz(c,4,3));

//        int [][] d = {{14,13,0,8,0},{7,16,0,12,5},{10,0,15,6,15},{11,14,4,2,20}};
//        System.out.println(imprimeMatriz(d,4,5));
//        
//        
//        System.out.println(matrizZigzag(d,4,5));
//        
//        System.out.println(matrizZigzag2(d,4,5));

        double [][] arr = {{1,3,6,8},{4,5,9,16},{7,20,1,30},{8,6,13,0}};
        System.out.println(imprimeMatriz(arr,4,4));
        System.out.println(Arrays.toString(sumaMultiplosPorFila(arr,4,4)));
    }
    
  
    public static void invierteMatrizXRenglon(int [][] matriz, int n){
        int i = 0;
        n--;
        while(i<n){
            int[]temp = matriz[i];
            matriz[i]=matriz[n];
            matriz[n]=temp;
            i++;
            n--;
        }
    }
    
    public static String imprimeMatriz(double [][] mat, int n, int m){
        StringBuilder cad = new StringBuilder();
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++)
                cad.append(mat[i][j]).append("      ");
            cad.append("\n");
        }            
        
        return cad.toString();
    }
    
    public static String matrizZigzag(int[][]mat,int n, int m){
        StringBuilder cad = new StringBuilder();
        int i,j,valor=-1;
        
        for(i = 0;i<n;i++){
            if(valor>0)
                for(j=m-1;j>=0;j--)
                    cad.append(mat[i][j]).append(" ");
            else
                for(j=0;j<m;j++)
                    cad.append(mat[i][j]).append(" ");
            
            cad.append(" - ");
            valor*=-1;
        }
        
        return cad.toString();
    }
    
    public static String matrizZigzag2(int [][]mat,int n, int m){
        StringBuilder cad = new StringBuilder();
        int i,j;
        
        for(i = 0;i<n;i++){
            if(i%2==1)
                for(j=m-1;j>=0;j--)
                    cad.append(mat[i][j]).append(" ");
            else
                for(j=0;j<m;j++)
                    cad.append(mat[i][j]).append(" ");
            
            cad.append(" - ");
            
        }
        
        return cad.toString();
    }
    
    public static double[] sumaMultiplosPorFila(double [][] mat,int n,int m){
        double [] array = new double[n];
        int i,j;
        
        for(i=0;i<n;i++){
            double valor = mat[i][0];
            double suma = 0;
            for(j=1;j<m;j++){
                if(j%2==1 && mat[i][j]%valor==0)
                    suma+=mat[i][j];
            }
            array[i]=suma;
        }
        
        return array;                
    }
}
