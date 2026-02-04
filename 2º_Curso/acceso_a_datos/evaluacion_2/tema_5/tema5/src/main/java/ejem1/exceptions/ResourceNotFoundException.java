package ejem1.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    // Podemos añadir detalles extra como el ID que no se encontró
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
