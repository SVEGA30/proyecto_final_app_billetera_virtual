package co.edu.uniquindio.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.util.ResourceBundle;
import java.net.URL;

public class BilleteraVirtualAppViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCategorias;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnCuentas;

    @FXML
    private Button btnEstadisticas;

    @FXML
    private Button btnPresupuestos;

    @FXML
    private Button btnTransacciones;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Label lblUsuarioActual;

    @FXML
    private BorderPane mainBorderPane;

    public void configurarUsuario(String nombreUsuario, String tipoUsuario) {
        String texto = tipoUsuario.equals("admin") 
            ? "Administrador: " + nombreUsuario 
            : "Usuario: " + nombreUsuario;
        lblUsuarioActual.setText(texto);
        
        if (tipoUsuario.equals("usuario")) {
            btnUsuarios.setVisible(false);
        }
    }

    @FXML
    void onCategorias(ActionEvent event) {
        // Implementar lógica para categorías
    }

    @FXML
    void onCerrarSesion(ActionEvent event) {
        try {
            Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
            stage.close();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/Login.fxml"));
            Parent root = loader.load();
            
            Stage loginStage = new Stage();
            loginStage.setScene(new Scene(root));
            loginStage.setTitle("Inicio de Sesión");
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onCuentas(ActionEvent event) {
        // Implementar lógica para cuentas
    }

    @FXML
    void onEstadisticas(ActionEvent event) {
        // Implementar lógica para estadísticas
    }

    @FXML
    void onPresupuestos(ActionEvent event) {
        // Implementar lógica para presupuestos
    }

    @FXML
    void onTransacciones(ActionEvent event) {
        // Implementar lógica para transacciones
    }

    @FXML
    void onUsuarios(ActionEvent event) {
        // Implementar lógica para usuarios (solo admin)
    }

    @FXML
    void initialize() {
        assert btnCategorias != null : "fx:id=\"btnCategorias\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert btnCerrarSesion != null : "fx:id=\"btnCerrarSesion\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert btnCuentas != null : "fx:id=\"btnCuentas\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert btnEstadisticas != null : "fx:id=\"btnEstadisticas\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert btnPresupuestos != null : "fx:id=\"btnPresupuestos\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert btnTransacciones != null : "fx:id=\"btnTransacciones\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert btnUsuarios != null : "fx:id=\"btnUsuarios\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert lblUsuarioActual != null : "fx:id=\"lblUsuarioActual\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
        assert mainBorderPane != null : "fx:id=\"mainBorderPane\" was not injected: check your FXML file 'BilleteraVirtualApp.fxml'.";
    }
}