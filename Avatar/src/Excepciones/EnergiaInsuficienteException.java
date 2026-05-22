package Excepciones;

public class EnergiaInsuficienteException extends Exception {
    public EnergiaInsuficienteException() {
        super("¡El maestro necesita descansar y meditar!");
    }
}
