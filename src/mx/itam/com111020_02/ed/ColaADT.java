
package mx.itam.com111020_02.ed;

/**
 *
 * @author guardati
 * @param <T>
 */
public interface ColaADT <T> {
    public void agrega(T nuevo);
    public T quita();
    public T consultaPrimero();
    public boolean estaVacia();
    public String imprimeCola();
}
