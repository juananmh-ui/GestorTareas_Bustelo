package org.example;

public class Tarea {
    protected String descripcion;
    protected boolean status;
    protected Prioridad prioridad;
    public int id;

    public Tarea(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.status = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public String toString() {
        String s = "Tarea: " + this.descripcion
                + "\nStatus: " + (this.status ? "Completada" : "Pendiente")
                + "\nPrioridad: " + this.prioridad;
        return s;
    }
}


