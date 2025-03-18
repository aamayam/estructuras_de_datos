/*
 * The MIT License
 *
 * Copyright 2020 Alan Amaya Martinez.
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

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * La interfaz de la calculadora con los elementos que va a contener
 * @author Alan Amaya
 */
public class VistaCalculadora extends JFrame{
    
    private static final long serialVersionUID = 1L;
    
    protected JTextField mainV;
    protected JPanel screen,r1,r2, r3, r4,r5,r6;
    protected JButton CE,C,parA,parC;
    protected JButton b7,b8,b9,div;
    protected JButton b4,b5,b6,mult;
    protected JButton b1,b2,b3, resta;
    protected JButton b0,bPunto,bIgual,bSuma;
    protected JButton mod,rec,pot2, divR;
    
    /**
     * Constructor de la clase VistaCalculadora. Se construyen los 
     * elementos de la ventana y se configura la interfaz.
     * @param title El título de la ventana principal
     * @throws HeadlessException 
     */
    public VistaCalculadora(String title) throws HeadlessException {
        super(title);
        
        Font font = new Font("Monospaced",Font.BOLD,24);
        
        mainV = new JTextField();
        mainV.setEditable(false);
        mainV.setFont(font);
        mainV.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));        
        screen = new JPanel(new GridLayout(1,1));
        
        Color w = new Color(183,183,164);
        Color bg1 = Color.WHITE;
        Color bg2 = new Color(211, 229, 231);
        Color bg3 = new Color(150, 229, 243);
        
        r6 = new JPanel (new GridLayout(1,4));
        r6.setBackground(bg1);
        mod = new JButton ("mod");
        mod.setBackground(w);
        mod.setBorderPainted(false);
        rec = new JButton ("Rec");
        rec.setToolTipText("Recuperar la expresión anterior");
        rec.setBackground(bg3);
        rec.setBorderPainted(false);        
        pot2 = new JButton("^n");
        pot2.setBackground(w);
        pot2.setBorderPainted(false);
        divR = new JButton("div");
        divR.setBackground(w);
        divR.setBorderPainted(false);
        
        r1 = new JPanel (new GridLayout(1,4));
        r1.setBackground(bg1);
        CE = new JButton("CE");
        CE.setBackground(new Color(80, 183, 202));
        CE.setBorderPainted(false);
        C = new JButton("C");
        C.setBackground(w);
        C.setBorderPainted(false);
        parA = new JButton("(");
        parA.setBackground(w);
        parA.setBorderPainted(false);
        parC = new JButton(")");
        parC.setBackground(w);
        parC.setBorderPainted(false);
        
        r2 = new JPanel (new GridLayout(1,4));
        r2.setBackground(bg1);
        b7 = new JButton("7");
        b7.setBackground(Color.WHITE);        
        b7.setBorderPainted(false);          
        b8 = new JButton("8");
        b8.setBackground(Color.white);        
        b8.setBorderPainted(false);
        b9 = new JButton("9");
        b9.setBackground(Color.white);
        b9.setBorderPainted(false);
        div = new JButton("/");
        div.setBackground(w);
        div.setBorderPainted(false);
        
        r3 = new JPanel (new GridLayout(1,4));
        r3.setBackground(bg1);
        b4 = new JButton ("4");
        b4.setBackground(Color.white);
        b4.setBorderPainted(false);
        b5 = new JButton ("5");
        b5.setBackground(Color.white);
        b5.setBorderPainted(false);
        b6 = new JButton ("6");
        b6.setBackground(Color.white);
        b6.setBorderPainted(false);
        mult = new JButton ("x");
        mult.setBackground(w);
        mult.setBorderPainted(false);
        
        r4 = new JPanel (new GridLayout(1,4));
        r4.setBackground(bg1);
        b1 = new JButton("1");
        b1.setBackground(Color.white);
        b1.setBorderPainted(false);
        b2 = new JButton("2");
        b2.setBackground(Color.white);
        b2.setBorderPainted(false);
        b3 = new JButton("3");
        b3.setBackground(Color.white);
        b3.setBorderPainted(false);
        resta = new JButton("-");
        resta.setBackground(w);
        resta.setBorderPainted(false);
        
        r5 = new JPanel (new GridLayout(1,4));
        r5.setBackground(bg1);
        b0 = new JButton("0");
        b0.setBackground(Color.WHITE);
        b0.setBorderPainted(false);
        bPunto = new JButton(".");
        bPunto.setBackground(w);
        bPunto.setBorderPainted(false);
        bIgual = new JButton("=");
        bIgual.setBackground(new Color(158, 220, 231));
        bIgual.setBorderPainted(false);
        bSuma = new JButton("+");
        bSuma.setBackground(w);
        bSuma.setBorderPainted(false);
                
        Border b = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border bo2 = BorderFactory.createEmptyBorder(5, 5, 0, 5);
        Border bo3 = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        Border bo4 = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);        
        
        screen.add(mainV);        
        screen.setBorder(b);
        screen.setBackground(bg1);
        
        r1.add(CE);
        r1.add(C);
        r1.add(parA);
        r1.add(parC);
        r1.setBorder(bo2);
        r1.setCursor(handCursor);
        
        r2.add(b7);
        r2.add(b8);
        r2.add(b9);
        r2.add(div);
        r2.setBorder(bo3);
        r2.setCursor(handCursor);
        
        r3.add(b4);
        r3.add(b5);
        r3.add(b6);
        r3.add(mult);
        r3.setBorder(bo3);
        r3.setCursor(handCursor);
        
        r4.add(b1);
        r4.add(b2);
        r4.add(b3);
        r4.add(resta);
        r4.setBorder(bo3);
        r4.setCursor(handCursor);
        
        r5.add(b0);
        r5.add(bPunto);
        r5.add(bIgual);
        r5.add(bSuma);
        r5.setBorder(bo4);
        r5.setCursor(handCursor);
        
        r6.add(pot2);
        r6.add(divR);
        r6.add(mod);
        r6.add(rec);
        r6.setBorder(bo3);
        r6.setCursor(handCursor);
        
        this.add(screen);        
        this.add(r1);
        this.add(r6);
        this.add(r2);
        this.add(r3);
        this.add(r4);
        this.add(r5);
        
        this.setBounds(460, 110, 400, 550);
        this.setLayout(new GridLayout(7,1));        
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        VistaCalculadora uno = new VistaCalculadora("Calculadora v1.10");
    }
}
