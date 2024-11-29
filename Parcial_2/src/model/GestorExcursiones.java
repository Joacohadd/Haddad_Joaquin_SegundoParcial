/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joaqh
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GestorExcursiones {

    private Repository<Excursion> repository;

    public GestorExcursiones(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            // Si el archivo existe, cargar el repositorio desde el archivo.
            this.repository = new ExcursionRepository(filePath);
        } else {
            // Si no existe, inicializar con un repositorio vacío.
            this.repository = new ExcursionRepository(filePath);
        }
    }

    //Agrego una excursion y verifico que no sea nula
    public boolean agregarExcursion(Excursion excursion) {
        if (excursion == null) {
            throw new IllegalArgumentException("La excursión no puede ser nula.");
        }
        return repository.save(excursion);
    }
    
    public List<Excursion> getExcursiones() {
        return repository.getAll();
    }

    //Busco por ID
    public Optional<Excursion> buscarPorId(int id) {
        return repository.findById(id);
    }

    //Filtro excursiones usando predicate
    public List<Excursion> filtrarExcursiones(Predicate<Excursion> criterio) {
        return repository.findBy(criterio);
    }

    //Consulto el precio de las excursiones con el precio Min
    public List<Excursion> consultarExcursionesPorPrecio(double precioMin) {
        return filtrarExcursiones(excursion -> excursion.calcularPrecioFinal() >= precioMin);
    }
}
