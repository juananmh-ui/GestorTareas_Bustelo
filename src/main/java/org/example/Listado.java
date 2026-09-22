package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Listado {
    protected List<Tarea> tareas;

    public Listado() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(String descripcion, Prioridad prioridad) {
        Tarea tarea = new Tarea(descripcion, prioridad);
        this.tareas.add(tarea);
        tarea.setId(tareas.indexOf(tarea) + 1);
        System.out.println("Tarea agregada con éxito.");
    }

    public void verTareas() {
        if (this.tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        System.out.println("Tareas:");

        for (int i = 0; i < this.tareas.size(); i++) {
            System.out.println("Tarea " + (i + 1) + ":");
            System.out.println(this.tareas.get(i));
        }
    }

    public void filtrarPorPrioridad(Prioridad prioridad) {
        boolean encontrada = false;

        for (int i = 0; i < this.tareas.size(); i++) {
            Tarea tarea = this.tareas.get(i);

            if (tarea.getPrioridad() == prioridad) {
                System.out.println("Tarea " + (i + 1) + ":");
                System.out.println(tarea);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No hay tareas con esa prioridad.");
        }
    }

    public void marcarCompletada(int index) {
        if (index < 0 || index >= this.tareas.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Tarea tarea = this.tareas.get(index);
        tarea.status = true;
        System.out.println("Tarea " + (index + 1) + " marcada como completada.");
    }

    public void eliminarTarea(int index) {
        if (index < 0 || index >= this.tareas.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        this.tareas.remove(index);
        System.out.println("Tarea " + (index + 1) + " eliminada.");
    }

    public void guardarTareas() {
        try {
            FileWriter archivo = new FileWriter("tareas.txt");

            for (int i = 0; i < this.tareas.size(); i++) {
                archivo.write("Tarea " + (i + 1) + ":\n");
                archivo.write(this.tareas.get(i).toString());
                archivo.write("\n\n");
            }

            archivo.close();
            System.out.println("Las tareas se han guardado en tareas.txt.");
        } catch (IOException e) {
            System.out.println("No se pudieron guardar las tareas.");
        }
    }
}
