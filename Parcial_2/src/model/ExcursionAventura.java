/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class ExcursionAventura extends Excursion {
    private int nivelDificultad; 
    private double seguroAdicional; 

    // Constructor
    public ExcursionAventura(String titulo, double precioBase, int cupoMaximo, int nivelDificultad, double seguroAdicional) {
        super(titulo, precioBase, cupoMaximo);
        if (nivelDificultad < 1 || nivelDificultad > 5) {
            throw new IllegalArgumentException("El nivel de dificultad debe estar entre 1 y 5.");
        }
        if (seguroAdicional < 0) {
            throw new IllegalArgumentException("El costo del seguro adicional no puede ser negativo.");
        }
        this.nivelDificultad = nivelDificultad;
        this.seguroAdicional = seguroAdicional;
    }

    @Override
    public double calcularPrecioFinal() {
        return (getPrecioBase() * (1 + 0.1 * nivelDificultad)) + seguroAdicional;
    }
    
     @Override
    public boolean realizarReserva(String cliente) {
        if (cliente == null || cliente.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio.");
        }
        return agregarCliente(cliente); 
    }

    public String consejosSeguridad() {
        switch (nivelDificultad) {
            case 1: return "Nivel 1 Muy Fácil. Mantén una buena hidratación.";
            case 2: return "Nivel 2: Fácil. No camines solo, mantén el grupo.";
            case 3: return "Nivel 3: Moderado. Evita la fatiga, descansa regularmente.";
            case 4: return "Nivel 4: Difícil. Monitorea las condiciones físicas del grupo.";
            case 5: return "Nivel 5: Muy Difícil. Asegúrate de estar en buena condición física.";
            default: return "Nivel de dificultad no válido.";
        }
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        if (nivelDificultad < 1 || nivelDificultad > 5) {
            throw new IllegalArgumentException("El nivel de dificultad debe estar entre 1 y 5.");
        }
        this.nivelDificultad = nivelDificultad;
    }

    public double getSeguroAdicional() {
        return seguroAdicional;
    }

    public void setSeguroAdicional(double seguroAdicional) {
        if (seguroAdicional < 0) {
            throw new IllegalArgumentException("El costo del seguro adicional no puede ser negativo.");
        }
        this.seguroAdicional = seguroAdicional;
    }
}


