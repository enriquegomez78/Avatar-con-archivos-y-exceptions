package Modelo;

import Excepciones.EnergiaInsuficienteException;

// Personajes que controlann el agua
public abstract class MaestroAgua extends MaestroUnElemento {

    public MaestroAgua(String nombre, String nacion, String genero, int edad, boolean estaVivo, int energia, int nivelDeDominio) {
        super(nombre, nacion, genero, edad, estaVivo, energia, nivelDeDominio); // Llama al constructor de la clase padre
    }

    public void atacar() throws EnergiaInsuficienteException {
        if (this.energia < 10) { // Verifica si tiene suficiente energía
            throw new EnergiaInsuficienteException(); // Lanza excepción si la energía es insuficiente
        }

        System.out.println(this.nombre + " lanza una poderosa bola de agua!");
        this.energia -= 20; // Reduce energía después del ataque
        System.out.println("Energía restante de " + this.nombre + ": " + this.energia); // Muestra la energía restante
    }
}