package co.edu.uniquindio.Builder;

import co.edu.uniquindio.Model.Administrador;

public class AdministradorBuilder {
    private String idAdmin;
    private String nombre;
    private String correo;
    private String password;

    public AdministradorBuilder idAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
        return this;
    }

    public AdministradorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AdministradorBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public AdministradorBuilder password(String password) {
        this.password = password;
        return this;
    }

    public Administrador build() {
        return new Administrador(idAdmin, nombre, correo, password);
    }
}