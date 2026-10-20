/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organizadoreventos;

/**
 *
 * @author Estudiantes
 */

public class Cumpleanos extends Reserva {

    private boolean infantil;

    public Cumpleanos(String codigo, String cliente,
                      int invitados, int horas,
                      boolean infantil) {

        super(codigo, cliente, invitados, horas);
        this.infantil = infantil;
    }

    @Override
    public double calcularCosto() {
        double costoBase = getInvitados() * 20000.0
                + getHoras() * 50000.0;

        if (infantil) {
            return costoBase * 0.90;
        }

        return costoBase;
    }

    @Override
    public String obtenerDescripcion() {
        if (infantil) {
            return "Cumpleaños infantil con 10% de descuento.";
        }

        return "Celebración de cumpleaños para adultos.";
    }

    @Override
    public boolean puedeRealizarseEn(String sede) {
        return sede != null
                && (sede.equalsIgnoreCase("Salon Elegante")
                || sede.equalsIgnoreCase("Salon Infantil"));
    }
}