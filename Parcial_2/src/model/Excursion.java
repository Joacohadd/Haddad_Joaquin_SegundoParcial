/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Excursion implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorId = 0;

    private int id;
    private String titulo;
    private double precioBase;
    private int cupoMaximo;
    private transient List<String> clientes; 
    private List<String> actividades;

    // Constructor
    public Excursion(String titulo, double precioBase, int cupoMaximo) {
        if (titulo == null || titulo.length() < 3) {
            throw new IllegalArgumentException("El titulo debe tener al menos 3 caracteres.");
        }
        if (cupoMaximo < 0) {
            throw new IllegalArgumentException("El cupo maximo no puede ser un numero negativo.");
        }
        this.id = ++contadorId;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.cupoMaximo = cupoMaximo;
        this.clientes = new ArrayList<>();
        this.actividades = new ArrayList<>();
    }

    public abstract boolean realizarReserva(String cliente);

    public abstract double calcularPrecioFinal();

    protected boolean agregarCliente(String cliente) {
        if (getCuposDisponibles() > 0) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }

    public int getCuposDisponibles() {
        return cupoMaximo - clientes.size();
    }

    public List<String> getClientes() {
        return new ArrayList<>(clientes);
    }

    public String mostrarResumen() {
        return "Excursión ID: " + id +
               "\nTítulo: " + titulo +
               "\nPrecio Base: $" + precioBase +
               "\nPrecio Final: $" + calcularPrecioFinal() +
               "\nCupo Máximo: " + cupoMaximo +
               "\nCupos Disponibles: " + getCuposDisponibles() +
               "\nActividades: " + actividades;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void agregarActividad(String actividad) {
        if (actividad != null && !actividad.isEmpty()) {
            actividades.add(actividad);
        }
    }
     public List<String> getActividades() {
        return actividades; 
    }
}


