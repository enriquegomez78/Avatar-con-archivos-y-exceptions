package Modelo;

import Excepciones.EnergiaInsuficienteException;

// Personajes que dominan el aire.
public abstract class MaestroAire extends MaestroUnElemento {

    public MaestroAire(String nombre, String nacion, String genero, int edad, boolean estaVivo, int energia, int nivelDeDominio) {
        super(nombre, nacion, genero, edad, estaVivo, energia, nivelDeDominio); // Llama al constructor de la clase padre
    }

    public void atacar() throws EnergiaInsuficienteException {
        if (this.energia < 10) { // Verifica si tiene suficiente energía
            throw new EnergiaInsuficienteException(); // Lanza excepción si no tiene energía suficiente
        }

        System.out.println(this.nombre + " crea un tornado y lo lanza!");
        this.energia -= 20; // Reduce energía después del ataque
        System.out.println("Energía restante de " + this.nombre + ": " + this.energia); //Muestra la energia restante
    }
}