/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya Martínez.
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

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * Contiene la funcionalidad de la calculadora
 * @author Alan Amaya
 */
public class CalculadoraControlador extends VistaCalculadora{       
    
    private String exp = "";
    private boolean blocked = true;
    private String recover = "";
    private String [] expA;
    
    /**
     * Constructor de la clase controladorCalculadora
     * @param title El titulo de la ventana
     * @throws HeadlessException 
     */
    public CalculadoraControlador(String title) throws HeadlessException {
        super(title);
        
        mainV.setText(exp);
        
        b0.addActionListener(new b0Listener());
        b1.addActionListener(new b1Listener());
        b2.addActionListener(new b2Listener());
        b3.addActionListener(new b3Listener());
        b4.addActionListener(new b4Listener());        
        b5.addActionListener(new b5Listener());
        b6.addActionListener(new b6Listener());
        b7.addActionListener(new b7Listener());
        b8.addActionListener(new b8Listener());
        b9.addActionListener(new b9Listener());
        parA.addActionListener(new parAListener());
        parC.addActionListener(new parCListener());
        div.addActionListener(new divListener());
        mult.addActionListener(new multListener());
        resta.addActionListener(new restaListener());
        bSuma.addActionListener(new bSumaListener());
        bPunto.addActionListener(new bPuntoListener());
        pot2.addActionListener(new pot2Listener());
        divR.addActionListener(new divRListener());
        mod.addActionListener(new modListener());
        rec.addActionListener(new recListener());
        C.addActionListener(new CListener());
        CE.addActionListener(new CEListener());
        bIgual.addActionListener(new bIgualListener());
    }
    
    /**
     * Escuchador del botón 0
     */
    private class b0Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "0";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 1
     */
    private class b1Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(blocked){
                exp = exp + "1";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 2
     */
    private class b2Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "2";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 3
     */
    private class b3Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "3";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 4
     */
    private class b4Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "4";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 5
     */
    private class b5Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "5";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 6
     */
    private class b6Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "6";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 7
     */
    private class b7Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "7";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 8
     */
    private class b8Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "8";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 9
     */
    private class b9Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "9";
            mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón -(- paréntesis
     */
    private class parAListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "(";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón -)- paréntesis
     */
    private class parCListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + ")";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón / -> división
     */
    private class divListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "/";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón * -> multiplicación
     */
    private class multListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "*";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón '-' -> resta 
     */
    private class restaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "-";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón '+' -> suma
     */
    private class bSumaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "+";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón '.' -> punto
     */
    private class bPuntoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + ".";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón '^' -> potencia
     */
    private class pot2Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "^";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 'div' 
     */
    private class divRListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "div(";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 'mod'
     */
    private class modListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(blocked){
                exp = exp + "mod(";
                mainV.setText(exp);
            }
        }
        
    }
    
    /**
     * Escuchador del botón 'rec' -> recuperar
     */
    private class recListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            exp = recover.repeat(1);
            mainV.setText(exp);
            blocked = true;
        }
        
    }
    
    /**
     * Escuchador del botón C -> borrar
     */
    private class CListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {            
            if(blocked && exp.length()>0){
                int end = exp.length()-1;              
                exp = exp.substring(0, end);
                mainV.setText(exp);        
            }
            
        }
        
    }
    
    /**
     * Escuchador del botón CE -> borrar todo
     */
    private class CEListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            exp = "";
            blocked = true;
            mainV.setText(exp);
        }
        
    }
    
    /**
     * Esta clase implementa la interface ActionListner y le da la
     * funcionalidad al botón igual(=) de la calculadora
     */
    private class bIgualListener implements ActionListener{    
           
        /**
         * Incluye toda la funcionalidad de la calculadora, evalua la
         * expresion y resuelve si se puede o indica un error en caso contrario
         * @param arg0 
         */
        @Override
        public void actionPerformed(ActionEvent arg0) {            
            recover = exp.repeat(1);
//            exp = reduceExp(exp);
            exp = testClass.reduceExp(exp);
//            expA = creaArreglo(exp);
            expA = testClass.toArray(exp);
            if(!testClass.evaluador(expA)){
                exp = "Syntax Error";
                blocked = false;
                mainV.setText(exp);
            }else{
                String res = testClass.resolve(exp);
                exp = exp + " " + "= " + res;
                mainV.setText(exp);
                blocked = false;
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        CalculadoraControlador test1 = new CalculadoraControlador("Calculadora v1.2");
    }
}
