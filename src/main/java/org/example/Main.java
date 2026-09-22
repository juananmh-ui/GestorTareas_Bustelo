package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Listado lista = new Listado();
        int opcion = 0;

        System.out.println("Bienvenido al gestor de tareas");

        do {
            System.out.println("\n1. Agregar tarea");
            System.out.println("2. Ver tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Filtrar tareas por prioridad");
            System.out.println("6. Guardar tareas en un archivo");
            System.out.println("7. Salir");
            System.out.println("Ingrese la opción deseada:");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Introduzca un número");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la tarea a agregar:");
                    String descripcion = sc.nextLine();

                    System.out.println("Ingrese la prioridad (ALTA, MEDIA o BAJA):");
                    String textoPrioridad = sc.nextLine().toUpperCase();

                    try {
                        Prioridad prioridad = Prioridad.valueOf(textoPrioridad);
                        lista.agregarTarea(descripcion, prioridad);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Prioridad inválida");
                    }
                    break;

                case 2:
                    lista.verTareas();
                    break;

                case 3:
                    System.out.println("Ingrese el número de la tarea a completar:");
                    int indexCompletada = sc.nextInt();
                    sc.nextLine();
                    lista.marcarCompletada(indexCompletada - 1);
                    break;

                case 4:
                    System.out.println("Ingrese el número de la tarea a eliminar:");
                    int indexEliminar = sc.nextInt();
                    sc.nextLine();
                    lista.eliminarTarea(indexEliminar - 1);
                    break;

                case 5:
                    System.out.println("Ingrese la prioridad que quiere buscar:");
                    String prioridadBuscada = sc.nextLine().toUpperCase();

                    try {
                        Prioridad prioridad = Prioridad.valueOf(prioridadBuscada);
                        lista.filtrarPorPrioridad(prioridad);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Prioridad inválida");
                    }
                    break;

                case 6:
                    lista.guardarTareas();
                    break;

                case 7:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 7);

        sc.close();
    }
}

