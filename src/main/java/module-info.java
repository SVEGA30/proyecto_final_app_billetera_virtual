module co.edu.uniquindio {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens co.edu.uniquindio to javafx.fxml;
    opens co.edu.uniquindio.ViewController to javafx.fxml;
    exports co.edu.uniquindio.ViewController;
    exports co.edu.uniquindio;
}
