# Final de Programacion Avanzada
Juego desarrollado en Java utilizando la libreria Swing

## Introducción

El juego desarrollado en ambas plataformas comprende la misma lógica de juego. 

**Los objetivos del juego son**

- Esquivar los obstáculos.
- Obtener la máxima puntuación posible.

**Reglas de juego**

- Controles:
    - El usuario puede mover el avatar con las teclas A/W/S/D siendo izquierda, arriba, abajo y derecha respectivamente.
- Puede mover el avatar dentro del espacio designado por la plataforma. Para la versión Java será toda la toda el campo de juego. En el caso de la versión de Unity es una porción del campo de juego.
- Los obstáculos son generados de forma aleatoria a lo largo del ancho del campo de juego.
- El puntaje se calcula por cada obstáculo sobrepasado.
- El juego se termina cuando el jugador toca un obstáculo y se enseña una pantalla de Game Over y el puntaje máximo alcanzado.

## Versión Java

**Desiciones de diseño**

- Se utiliza la librería Java Swing para crear los gráficos.
- No se utilizan gráficos externos para reducir la complejidad del código.
- No tiene sonidos ni música para simplificar el código.
- Se fijan 60 ciclos por segundo.
- La generación de obstáculos se hace por medio de otro hilo de procesos para demostrar como utilizar los conceptos de un sistema multi-hilo.
- Se utiliza el patrón State para manejar los distintos estados del juego.
- Se implementa el patrón Singleton para la creación del contexto del juego.