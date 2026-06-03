/*
Materia: Topicos Avanzados de programación
Reto 5: Programación concurrente e hilos
Nombre completo: Fernando Jeovany Frausto Cortes
Fecha de elaboración: 28/05/2026
Nombre del Asesor: Andrés Espinal Jiménez
 */
package proyecto_carrera_atletica;
public class Runner {
    private String name; //creacion de variables
    private int speed;

    public Runner(String name) {
        this.name = name;
        // Se genera un número aleatorio entre 0 y 30
        this.speed = (int) (Math.random() * 31); 
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}