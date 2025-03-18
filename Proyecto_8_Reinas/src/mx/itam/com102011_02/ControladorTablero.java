/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itam.com102011_02;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mx.itam.com111020_02.colecciones.impl.arreglos.ConjuntoArreglo;


/**
 * Controlador del programa
 * @author Senior Developer: Frida Cano 192099 (fcanofal@itam.mx)
 * Junior Develeper: Alan Amaya 191165 (aamayama@itam.mx)
 */
public class ControladorTablero extends Interfaz  {
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor de la ventana.
     * @param title     El titulo de la ventana
     * @throws HeadlessException 
     */
    public ControladorTablero(String title) throws HeadlessException {
        super(title);
        
        /**
         * Método escuchador del boton <code>Ejecutar</code>
         */
        ejecutar.addActionListener(new ejecutarListener());
        
    }

    /**
     * Clase Listener del botón <code>Ejecutar</code>
     */
    private class ejecutarListener implements ActionListener {

        /**
         * Método actionPerformed del escuchador del botón.
         * @param e     Objeto tipo <code>ActionEvent</code>
         */
        @Override
        public void actionPerformed(ActionEvent e){
            int posiciones = (int)pos.getSelectedItem();
            
            vaciarTablero();
            ConjuntoArreglo posSol = EvaluadorSoluciones.nReinasSol(posiciones);
            
            insertarReinas(posSol.toArray());
            filas.setText("1 2 3 4 5 6 7 8");
            soluciones.setText(EvaluadorSoluciones.imprimeConjunto(posSol));
        }
    }
    
    /**
     * Coloca las reinas en el tablero de acuerdo a la solución dada.
     * @param a Arreglo con las posiciones de las reinas que se van a colocar
     */
    private void insertarReinas(Object[] a){
	Image img = (new ImageIcon(getClass().getResource("reina-blanca.png"))).getImage(); //BORRAR 
	ImageIcon imi= (new ImageIcon(img.getScaledInstance(45, 45, Image.SCALE_SMOOTH) ));
        
        for(int i = 0; i < 8; i++){
            tablero[i+1][(int)a[i]+1].setIcon(imi);
        }
    }
    
    /**
     * Limpia el tablero antes de cada llamada.
     */
    private void vaciarTablero(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                 tablero[i][j].setIcon(null);
            }
        }
    }
    
    public static void main(String[] args) {
        ControladorTablero tablero = new ControladorTablero("Problema 8 reinas");
    }
  
}
