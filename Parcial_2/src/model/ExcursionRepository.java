/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joaqh
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ExcursionRepository implements Repository<Excursion>, Serializable {

    private static final long serialVersionUID = 1L;
    private List<Excursion> excursiones;
    private String filePath;

    // Constructor
    public ExcursionRepository(String filePath) {
        this.filePath = filePath;
        this.excursiones = cargarDesdeArchivo();
    }

    @Override
    public boolean save(Excursion entity) {
        excursiones.add(entity);
        guardarEnArchivo();
        return true;
    }

    @Override
    public void add(Excursion entity) {
        if (entity == null) {
            throw new IllegalArgumentException("La excursión no puede ser nula.");
        }
        excursiones.add(entity);
        guardarEnArchivo();
    }

    @Override
    public Optional<Excursion> findById(int id) {
        return excursiones.stream()
                .filter(excursion -> excursion.getId() == id)
                .findFirst();
    }

    @Override
    public List<Excursion> findBy(Predicate<Excursion> predicate) {
        return excursiones.stream()
                .filter(predicate)
                .toList();
    }

    @Override
    public List<Excursion> getAll() {
        return new ArrayList<>(excursiones);
    }

    @Override
    public void remove(int id) {
        excursiones.removeIf(excursion -> excursion.getId() == id);
        guardarEnArchivo();
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(excursiones);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar las excursiones en el archivo.", e);
        }
    }

    private List<Excursion> cargarDesdeArchivo() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Excursion>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar las excursiones desde el archivo.", e);
        }
    }
}


