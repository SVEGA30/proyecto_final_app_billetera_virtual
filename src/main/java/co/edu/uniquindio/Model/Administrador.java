package co.edu.uniquindio.Model;

import co.edu.uniquindio.Builder.AdministradorBuilder;

public class Administrador {
    private String idAdmin;
    private String nombre;
    private String correo;
    private String password;

    public Administrador(String idAdmin, String nombre, String correo, String password) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    // Método estático para obtener el Builder
    public static AdministradorBuilder builder() {
        return new AdministradorBuilder();
    }

    // Getters
    public String getIdAdmin() { return idAdmin; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getPassword() { return password; }
}