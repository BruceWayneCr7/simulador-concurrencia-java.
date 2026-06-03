# simulador-concurrencia-java.
Simulador de carrera atlética usando programación concurrente e hilos en Java.
# Simulador de Concurrencia: Carrera Atlética en Java 🏃‍♂️💻

## 📌 Descripción del Proyecto
Este proyecto es una aplicación de escritorio desarrollada en Java que simula una carrera atlética entre múltiples competidores. Su propósito principal es demostrar la implementación práctica y segura de la **programación concurrente y multihilo** en la Máquina Virtual de Java (JVM).

El sistema permite registrar hasta 5 corredores y asignarles velocidades aleatorias. Al iniciar la carrera, cada corredor es procesado en su propio hilo de ejecución de manera simultánea, garantizando la integridad de los datos en la interfaz gráfica mediante el uso de monitores y exclusión mutua.

## ⚙️ Arquitectura y Tecnologías
* **Lenguaje:** Java
* **Interfaz Gráfica:** Java Swing (`JFrame`, `JPanel`, `BoxLayout`, Manejo de Eventos)
* **Paradigma:** Programación Orientada a Objetos (POO) y Programación Concurrente.

## 🧠 Conceptos Técnicos Aplicados
1. **Implementación de `Runnable`:** Uso de la interfaz `Runnable` para separar la lógica de la tarea del hilo de ejecución, aplicando inyección de dependencias (buenas prácticas de arquitectura).
2. **Exclusión Mutua (`synchronized`):** Implementación de bloques sincronizados para prevenir condiciones de carrera (Race Conditions) al momento de que múltiples hilos intentan escribir sus resultados en la interfaz gráfica compartida.
3. **Ciclo de vida de los Hilos:** Control de estados de la JVM utilizando métodos como `Thread.sleep()` para simular el tiempo de procesamiento basado en la velocidad de cada objeto corredor.

## 🚀 Cómo ejecutar el proyecto
1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en un IDE compatible con Java (como Apache NetBeans, IntelliJ IDEA o Eclipse).
3. Ejecuta la clase principal `AthleticRaceInterface.java`.

---
*Desarrollado por Fernando Jeovany Frausto Cortés como parte de la formación en Ingeniería en Sistemas Computacionales.*
