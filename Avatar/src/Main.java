import Modelo.*;
import Excepciones.EnergiaInsuficienteException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<Personaje> listaPersonajes = new ArrayList<>(); // Lista de todos los personajes creados
    private static Scanner scanner = new Scanner(System.in);  // Scanner para el teclado


    public static void main(String[] args) {
        int opcion = 0;

        // Menu principal
        do {
            System.out.println("\n=== Menu de Personajes ===");
            System.out.println("1. Crear Personaje");
            System.out.println("2. Simular ataque ");
            System.out.println("3. Guardar Personajes en Archivo (.txt)");
            System.out.println("4. Mostrar Personajes");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        menuCrearPersonaje();
                        break;
                    case 2:
                        simularAtaque();
                        break;
                    case 3:
                        guardarEnArchivo();
                        break;
                    case 4:
                        mostrarPersonajes();
                        break;
                    case 5:
                        System.out.println("¡Hasta luego! Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            }
        } while (opcion != 5); // Repite hasta que el usuario elija salir
    }

    private static void menuCrearPersonaje() {
        System.out.println("\n--- Nuevo Personaje ---"); // Solicita datos generales
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nación: ");
        String nacion = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("Energía Inicial (0-100): ");
        int energia = Integer.parseInt(scanner.nextLine());
        System.out.println("¿El personaje está vivo? (1. Sí / 2. No): ");
        boolean estaVivo = Integer.parseInt(scanner.nextLine()) == 1;

        // Menú de tipos de personaje
        System.out.println("Tipo de personaje:");
        System.out.println("1. No Maestro");
        System.out.println("2. Maestro Agua");
        System.out.println("3. Maestro Fuego");
        System.out.println("4. Maestro Tierra");
        System.out.println("5. Maestro Aire");
        System.out.print("Opción: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        // Crear No Maestro
        if (tipo == 1) {
            System.out.print("Estilo de Combate (ej. Búmeran, Espada): ");
            String estilo = scanner.nextLine();
            listaPersonajes.add(
                    new NoMaestro(nombre, nacion, genero, edad, estaVivo, energia, estilo)  // Agrega personaje a la lista
            );
            System.out.println("¡No Maestro creado con éxito!");

        } else {
            System.out.print("Nivel de Dominio (1-10): ");
            int nivel = Integer.parseInt(scanner.nextLine());
            switch (tipo) {
                case 2:
                    listaPersonajes.add(new MaestroAgua(nombre, nacion, genero, edad, estaVivo, energia, nivel) {});
                    System.out.println("¡Maestro Agua creado con éxito!");
                    break;
                case 3:
                    listaPersonajes.add(new MaestroFuego(nombre, nacion, genero, edad, estaVivo, energia, nivel) {});
                    System.out.println("¡Maestro Fuego creado con éxito!");
                    break;
                case 4:
                    listaPersonajes.add(new MaestroTierra(nombre, nacion, genero, edad, estaVivo, energia, nivel) {});
                    System.out.println("¡Maestro Tierra creado con éxito!");
                    break;
                case 5:

                    listaPersonajes.add(new MaestroAire(nombre, nacion, genero, edad, estaVivo, energia, nivel) {});
                    System.out.println("¡Maestro Aire creado con éxito!");
                    break;
                default:
                    System.out.println("Tipo de maestro no válido.");
            }
        }
    }

    private static void simularAtaque() {
        if (listaPersonajes.isEmpty()) { // Verifica si existen personajes
            System.out.println("No hay personajes registrados para atacar.");
            return;
        }
        mostrarPersonajes(); // Muestra personajes disponibles
        System.out.print("Selecciona el número del personaje que va a atacar: ");
        int indice = Integer.parseInt(scanner.nextLine()) - 1; // Ajusta índice porque las listas empiezan en 0
        if (indice >= 0 && indice < listaPersonajes.size()) { // Verifica rango válido
            Personaje p = listaPersonajes.get(indice);

            try {
                // Verifica tipo del personaje y ejecuta ataque
                if (p instanceof NoMaestro) {
                    ((NoMaestro) p).atacar();
                } else if (p instanceof MaestroAgua) {
                    ((MaestroAgua) p).atacar();
                } else if (p instanceof MaestroFuego) {
                    ((MaestroFuego) p).atacar();
                } else if (p instanceof MaestroTierra) {
                    ((MaestroTierra) p).atacar();
                } else if (p instanceof MaestroAire) {
                    ((MaestroAire) p).atacar();
                }
            } catch (EnergiaInsuficienteException e) {
                System.out.println("No tienes suficiente energía " + e.getMessage()); // Captura excepción si no hay suficiente energía
            }
        } else {
            System.out.println("Fuera de rango.");
        }
    }

    // Guarda los personajes en personajes.txt
    private static void guardarEnArchivo() {
        if (listaPersonajes.isEmpty()) { //Verifica si hay personajes
            System.out.println("No hay personajes que guardar.");
            return;
        }

        String nombreArchivo = "personajes.txt";

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo)) // BufferedWriter para escribir archivo
        ) {
            writer.write("=== LISTA DE PERSONAJES EN EL SISTEMA ===\n");
            for (Personaje p : listaPersonajes) {
                writer.write(
                        "Nombre: " + p.getNombre() + " | Nación: " + p.getNacion() + " | Edad: " + p.getEdad() + " | Energía: " + p.getEnergia() + " | Estado: " + (p.EstaVivo() ? "Vivo" : "Fallecido") + "\n");
            }
            System.out.println(
                    "¡Datos guardados exitosamente en '" + nombreArchivo + "'!");
        } catch (IOException e) {
            System.out.println(
                    "Hubo un error al escribir en el archivo: " + e.getMessage());
        }
    }

    private static void mostrarPersonajes() {
        if (listaPersonajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        System.out.println("\n--- LISTA DE PERSONAJES ---");
        for (int i = 0; i < listaPersonajes.size(); i++) {

            Personaje p = listaPersonajes.get(i);
            String tipoClase = "Personaje";

            if (p instanceof NoMaestro) {
                tipoClase = "No Maestro";
            } else if (p instanceof MaestroAgua) {
                tipoClase = "Maestro Agua";
            } else if (p instanceof MaestroFuego) {
                tipoClase = "Maestro Fuego";
            } else if (p instanceof MaestroTierra) {
                tipoClase = "Maestro Tierra";
            } else if (p instanceof MaestroAire) {
                tipoClase = "Maestro Aire";
            }
            // Muestra información del personaje
            System.out.println((i + 1) + ". " + p.getNombre() + " [" + tipoClase + "] " + "- Energía: " + p.getEnergia());
        }
    }
}