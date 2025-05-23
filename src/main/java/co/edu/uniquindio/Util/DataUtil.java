package co.edu.uniquindio.Util;

import co.edu.uniquindio.Model.Administrador;
import co.edu.uniquindio.Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    private static DataUtil instance;
    private final List<Usuario> listaUsuarios;
    private final List<Administrador> listaAdministradores;

    private DataUtil() {
        this.listaUsuarios = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
        inicializarDatosPrueba();
    }

    public static synchronized DataUtil getInstance() {
        if (instance == null) {
            instance = new DataUtil();
        }
        return instance;
    }

    private void inicializarDatosPrueba() {
        // Usuarios de prueba con Builder
        listaUsuarios.add(Usuario.builder()
                .idUsuario("1")
                .nombreCompleto("Juan Pérez")
                .correo("juan@email.com")
                .telefono("3001234567")
                .direccion("Calle 123")
                .saldo(1000.0)
                .password("1")
                .build());

        // Administrador de prueba con Builder
        listaAdministradores.add(Administrador.builder()
                .idAdmin("admin")
                .nombre("Admin Sistema")
                .correo("admin@email.com")
                .password("admin")
                .build());
    }

    // Métodos para usuarios
    public List<Usuario> getListaUsuarios() {
        return new ArrayList<>(listaUsuarios);
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (usuario == null || existeUsuario(usuario.getIdUsuario())) {
            return false;
        }
        return listaUsuarios.add(usuario);
    }

    public boolean existeUsuario(String idUsuario) {
        return listaUsuarios.stream()
                .anyMatch(u -> u.getIdUsuario().equals(idUsuario));
    }

    public Usuario buscarUsuario(String idUsuario, String password) {
        return listaUsuarios.stream()
                .filter(u -> u.getIdUsuario().equals(idUsuario) && 
                            u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    // Métodos para administradores
    public List<Administrador> getListaAdministradores() {
        return new ArrayList<>(listaAdministradores);
    }

    public Administrador buscarAdministrador(String idAdmin, String password) {
        return listaAdministradores.stream()
                .filter(a -> a.getIdAdmin().equals(idAdmin) && 
                             a.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}