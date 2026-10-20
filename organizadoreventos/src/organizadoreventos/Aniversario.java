/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organizadoreventos;

/**
 *
 * @author Estudiantes
 */

public class Aniversario extends Reserva {

    public Aniversario(String codigo, String cliente,
                       int invitados, int horas) {

        super(codigo, cliente, invitados, horas);
    }

    @Override
    public double calcularCosto() {
        return getInvitados() * 25000.0
                + getHoras() * 60000.0;
    }

    @Override
    public String obtenerDescripcion() {
        return "Celebración de aniversario.";
    }

    @Override
    public boolean puedeRealizarseEn(String sede) {
        return sede != null
                && sede.equalsIgnoreCase("Hacienda");
    }
}
