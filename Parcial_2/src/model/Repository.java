/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author joaqh
 */
public interface Repository<T> {
    
    void add(T entity);
    void remove(int id);
    Optional<T> findById(int id); 
    List<T> findBy(Predicate<T> criterio);
    List<T> getAll();
    static <T> Repository<T> loadFromFile(String filePath) {    
        throw new UnsupportedOperationException("Método no implementado en la interfaz.");
    }
    boolean save(T entity);

}
