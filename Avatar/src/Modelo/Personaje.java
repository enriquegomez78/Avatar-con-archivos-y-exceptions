package Modelo;


public class Personaje {

    // protected permite que las clases hijas puedan acceder directamente.
    protected String nombre;
    protected String nacion;
    protected String genero;
    protected int edad;
    protected boolean estaVivo;
    protected int energia;

    // Inicializa todos los atributos del personaje.
    public Personaje(String nombre, String nacion, String genero, int edad, boolean estaVivo, int energia) {
        this.nombre = nombre;
        this.nacion = nacion;
        this.genero = genero;
        this.edad = edad;
        this.estaVivo = estaVivo;
        this.energia = energia;
    }

    // Devuelve el nombre del personaje
    public String getNombre() {
        return nombre;
    }

    // Modifica el nombre del personaje
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve la nación del personaje
    public String getNacion() {
        return nacion;
    }

    // Modifica la nación del personaje
    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    // Devuelve el género del personaje
    public String getGenero() {
        return genero;
    }

    // Modifica el género del personaje
    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Devuelve la edad del personaje
    public int getEdad() {
        return edad;
    }

    // Modifica la edad del personaje
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Devuelve si el personaje está vivo o no
    public boolean EstaVivo() {
        return estaVivo;
    }

    // Cambia el estado de vida del personaje
    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    // Devuelve la energía del personaje
    public int getEnergia() {
        return energia;
    }

    // Modifica la energía del personaje
    public void setEnergia(int energia) {
        this.energia = energia;
    }
}