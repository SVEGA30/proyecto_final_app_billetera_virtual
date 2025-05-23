package co.edu.uniquindio.ViewController;

import java.io.IOException;
import co.edu.uniquindio.Model.BilleteraVirtual;
import co.edu.uniquindio.Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class RegistroViewController {
    private final BilleteraVirtual billeteraVirtual = new BilleteraVirtual();

    @FXML private TextField txtIdUsuario;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtDireccion;
    @FXML private PasswordField txtPassword;
    @FXML private PasswordField txtConfirmPassword;
    @FXML private Button btnRegistrar;
    @FXML private Button btnVolver;
   
    @FXML
    void onRegistrarse(ActionEvent event) {
    try {
        // Validación de campos vacíos
        if (!validarCamposObligatorios()) {
            mostrarAlerta("Error", "Campos incompletos", 
                "Complete todos los campos", Alert.AlertType.WARNING);
            return;
        }

        // Validación de contraseñas
        if (!txtPassword.getText().equals(txtConfirmPassword.getText())) {
            mostrarAlerta("Error", "Contraseñas no coinciden", 
                "Las contraseñas deben ser iguales", Alert.AlertType.ERROR);
            return;
        }

        // Crear nuevo usuario
        Usuario nuevoUsuario = Usuario.builder()
            .idUsuario(txtIdUsuario.getText().trim())
            .nombreCompleto(txtNombre.getText().trim())
            .correo(txtCorreo.getText().trim())
            .telefono(txtTelefono.getText().trim())
            .direccion(txtDireccion.getText().trim())
            .password(txtPassword.getText().trim())
            .saldo(0.0)
            .build();

        System.out.println("Intentando registrar usuario: " + nuevoUsuario); // Depuración

        // Intentar registro
        if (billeteraVirtual.registrarUsuario(nuevoUsuario)) {
            mostrarAlerta("Éxito", "Registro completado", 
                "Usuario registrado correctamente", Alert.AlertType.INFORMATION);
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Usuario existente", 
                "El ID de usuario ya está registrado", Alert.AlertType.ERROR);
        }
    } catch (Exception e) {
        mostrarAlerta("Error", "Error inesperado", 
            "Ocurrió un error al registrar: " + e.getMessage(), Alert.AlertType.ERROR);
        e.printStackTrace();
    }
}

     @FXML
    void onVolver(ActionEvent event) {
    try {
        
    Stage stage = (Stage) btnVolver.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/Login.fxml"));
        
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
     } catch (IOException e) {
         mostrarAlerta("Error", "Error al cargar la vista", 
                         "No se pudo cargar la vista de login", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private boolean validarCamposObligatorios() {
        return !txtIdUsuario.getText().trim().isEmpty() &&
               !txtNombre.getText().trim().isEmpty() &&
               !txtCorreo.getText().trim().isEmpty() &&
               !txtTelefono.getText().trim().isEmpty() &&
               !txtDireccion.getText().trim().isEmpty() &&
               !txtPassword.getText().trim().isEmpty() &&
               !txtConfirmPassword.getText().trim().isEmpty();
    }

    private void limpiarCampos() {
        txtIdUsuario.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtDireccion.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
    }

    private void mostrarAlerta(String titulo, String header, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    
    }



