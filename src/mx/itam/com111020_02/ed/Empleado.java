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
 *
 * @author Alan Amaya
 */
public class Empleado extends Persona{
    
    private String puesto;
    private double sueldo;
    private String area;

    /**
     * 
     * @param puesto
     * @param sueldo
     * @param area
     * @param nombre
     * @param edad
     * @param altura
     * @param sexo 
     */
    public Empleado(String puesto, double sueldo, String area, String nombre, int edad, double altura, String sexo) {
        super(nombre, edad, altura, sexo);
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado\npuesto: ").append(puesto);
        sb.append("\nsueldo:").append(sueldo);
        sb.append("\narea:").append(area);        
        return sb.toString();
    }
    
    
}
