/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GestorReservas {
    private Repository<Reserva> repository; 
    private int cupoMaximo; 

    // Constructor
    public GestorReservas(String filePath) {
        this.cupoMaximo = cupoMaximo;

        File file = new File(filePath);
        if (file.exists()) {
            
            this.repository = new ReservaRepository(filePath);
        } else {
            
            this.repository = new ReservaRepository(filePath);
        }
    }

    
    public boolean realizarReserva(Reserva reserva) {
        List<Reserva> reservasActuales = repository.getAll();
        if (reservasActuales.size() >= cupoMaximo) {
            return false; // No hay cupos disponibles.
        }
        repository.add(reserva); // Reserva agregada
        return true; 
    }

    
    public List<Reserva> getReservas() {
        return repository.getAll();
    }
  
    public double calcularIngresos(Predicate<Reserva> filtro) {
        return repository.findBy(filtro).stream()
                .mapToDouble(Reserva::getPrecio)
                .sum();
    }

    public double calcularIngresosTotales() {
        return calcularIngresos(Reserva::isPagoConfirmado);
    }
}

