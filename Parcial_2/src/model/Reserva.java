/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author joaqh
 */
import java.io.Serializable;
import java.time.LocalDateTime;

public class Reserva implements Serializable{
    private static final long serialVersionUID = 1L;
    private static int contadorId = 1;
    
    private int idReserva;
    private int idExcursion; 
    private String cliente; 
    private LocalDateTime fechaReserva; 
    private double precio;
    private boolean pagoConfirmado; 

    
    public Reserva(int idExcursion, String cliente, double precio) {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        
         this.idReserva = ++contadorId;
        this.idExcursion = idExcursion;
        this.cliente = cliente;
        this.fechaReserva = LocalDateTime.now(); 
        this.precio = precio;
        this.pagoConfirmado = false; 
    }

    
    public boolean confirmarPago() {
        if (!pagoConfirmado) {
            pagoConfirmado = true;
            return true; 
        }
        return false; 
    }

    public String detalleReserva() {
        return "Reserva ID: " + idReserva + "\n" +
                "ID Excursion: " + idExcursion + "\n" +
                "Cliente: " + cliente + "\n" +
                "Fecha de Reserva: " + fechaReserva + "\n" +
                "Precio: $" + precio + "\n" +
                "Pago Confirmado: " + (pagoConfirmado ? "Si" : "No");
    }

    public int getIdReserva() {
        return idReserva;
    }
    
    
    public int getIdExcursion() {
        return idExcursion;
    }

    public void setIdExcursion(int idExcursion) {
        this.idExcursion = idExcursion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        this.cliente = cliente;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public boolean isPagoConfirmado() {
        return pagoConfirmado;
    }

    public void setPagoConfirmado(boolean pagoConfirmado) {
        this.pagoConfirmado = pagoConfirmado;
    }
}

