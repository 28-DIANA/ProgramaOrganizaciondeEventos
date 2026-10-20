/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organizadoreventos;

/**
 *
 * @author Estudiantes
 */

public class Graduacion extends Reserva implements Recordatorio {

    private double recargoServicios;

    public Graduacion(String codigo, String cliente,
                      int invitados, int horas,
                      double recargoServicios) {

        super(codigo, cliente, invitados, horas);

        if (recargoServicios < 0) {
            throw new IllegalArgumentException(
                    "El recargo no puede ser negativo.");
        }

        this.recargoServicios = recargoServicios;
    }

    @Override
    public double calcularCosto() {
        return getInvitados() * 30000.0
                + getHoras() * 80000.0 + recargoServicios;
    }

    @Override
    public String obtenerDescripcion() {
        return "Graduación con servicios de grado.";
    }

    @Override
    public boolean puedeRealizarseEn(String sede) {
        return sede != null
                && (sede.equalsIgnoreCase("Auditorio")
                || sede.equalsIgnoreCase("Salon Elegante"));
    }

    @Override
    public void enviarRecordatorio() {
        System.out.println(
                "Recordatorio enviado para la graduación de "
                + getCliente());
    }
}