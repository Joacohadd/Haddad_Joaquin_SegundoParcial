/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import model.ExcursionAventura;
import model.ExcursionRepository;
import model.GestorExcursiones;
import model.Reserva;

/**
 *
 * @author joaqh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Test 1-1");

        GestorExcursiones gestor = new GestorExcursiones("excursiones.dat");

        ExcursionAventura excursion = new ExcursionAventura("Rafting en el Rio Claro", 1500.0, 10, 3, 200.0);
        System.out.println(excursion.getId() + ", \"" + excursion.getTitulo() + "\", " + excursion.getPrecioBase() + ", " + excursion.getCupoMaximo() + ", " + excursion.getNivelDificultad() + ", " + excursion.getSeguroAdicional());

        boolean agregado = gestor.agregarExcursion(excursion);

        if (agregado) {
            System.out.println("Excursion de tipo Aventura agregada exitosamente con ID " + excursion.getId() + ".");
        } else {
            System.out.println("Error al agregar la excursion.");
        }

        System.out.println("Test 1-2");

        try {

            ExcursionAventura excursion_2 = new ExcursionAventura("Excursión en la Montaña", 800.0, -5, 2, 100.0);
        } catch (IllegalArgumentException e) {

            System.out.println("Excepción lanzada: \"" + e.getMessage() + "\"");
        }

        System.out.println("Test 1-3");
        try {
            ExcursionAventura excursion_3 = new ExcursionAventura("", 1000.0, 15, 3, 150.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción lanzada: \"" + e.getMessage() + "\"");
        }

        System.out.println("Test 1-4");
        try {
            ExcursionAventura excursion_4 = new ExcursionAventura("Ra", 800.0, 10, 3, 100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción lanzada: \"" + e.getMessage() + "\"");
        }

        System.out.println("Test 1-5");
        ExcursionAventura excursion_5 = new ExcursionAventura("Rafting en el Río Claro", 1500.0, 10, 3, 200.0);
        System.out.println("Precio Final: " + excursion.calcularPrecioFinal());

        System.out.println("Test 1-6");
        ExcursionAventura excursion_6 = new ExcursionAventura("Rafting en el Río Claro", 1500.0, 10, 3, 200.0);
        excursion.agregarActividad("Navegar el rio");
        excursion.agregarActividad("Instruccion sobre seguridad");
        System.out.println("Actividades agregadas correctamente: " + excursion.getActividades());

        System.out.println("Test 2-1");
        ExcursionAventura excursion_7 = new ExcursionAventura("Rafting en el Río Claro", 1500.0, 10, 3, 200.0);
        Reserva reserva = new Reserva(excursion.getId(), "Carlos Pérez", 1500.0);
        boolean reservaRealizada = excursion.realizarReserva("Carlos Pérez");

        if (reservaRealizada) {
            System.out.println("Reserva realizada con exito para el cliente Carlos Perez.");
        } else {
            System.out.println("Error al realizar la reserva.");
        }

        System.out.println("Test 2-2");
        ExcursionAventura excursion_8 = new ExcursionAventura("Rafting en el Río Claro", 1500.0, 1, 3, 200.0); // Solo 1 cupo
        excursion_8.realizarReserva("Carlos Pérez");

        reservaRealizada = excursion_8.realizarReserva("Ana García");

        if (!reservaRealizada) {
            System.out.println("No hay cupos disponibles para la excursion.");
        } else {
            System.out.println("Reserva realizada con exito para el cliente Ana García.");
        }

    }
}
