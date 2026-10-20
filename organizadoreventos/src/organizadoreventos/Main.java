/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package organizadoreventos;

/**
 *
 * @author Estudiantes
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            reservas.add(new Boda(
                    "B001", "Laura", 100, 5, 500000));

            reservas.add(new Cumpleanos(
                    "C001", "Carlos", 30, 3, true));

            reservas.add(new Graduacion(
                    "G001", "Andres", 80, 4, 300000));

            reservas.add(new Aniversario(
                    "A001", "Maria", 40, 3));

        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear reserva: "
                    + e.getMessage());
        }

        // Mostrar todas las reservas con una sola operación.
        System.out.println("===== RESERVAS REGISTRADAS =====");

        for (Reserva reserva : reservas) {
            reserva.mostrarResumen();

            System.out.println("--------------------------");
        }

        // Cambiar estados.
        System.out.println("\n===== CAMBIOS DE ESTADO =====");

        try {
            reservas.get(0).cambiarEstado(
                    EstadoReserva.CONFIRMADO);

            reservas.get(0).cambiarEstado(
                    EstadoReserva.REALIZADO);

            System.out.println("Estado de la boda: "
                    + reservas.get(0).getEstado());

            reservas.get(1).cambiarEstado(
                    EstadoReserva.CONFIRMADO);

            System.out.println("Estado del cumpleaños: "
                    + reservas.get(1).getEstado());

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Intentar una operación inválida.
        System.out.println("\n===== PRUEBA DE ERROR =====");

        try {
            reservas.get(0).cambiarEstado(
                    EstadoReserva.CANCELADO);

        } catch (IllegalStateException e) {
            System.out.println("Operación inválida: "
                    + e.getMessage());
        }

        // Enviar recordatorios solo a reservas que tengan
        // la capacidad Recordatorio.
        System.out.println("\n===== RECORDATORIOS =====");

        for (Reserva reserva : reservas) {
            if (reserva instanceof Recordatorio) {
                ((Recordatorio) reserva).enviarRecordatorio();
            } else {
                System.out.println(
                        "La reserva de "
                        + reserva.getCliente()
                        + " no permite enviar recordatorios.");
            }
        }

        // Demostrar una cuarta modalidad sin cambiar
        // el recorrido general.
        System.out.println("\n===== NUEVA MODALIDAD =====");

        for (Reserva reserva : reservas) {
            System.out.println(
                    reserva.getCodigo() + " - "
                    + reserva.obtenerDescripcion()
                    + " - Costo: $" + reserva.calcularCosto());
        }
    }
}