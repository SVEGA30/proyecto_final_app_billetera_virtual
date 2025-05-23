package co.edu.uniquindio.ViewController;

import co.edu.uniquindio.Model.Administrador;
import co.edu.uniquindio.Model.BilleteraVirtual;
import co.edu.uniquindio.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoginViewController {

    private BilleteraVirtual billeteraVirtual;

    public LoginViewController() {
        this.billeteraVirtual = new BilleteraVirtual();
    }
    
    @FXML
    private PasswordField ContraLogin;

    @FXML
    private Button LoginBtn;

    @FXML
    private TextField UsuarioLogin;

    @FXML
    private Text onRegistro;

    @FXML
    void onRegistro(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/Registro.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) onRegistro.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.setTitle("Billetera Virtual - Registro de Usuario");
            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Error", "Error al cargar la vista", 
                         "No se pudo cargar la vista de registro: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    void onLogin(ActionEvent event) {
        String idUsuario = UsuarioLogin.getText().trim();
        String password = ContraLogin.getText().trim();

        if (idUsuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor complete todos los campos", 
                          Alert.AlertType.WARNING);
            return;
        }

        // Primero verifica si es usuario normal
        Usuario usuario = billeteraVirtual.autenticarUsuario(idUsuario, password);
        if (usuario != null) {
            abrirMenuPrincipal(usuario.getNombreCompleto(), "usuario");
            return;
        }

        // Luego verifica si es administrador
        Administrador admin = billeteraVirtual.autenticarAdministrador(idUsuario, password);
        if (admin != null) {
            abrirMenuPrincipal(admin.getNombre(), "admin");
            return;
        }

        mostrarAlerta("Credenciales incorrectas", 
                     "El ID de usuario o contraseña son incorrectos", 
                     Alert.AlertType.ERROR);
    }

    private void abrirMenuPrincipal(String nombreUsuario, String tipoUsuario) {
    try {
        Stage currentStage = (Stage) LoginBtn.getScene().getWindow();
        currentStage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/BilleteraVirtualApp.fxml"));
        Parent root = loader.load();

        // Verifica que el controlador se cargó correctamente
        BilleteraVirtualAppViewController controller = loader.getController();
        if (controller == null) {
            throw new RuntimeException("El controlador no se inicializó correctamente");
        }

        controller.configurarUsuario(nombreUsuario, tipoUsuario);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Billetera Virtual");
        stage.show();
    } catch (Exception e) {
        mostrarAlerta("Error", "No se pudo cargar la ventana principal", 
                     "Detalles: " + e.getMessage(), Alert.AlertType.ERROR);
    }
}

    private void mostrarAlerta(String titulo, String header, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        mostrarAlerta(titulo, null, mensaje, tipo);
    }

    @FXML
    void initialize() {
        assert ContraLogin != null : "fx:id=\"ContraLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert LoginBtn != null : "fx:id=\"LoginBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert UsuarioLogin != null : "fx:id=\"UsuarioLogin\" was not injected: check your FXML file 'Login.fxml'.";
    }
}