/*
Materia: Topicos Avanzados de programación
Reto 5: Programación concurrente e hilos
Nombre completo: Fernando Jeovany Frausto Cortes
Fecha de elaboración: 28/05/2026
Nombre del Asesor: Andrés Espinal Jiménez
 */
package proyecto_carrera_atletica;

public class ThreadRunner implements Runnable {
    
    private Runner runner;
    private AthleticRaceInterface ventanaPrincipal;

    public ThreadRunner(Runner runner, AthleticRaceInterface ventanaPrincipal) {
        this.runner = runner;
        this.ventanaPrincipal = ventanaPrincipal;
    }

    @Override
    public void run() {
        try {
            // Se duerme el hilo
            Thread.sleep(this.runner.getSpeed() * 1000L);
           
            ventanaPrincipal.registrarLlegada(runner.getName(), runner.getSpeed());
            
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}