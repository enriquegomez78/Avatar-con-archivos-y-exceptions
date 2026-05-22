package Modelo;

import Excepciones.EnergiaInsuficienteException;

// Personajes que no controlan elementos,
public class NoMaestro extends Personaje {

    private String estiloCombate;

    public NoMaestro(String nombre, String nacion, String genero, int edad, boolean estaVivo, int energia, String estiloCombate) {
        super(nombre, nacion, genero, edad, estaVivo, energia); // Llama al constructor de la clase padre
        this.estiloCombate = estiloCombate; // Inicializa el estilo de combate
    }

    public void atacar() throws EnergiaInsuficienteException {
        if (this.energia < 10) { // Verifica si tiene suficiente energía
            throw new EnergiaInsuficienteException(); // Lanza la excepción si no tiene energía suficiente
        }
        System.out.println(this.nombre + " realiza un ataque físico usando su estilo: " + this.estiloCombate);
        this.energia -= 15; // Reduce energía después del ataque
        System.out.println("Energía restante de " + this.nombre + ": " + this.energia); // Muestra energía restante
    }

    // Getter del estilo de combate
    public String getEstiloCombate() {
        return estiloCombate;
    }

    // Setter del estilo de combate
    public void setEstiloCombate(String estiloCombate) {
        this.estiloCombate = estiloCombate;
    }
}