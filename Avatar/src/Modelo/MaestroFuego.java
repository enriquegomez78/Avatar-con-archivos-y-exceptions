package Modelo;

import Excepciones.EnergiaInsuficienteException;

// Personajes que dominan el fuego.
public abstract class MaestroFuego extends MaestroUnElemento {

    public MaestroFuego(String nombre, String nacion, String genero, int edad, boolean estaVivo, int energia, int nivelDeDominio) {
        super(nombre, nacion, genero, edad, estaVivo, energia, nivelDeDominio); // Llama al constructor de la clase padre
    }

    public void atacar() throws EnergiaInsuficienteException {
        if (this.energia < 10) {  // Verifica si tiene suficiente energía
            throw new EnergiaInsuficienteException(); // Lanza excepción si no tiene energía suficiente
        }

        System.out.println(this.nombre + " lanza una ráfaga de bolas de fuego!");
        this.energia -= 20;  // Reduce energía después del ataque
        System.out.println("Energía restante de " + this.nombre + ": " + this.energia);  // Muestra la energía restante
    }
}