
package mx.itam.com111020_02.ed;

/**
 *
 * @author guardati
 */
public class ExcepcionColeccionVacia extends RuntimeException{
    
    public ExcepcionColeccionVacia(){
        super("¡Colección vacía!");
    }
    
    public ExcepcionColeccionVacia(String mensaje){
        super(mensaje);
    }
    
}
