package Modelo;

import Excepciones.EnergiaInsuficienteException;

// Para personajes que controlan un solo elemento.
public abstract class MaestroUnElemento extends Personaje {

    public MaestroUnElemento(String nombre, String nacion, String genero, int edad, boolean estaVivo, int energia, int nivelDeDominio) {
        super(nombre, nacion, genero, edad, estaVivo, energia); // Envía atributos al constructor de Personaje
    }

}

