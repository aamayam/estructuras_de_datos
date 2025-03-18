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
package mx.itam.com102011_02;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;

/**
 * Interfaz gráfica del programa
 * @author Senior Developer: Frida Cano 192099 (fcanofal@itam.mx)
 * Junior Develeper: Alan Amaya 191165 (aamayama@itam.mx)
 */
public class Interfaz extends JFrame{
    private static final long serialVersionUID = 1L;
    
    /**
     * Panel principal de la ventana
     */
    protected JPanel p;
    
    /**
     * Etiquetas de titulos y del tablero
     */
    protected JLabel lab1, tablero[][], lSol, labFilas, labColumnas;
    
    /**
     * ComboBox con las opciones para la posicion de la primera reina
     */
    protected JComboBox pos;
    
    /**
     * Ejecuta el programa y devuelve la solución así como una visualización 
     * de la misma
     */
    protected JButton ejecutar;
    
    protected JTextArea soluciones, filas;
    
    /**
     * Constructor de la interfaz gráfica
     * @param title     El titulo de la ventana
     * @throws HeadlessException 
     */
    public Interfaz(String title)throws HeadlessException {
        super (title);
        
        p = new JPanel();
        
        getContentPane().add(p);
        
        SpringLayout sp = new SpringLayout();
        p.setLayout(sp);
        
        lab1 = new JLabel ("Elegir las coordenadas de la primera reina:");
        p.add(lab1);
        sp.putConstraint(SpringLayout.NORTH, lab1, 40, SpringLayout.NORTH, p);
        sp.putConstraint(SpringLayout.WEST, lab1, 15, SpringLayout.WEST, p);
        
        
        Object [] posin = new Integer[8];
        for(int i=0;i<8;i++)
            posin[i]=i+1;
        pos = new JComboBox(posin);
        p.add(pos);
        sp.putConstraint(SpringLayout.NORTH, pos, 37, SpringLayout.NORTH, p);
        sp.putConstraint(SpringLayout.WEST, pos, 270, SpringLayout.NORTH, p);
        sp.putConstraint(SpringLayout.EAST, pos, 320, SpringLayout.NORTH, p);
        
        ejecutar = new JButton("Ejecutar");
        p.add(ejecutar);
        sp.putConstraint(SpringLayout.NORTH, ejecutar, 37, SpringLayout.NORTH, p);
        sp.putConstraint(SpringLayout.WEST, ejecutar, 350, SpringLayout.NORTH, p);
        sp.putConstraint(SpringLayout.EAST, ejecutar, 450, SpringLayout.NORTH, p);
        
        
        tablero = new JLabel[9][9];
        int y = 80;
        String matriz[][]= new String[9][9];
	
	
        for(int i=0;i<9;i++){
                int x = 30;
                for(int j=0;j<9;j++){
                        if(i == 0 && j != 0){
                            matriz[i][j]="";
                            tablero[i][j]=new JLabel("  "+(j)+"  ");
                        }else if (j==0 && i!=0){
                            matriz[i][0]="";
                            tablero[i][0]=new JLabel(""+(i)+"");
                            
                        }else {
                            if(j == 0 && i==0){
                                matriz[i][j]="";
                                tablero[i][j]=new JLabel("");
                            }else{
                                matriz[i][j]="";
                                tablero[i][j]=new JLabel("");
                                tablero[i][j].setBorder(new LineBorder(Color.black,1,true) );
                                if((i%2 == 0 && j%2 != 0) || (i%2 != 0 && j%2 == 0)){
                                    tablero[i][j].setBackground(Color.black);
                                    tablero[i][j].setOpaque(true);
                                } 
                            }
                        }
                        tablero[i][j].setLocation(x,y);
                        tablero[i][j].setSize(50,50);
                        x=x+50;
                        getContentPane().add(tablero[i][j]);
                }
                y+=50;
        }
        
        
        lSol = new JLabel("Posibles soluciones:");
        p.add(lSol);
        sp.putConstraint(SpringLayout.SOUTH, lSol, -100, SpringLayout.SOUTH, p);
        sp.putConstraint(SpringLayout.WEST, lSol, 45, SpringLayout.WEST, p);
        
        
        labColumnas = new JLabel("Columnas: ");
        p.add(labColumnas);
        sp.putConstraint(SpringLayout.SOUTH, labColumnas, -40, SpringLayout.SOUTH, p);
        sp.putConstraint(SpringLayout.WEST, labColumnas, 120, SpringLayout.WEST, p);
        
        soluciones = new JTextArea();
        p.add(soluciones);
        soluciones.setFont(new Font("Monospace", 1, 18));
        sp.putConstraint(SpringLayout.SOUTH, soluciones, -40, SpringLayout.SOUTH, p);
        sp.putConstraint(SpringLayout.WEST, soluciones, 215, SpringLayout.WEST, p);
        sp.putConstraint(SpringLayout.EAST, soluciones, 400, SpringLayout.WEST, p);
        
        
        labFilas = new JLabel("Filas: ");
        p.add(labFilas);
        sp.putConstraint(SpringLayout.SOUTH, labFilas, -70, SpringLayout.SOUTH, p);
        sp.putConstraint(SpringLayout.WEST, labFilas, 120, SpringLayout.WEST, p);
        
        filas = new JTextArea();
        p.add(filas);
        filas.setFont(new Font("Monospace", 1, 18));
        sp.putConstraint(SpringLayout.SOUTH, filas, -70, SpringLayout.SOUTH, p);
        sp.putConstraint(SpringLayout.WEST, filas, 215, SpringLayout.WEST, p);
        sp.putConstraint(SpringLayout.EAST, filas, 400, SpringLayout.WEST, p);
        
        this.setIconImage(new ImageIcon(getClass().getResource("icono-reina-blanca.png")).getImage());        
        this.setBounds(450, 50, 550, 700);
        this.add(p);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args) {
        Interfaz prueba = new Interfaz("HELP!!!!");
    }
}
