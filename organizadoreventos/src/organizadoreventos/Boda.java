/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organizadoreventos;

/**
 *
 * @author Estudiantes
 */

public class Boda extends Reserva implements Recordatorio {

    private double recargo;

    public Boda(String codigo, String cliente,
                int invitados, int horas, double recargo) {

        super(codigo, cliente, invitados, horas);

        if (recargo < 0) {
            throw new IllegalArgumentException(
                    "El recargo no puede ser negativo.");
        }

        this.recargo = recargo;
    }

    @Override
    public double calcularCosto() {
        return getInvitados() * 50000.0
                + getHoras() * 100000.0 + recargo;
    }

    @Override
    public String obtenerDescripcion() {
        return "Boda con decoración y ceremonia.";
    }

    @Override
    public boolean puedeRealizarseEn(String sede) {
        return sede != null
                && (sede.equalsIgnoreCase("Salon Elegante")
                || sede.equalsIgnoreCase("Hacienda"));
    }

    @Override
    public void enviarRecordatorio() {
        System.out.println(
                "Recordatorio enviado para la boda de "
                + getCliente());
    }
}
