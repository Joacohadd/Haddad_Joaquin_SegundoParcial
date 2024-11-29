/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

public interface Serializer<T> {
    
    void guardarDatos(String filePath, List<T> data);

    List<T> cargarDatos(String filePath);
}

