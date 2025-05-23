package co.edu.uniquindio.Model;

import co.edu.uniquindio.Util.DataUtil;
import java.util.List;

public class BilleteraVirtual {
  
    private DataUtil dataUtil = DataUtil.getInstance();
    
    public boolean registrarUsuario(Usuario usuario) {
        if (usuario == null || dataUtil.existeUsuario(usuario.getIdUsuario())) {
            return false;
        }
        return dataUtil.agregarUsuario(usuario);
    }
    

    public BilleteraVirtual() {
        this.dataUtil = DataUtil.getInstance();
    }
    
    public Usuario autenticarUsuario(String idUsuario, String password) {
        return dataUtil.buscarUsuario(idUsuario, password);
    }
    
    public Administrador autenticarAdministrador(String idAdmin, String password) {
        return dataUtil.buscarAdministrador(idAdmin, password);
    }
    
    
    public List<Usuario> getUsuarios() {
        return dataUtil.getListaUsuarios();
    }
    
    public List<Administrador> getAdministradores() {
        return dataUtil.getListaAdministradores();
    }
}