/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ReservaRepository implements Repository<Reserva>, Serializable {

    private static final long serialVersionUID = 1L;
    private List<Reserva> reservas; 
    private GestorPersistencia<Reserva> persistencia; 
    private String filePath; 

    
    public ReservaRepository(String filePath) {
        this.filePath = filePath;
        this.persistencia = new GestorPersistencia<>();
        this.reservas = cargarDesdeArchivo();
    }

    
    @Override
    public boolean save(Reserva entity) {
        reservas.add(entity);
        guardarEnArchivo();
        return true;
    }

    
    @Override
    public void add(Reserva entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula.");
        }
        reservas.add(entity);
        guardarEnArchivo();
    }

    
    @Override
    public Optional<Reserva> findById(int id) {
        return reservas.stream()
                .filter(reserva -> reserva.getIdReserva() == id)
                .findFirst();
    }

    
    @Override
    public List<Reserva> findBy(Predicate<Reserva> predicate) {
        return reservas.stream()
                .filter(predicate)
                .toList();
    }

    
    @Override
    public List<Reserva> getAll() {
        return new ArrayList<>(reservas); 
    }

    
    @Override
    public void remove(int id) {
        reservas.removeIf(reserva -> reserva.getIdReserva() == id);
        guardarEnArchivo();
    }

    
    private void guardarEnArchivo() {
        persistencia.guardarDatos(filePath, reservas);
    }

    
    private List<Reserva> cargarDesdeArchivo() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return persistencia.cargarDatos(filePath);
    }
}


