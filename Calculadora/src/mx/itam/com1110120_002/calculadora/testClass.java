/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya.
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
package mx.itam.com1110120_002.calculadora;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import mx.itam.com111020_02.colecciones.impl.arreglos.PilaArreglo;

/**
 * Esta clase contiene los métodos que le dan la funcionalidad a la calculadora
 * @author Alan Amaya (191165)
 */
public class testClass {
    
    /**
     * Crea un arreglo de tipo <code>String</code> con los operadores y operandos
     * de la expresión
     * @param expr  la expresión ingresada
     * @return      un arreglo que respresenta la expresión
     */            
    public static String[] toArray(String expr){
        String[] expAb;
        int size = expr.length();
        expAb = new String[size];        
        int i = 0;
        int index = 0;
        boolean prevIsOperator = false;
        
        while(i < size){
            if(expr.charAt(i)=='('){
                if(i>0 && expr.charAt(i-1)==')'){
                    expAb[index] = "*";
                    index++;
                    expAb[index] = "(";
                    index++;
                    prevIsOperator = true;
                }
                else if(i>0 && isOperand(String.valueOf(expr.charAt(i-1)))){
                    expAb[index] = "*";
                    index++;
                    expAb[index] = "(";
                    index++;
                    prevIsOperator = true;
                }else if(i>0 && isOperator(String.valueOf(expr.charAt(i-1)))){
                    expAb[index] = "(";
                    index++;
                    prevIsOperator = true;
                }else if(i==0){
                    expAb[index]="(";
                    index++;
                }else {
                    expAb[index] = "*";
                    index++;
                    expAb[index] = "(";
                    index++;
                    prevIsOperator = true;
                }
            }else if(expr.charAt(i)==')'){
                expAb[index] = ")";
                index++;
                prevIsOperator = false;
            }else if(expr.charAt(i)=='.'){
                if(i==0 || isOperator(String.valueOf(expr.charAt(i-1)))){
                    int j = i+1;
                    String s = "0.";                    
                    while(j<size && isOperand(String.valueOf(expr.charAt(j)))){                        
                        s += String.valueOf(expr.charAt(j));
                        j++;                    
                    }
                    
                    i += (j-i)-1;
                    expAb[index] = s;
                    prevIsOperator = false;
                    index++;                                        
                }else if(!isOperand(String.valueOf(expr.charAt(i+1)))){
                    expAb[index]="!";
                    index++;
                }
            }else if(isOperand(String.valueOf(expr.charAt(i)))){
                int j = i;
                String s = "";       
                boolean throwError = true;
                int k=-1;
                while(j<size && isOperand(String.valueOf(expr.charAt(j)))){
                    if(expr.charAt(j)=='.'){                        
                        k=j;
                    }
                    s += String.valueOf(expr.charAt(j));
                    j++;                    
                }
                if(k==j-1)
                    throwError = false;
                
                if(throwError){
                    i += (j-i)-1;
                }else{
                    i=size;
                    expAb[0]="*";
                }
                
                expAb[index] = s;
                prevIsOperator = false;
                index++;
            }else if(i==0 && expr.charAt(i)=='-'){
                String s = "-";
                int j = i + 1;
                while(j<size && isOperand(String.valueOf(expr.charAt(j)))){
                    s += String.valueOf(expr.charAt(j));
                    j++;
                }
                i += (j-i)-1;
                expAb[index] = s;
                index++;
            }else if(expr.charAt(i)!='-'){
                if(expr.charAt(i)=='d' || expr.charAt(i)=='m'){
                    String s = expr.substring(i, i+3);
                    expAb[index] = s;
                    index++;
                    i = i+2;
                    prevIsOperator = true;                    
                }else{                    
                    expAb[index] = String.valueOf(expr.charAt(i));
                    index++;
                    prevIsOperator = true;
                }
            }else if(prevIsOperator && expr.charAt(i)=='-'){
                String s = "-";
                int j = i + 1;
                while(j<size && isOperand(String.valueOf(expr.charAt(j)))){
                    s += String.valueOf(expr.charAt(j));
                    j++;
                }
                i += (j-i)-1;
                expAb[index] = s;
                index++;
            }else if(!prevIsOperator && expr.charAt(i)=='-'){
                expAb[index] = "-";
                index++;
            }
            i++;
        }
        
        expAb = actLength(expAb);
        
        return expAb;
    }
    
    /**
     * Evalua si el <code>String</code> dado es un operando
     * @param cad   el valor que se va a evaluar
     * @return      <code>true</code> si la expresión es un operando y
     *  <code>false</code> en caso contrario
     */
    public static boolean isOperand(String cad){
        if(cad.equals("."))
            return true;
        try{
            int num = Integer.parseInt(cad);
        }catch (Exception e){
            try{
                double num = Double.parseDouble(cad);
            }catch(Exception i){
                return false;                
            }
        }
        
        return true;
    }
    
    /**
     * Evalua si el <code>String</code> dado es un operador
     * @param cad   el valor que se va a evaluar
     * @return      <code>true</code> si la expresión es un operador y
     *  <code>false</code> en caso contrario
     */
    public static boolean isOperator(String cad){
        if(isOperand(cad))
            return false;
        else{
            switch (cad){
                case "+":
                    return true;                       
                case "-":
                    return true;                    
                case "/":
                    return true;                    
                case "*":
                    return true;
                case "div":
                    return true;
                case "mod":
                    return true;
                case "^":
                    return true;
                case "d":
                    return true;
                case "v":
                    return true;
                default:
                    return false;
            }            
        }
    }
    
    private static String imprimeArreglo(String[] expA, int ind){
        int i;
        StringBuilder cad = new StringBuilder();
        for(i=0;i<ind;i++){
            cad.append(expA[i]).append("\n");
        }
        
        return cad.toString();
    }
    
    /**
     * Evalua si hay operadores cuya aparición sea innecesaria. Por ejemplo, un
     * signo + que indique que la expresión es positiva
     * @param cad   El <code>String</code> que se quiere evaluar
     * @return      Un <code>String</code> que representa la cadena reducida 
     */
    public static String reduceExp(String cad){
        String red = "";
        int i;
        boolean prevIsOp = true;
        
        if(cad.charAt(0)=='+'){
            cad = cad.substring(1, cad.length());
        }
        
        for(i=0;i<cad.length();i++){
            if(prevIsOp && cad.charAt(i)=='+'){
                if(cad.charAt(i-1)==')')
                red += cad.charAt(i);
            }                
            else{
                red += cad.charAt(i);
                if(isOperand(String.valueOf(cad.charAt(i))))
                    prevIsOp = false;
                else
                    prevIsOp = true;
            }
        }
        
        return red;
    }
    
    /**
     * Este método evalua el arreglo con la expresion en busqueda de algun error 
     * de sintaxis
     * @param exp   Un arreglo de tipo <code>String</code> con la expresión a 
     * evaluar
     * @return  <code>true</code> si la cadena está bien evaluada o 
     * <code>false</code> en caso contrario.
     */
    public static boolean evaluador(String[] exp){
        int size = exp.length;
        int i;
        
        if(size==1 && exp[0]!=null)
            return false;
        
        if(isOperator(exp[size-1]))
            return false;
        
        if(exp[0].equals("-") || exp[0].equals("+"))
            ;
        else if(isOperator(exp[0]))
            return false;
        
        for(i=1;i<size;i++){
            if(!exp[i].equals("-") && isOperator(exp[i]) && isOperator(exp[i-1]))
                return false;                                
        }
        
        if(!evaluadorParentesis(exp))
            return false;
        
        return true;
    }
    
    /**
     * Evalua los parentesis de la expresión, si los hay, para validar que estén
     * correctamente balanceados
     * @param exp   Un arreglo de tipo <code>String</code> con la expresión a
     * evaluar
     * @return      <code>true</code> si los parentesis están correctamente
     * balanceada y <code>false</code> en caso contrario.
     */
    private static boolean evaluadorParentesis(String[] exp){
        int n = exp.length;
        int i;
        PilaArreglo pila = new PilaArreglo();
        
        for(i=0;i<n;i++){
            if(exp[i].equals("("))
                pila.push("(");
            else if(exp[i].equals(")")){
                if(pila.peek()==null)
                    return false;
                else
                    pila.pop();
            }
        }
        if(!pila.isEmpty())
            return false;
        
        return true;
    }
    
    /**
     * Reduce el arreglo para que solo incluya elementos no nulos
     * @param exp   El arreglo que se quiere reducir
     * @return      El nuevo arreglo reducido
     */
    public static String[] actLength(String[] exp){
        int l = exp.length;
        int n=0;
        int i;
        while(n<l && exp[n]!=null){
            n++;
        }
        
        String[] nuevo = new String[n];
        for(i=0;i<n;i++){
            nuevo[i]=exp[i];
        }
        
        return nuevo;
    }
    
    /**
     * Convierte la expresión del arreglo dado a una nueva expresión en notación
     * postfija
     * @param expr  El arreglo con la expresión que se va a convertir
     * @return      El arreglo con la expresión en notación postfija
     */
    public static String[] infix2postfix(String[] expr){
        int n = expr.length,i;
        PilaArreglo pila = new PilaArreglo();
        String[] postfixExp = new String[n+2]; 
        int index=0;
        
        pila.push("(");
        expr = addParentesisFinal(expr);
        n++;
        
        for(i=0;i<n;i++){
            if(isOperand(expr[i])){
                postfixExp[index]=expr[i];
                index++;
            }else if(expr[i].equals("(")){
                pila.push("(");
            }else if(isOperator(expr[i])){
                String t = (String) pila.peek();
                
                while(isOperator(t) && precedence(t)>=precedence(expr[i])){
                    pila.pop();
                    postfixExp[index]=t;
                    index++;
                    t = (String) pila.peek();
                }
                
                pila.push(expr[i]);
            }else if(expr[i].equals(")")){
                String o = (String) pila.pop();
                
                while(!o.equals("(")){
                    postfixExp[index]=o;
                    index++;
                    o = (String) pila.pop();
                }
            }
        }
                
        return postfixExp;
    }
    
    /**
     * Evalua la expresión en notación postfija para dar un resultado final
     * @param expPost   El arreglo con la expresion a evaluar
     * @return          Un <code>String</code> con el resultado de la expresión
     */
    public static String evaluaExp(String[] expPost){
        PilaArreglo pila = new PilaArreglo();
        
        
        for(String c: expPost){
            if(isOperand(c))
                pila.push(c);
            else if(isOperator(c)){
                String op1 = (String) pila.pop();
                String op2 = (String) pila.pop();
                
                String ret = evaluateOp(op2,op1,c);
                pila.push(ret);
            }
        }     
                
        return (String) pila.pop();
    }
    
    /**
     * Evalua un sección de la expresión que consta de dos operandos y un 
     * operador
     * @param op1   El primer operando
     * @param op2   El segundo operando
     * @param c     El operador
     * @return      Un <code>String</code> con el resultado de la operación
     */
    private static String evaluateOp(String op1, String op2, String c){
        String ret = "1";
                
        switch (c) {
            case "^":
                {
                    double o1 = Double.parseDouble(op1);
                    double o2 = Double.parseDouble(op2);
                    ret = String.valueOf(Math.pow(o1, o2));
                    break;
                }
            case "mod":
                {
                    int o1 = Integer.parseInt(op1);
                    int o2 = Integer.parseInt(op2);
                    ret = String.valueOf(Math.floorMod(o1, o2));
                    break;
                }
            case "div":
                {
                    int o1 = Integer.parseInt(op1);
                    int o2 = Integer.parseInt(op2);
                    ret = String.valueOf(Math.floorDiv(o1, o2));
                    break;
                }
            default:
                String expresion = op1 + c + op2;
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                try{
                    Object ev = engine.eval(expresion);
                    ret = String.valueOf(ev);
                }catch (ScriptException se){
                    
                }
                break;
        }
                        
        return ret;
    }
    
    /**
     * Calcula la precedencia de un operador según la jerarquía de las 
     * operaciones 
     * @param op    El operador 
     * @return      Un dato tipo <code>int</code> con la precedencia del
     * operador
     */
    private static int precedence(String op){
        int precedence;
        switch (op){
            case "^":
                precedence = 3;
                break;
            case "mod":
                precedence = 2;
                break;
            case "div":
                precedence = 2;
                break;
            case "*":
                precedence = 2;
                break;
            case "/":
                precedence = 2;
                break;
            case "+":
                precedence = 1;
                break;
            case "-":
                precedence = 1;
                break;
            default:
                precedence = -1;
                break;
        }
        
        return precedence;
    }
    
    /**
     * Agrega un parentesis al final de la expresión
     * @param exp   El arreglo con la expresión 
     * @return      El nuevo arreglo modificado
     */
    private static String[] addParentesisFinal(String[] exp){
        int n = exp.length+1;
        String[] nuevo = new String[n];
        int i;
        
        for(i=0;i<n;i++){
            if(i==n-1){
                nuevo[i]=")";
            }else{
                nuevo[i]=exp[i];
            }
        }
        
        return nuevo;
    }
    
    /**
     * Resuelve la expresión dada en un <code>String</code>
     * @param cad   El <code>String</code> con la expresión a resolver
     * @return      Un <code>String</code> con la solución
     */
    public static String resolve(String cad){
        String [] a = toArray(cad);
        String [] b = actLength(infix2postfix(a));
        String res = evaluaExp(b);
        
        return res;
    }
    
    public static void main(String[] args) {
//        System.out.println(isOperand("-145.23"));
//        System.out.println(isOperator("34"));
        String expr = "2.5(1/9)";
        String tst = "1*4-(4/5+7)*3";
        String [] a = toArray(expr);
//        
        System.out.println(imprimeArreglo(a,a.length));
//        
//        System.out.println("\n\n-----\n"+a.length);
        
        System.out.println(reduceExp(expr));
        
        System.out.println(evaluador(a));
//        
//        String [] b = actLength(infix2postfix(a));
//        
//        System.out.println(imprimeArreglo(b,b.length));
//        
//        System.out.println(evaluaExp(b));
        
        System.out.println(resolve(expr));
    }
    
}
