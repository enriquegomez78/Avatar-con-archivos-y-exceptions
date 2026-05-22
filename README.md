# Avatar-con-archivos-y-exceptions

# Descripción
Este es un programa de consola desarrollado en Java basado en el universo de Avatar. El sistema permite gestionar una lista de personajes, simular ataques controlando sus niveles de energía y guardar toda la información en un archivo de texto de forma segura.

# Funcionalidades (Menú Principal)
El programa cuenta con un menú interactivo con las siguientes opciones:
1. **Crear Personaje:** Registra guerreros (No Maestros) o Maestros de Agua, Fuego, Tierra y Aire, solicitando datos como nombre, nación, edad y energía inicial.
2. **Simular Ataque:** Permite elegir un personaje de la lista para ejecutar su movimiento característico, descontando energía en el proceso.
3. **Guardar Personajes:** Exporta todos los datos del sistema a un archivo `.txt`.
4. **Mostrar Personajes:** Imprime en consola un resumen ordenado de todos los personajes registrados y su estado actual.
5. **Salir.**

# Estructura del Código
* `Modelo/`: Paquete que contiene todas las clases de los personajes (`Personaje`, `MaestroUnElemento`, `MaestroAgua`, `NoMaestro`, etc.).
* `Excepciones/`: Paquete con la excepción personalizada del juego.
* `Main.java`: Clase principal que arranca el programa, contiene el menú y controla las listas dinámicas (`ArrayList`).

# Cómo ejecutarlo
1. Clona este repositorio en tu computadora.
2. Abre el proyecto en tu IDE favorito (IntelliJ IDEA, Eclipse, VS Code, etc.).
3. Ejecuta la clase `Main.java`.
4. ¡Interactúa con el menú en la consola!

## Autor
Luis Enrique Gomez Maynez 


