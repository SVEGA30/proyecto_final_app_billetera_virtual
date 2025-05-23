package co.edu.uniquindio.Model;

import co.edu.uniquindio.Builder.UsuarioBuilder;

public final class Usuario {
    private final String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String direccion;
    private double saldo;
    private String password;

    public Usuario(String idUsuario, String nombreCompleto, String correo,
                   String telefono, String direccion, double saldo, String password) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.saldo = saldo;
        this.password = password;
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    // Getters
    public String getIdUsuario() { return idUsuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public double getSaldo() { return saldo; }
    public String getPassword() { return password; }

    // Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}