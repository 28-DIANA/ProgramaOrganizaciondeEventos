/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package organizadoreventos;

/**
 *
 * @author Estudiantes
 */

public abstract class Reserva {

    private String codigo;
    private String cliente;
    private int invitados;
    private int horas;
    private EstadoReserva estado;

    public Reserva(String codigo, String cliente,
                   int invitados, int horas) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El código no puede estar vacío.");
        }

        if (cliente == null || cliente.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El cliente no puede estar vacío.");
        }

        if (invitados <= 0 || horas <= 0) {
            throw new IllegalArgumentException(
                    "Los invitados y las horas deben ser mayores que cero.");
        }

        this.codigo = codigo;
        this.cliente = cliente;
        this.invitados = invitados;
        this.horas = horas;
        this.estado = EstadoReserva.COTIZADO;
    }

    public abstract double calcularCosto();

    public abstract String obtenerDescripcion();

    public abstract boolean puedeRealizarseEn(String sede);

    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public int getInvitados() {
        return invitados;
    }

    public int getHoras() {
        return horas;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoReserva nuevoEstado) {

        if (nuevoEstado == null) {
            throw new IllegalArgumentException(
                    "El estado no puede ser nulo.");
        }

        if (estado == EstadoReserva.REALIZADO) {
            throw new IllegalStateException(
                    "Una reserva realizada no puede cambiar de estado.");
        }

        if (nuevoEstado == EstadoReserva.CANCELADO) {
            estado = nuevoEstado;
            return;
        }

        if (estado == EstadoReserva.COTIZADO
                && nuevoEstado == EstadoReserva.CONFIRMADO) {
            estado = nuevoEstado;
            return;
        }

        if (estado == EstadoReserva.CONFIRMADO
                && nuevoEstado == EstadoReserva.REALIZADO) {
            estado = nuevoEstado;
            return;
        }

        throw new IllegalStateException(
                "Transición de estado no permitida: "
                + estado + " a " + nuevoEstado);
    }

    public void mostrarResumen() {
        System.out.println("Código: " + codigo);
        System.out.println("Cliente: " + cliente);
        System.out.println("Invitados: " + invitados);
        System.out.println("Horas: " + horas);
        System.out.println("Estado: " + estado);
        System.out.println("Descripción: " + obtenerDescripcion());
        System.out.println("Costo: $" + calcularCosto());
    }
}