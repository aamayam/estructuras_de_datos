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

/**
 *
 * @author Alan Amaya 191165 (aamayama@itam.mx)
 */
public class matricesAlgoritmos {
    
    public static void main(String[] args) {
        Integer [][] a = {{1,2,3},{4,5,6},{7,8,9}};
        Integer [][] b = {{1,2,3},{4,5,6},{7,8,9}};
        
        boolean est = comparaMatrices(a,b,3,3,3,3);
        if(est){
            System.out.println("Las matrices son iguales");
        }else{
            System.out.println("Las matrices no son iguales");
        }
        
        Integer [] c = {9,4,6,3,8};
        for(int e : c)
            System.out.print(e + " ");
        System.out.println("\n\n");
        corrimientosCirculares(c,5,2);
        for(int e : c)
            System.out.print(e + " ");
    }
    
    public static <T> boolean comparaMatrices(T[][]matA,T[][]matB,
            int mA, int nA, int mB, int nB){
        boolean res=true;
        if(mA!=mB || nA!=nB){
            res = false;
        }else{
            int i,j;
            i = 0;
            j = 0;
            
            while(i<mA && res){
                while(j<nA && res){
                    if(!matA[i][j].equals(matB[i][j]))
                        res = false;
                    
                    j++;
                }
                i++;
            }            
        }
        
        return res;
    }
    
    public static <T> void corrimientosCirculares(T[]a,int n,int k){
        T temp,temp2;
        int i,j;
        for(i=0;i<k;i++){
            temp = a[0];
            for(j=0;j<n;j++){                    
                if(j==0){
                    a[j]=a[n-1];
                    
                }else if(j==n-1){
                    a[j]=temp;
                }else{
                    temp2 = a[j];
                    a[j]=temp;
                    temp = temp2;
                    
                }
                    
            }
        }
    }
}
