/*
 * The MIT License
 *
 * Copyright 2020 alan-.
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
 * Describe una persona
 * @author Alan Amaya (191165)
 */
public class Persona {
    private String nombre;
    private int edad;
    private double altura;
    private String sexo;
    
    /**
     * Constructor
     * 
     * @param nombre    Nombre de la persona
     * @param edad      Edad de la persona
     * @param altura    
     * @param sexo      M para masculino, F para femenino
     */
    public Persona(String nombre, int edad, double altura, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.sexo = sexo;
    }
    
    /**
     * Devuelve el nombre de la persona
     * @return  Cadena con el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modifica el nombre completo de la persona
     * @param nombre    El nuevo nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * La edad de la persona
     * @return Un entero con la edad (años) de la persona
     */
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", altura=").append(altura);
        sb.append(", sexo=").append(sexo);
        sb.append('}');
        return sb.toString();
    } 
    
}
