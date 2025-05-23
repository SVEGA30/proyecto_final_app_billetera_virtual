package co.edu.uniquindio.Builder;

import co.edu.uniquindio.Model.Usuario;

public class UsuarioBuilder {
    private String idUsuario;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String direccion;
    private double saldo = 0.0;
    private String password;

    public UsuarioBuilder idUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public UsuarioBuilder nombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public UsuarioBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public UsuarioBuilder telefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public UsuarioBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public UsuarioBuilder saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public UsuarioBuilder password(String password) {
        this.password = password;
        return this;
    }

    public Usuario build() {
        return new Usuario(idUsuario, nombreCompleto, correo, telefono, 
                         direccion, saldo, password);
    }
}