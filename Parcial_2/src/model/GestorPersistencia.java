/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia<T extends Serializable> implements Serializer<T> {

    @Override
    public void guardarDatos(String filePath, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data); 
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los datos en el archivo: " + filePath, e);
        }
    }

    @Override
    public List<T> cargarDatos(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>(); 
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject(); 
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al cargar los datos desde el archivo: " + filePath, e);
        }
    }
}

