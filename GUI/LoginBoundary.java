
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class LoginBoundary {
    
    // These match your FXML fx:id exactly
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Button openAccountButton;
    @FXML private Label loginMessage;
    
    // This method will be called when login button is clicked
    @FXML
    private void handleLogin() {
        // ONLY collect input - NO business logic
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        // ONLY validate input format - NO checking if user exists
        if (username == null || username.trim().isEmpty()) {
            showAlert("Input Error", "Username cannot be empty");
            return;
        }
        
        if (password == null || password.trim().isEmpty()) {
            showAlert("Input Error", "Password cannot be empty");
            return;
        }
        
        if (password.length() < 4) {
            showAlert("Input Error", "Password must be at least 4 characters");
            return;
        }
        
        // Input format is valid - business logic happens elsewhere
        loginMessage.setText("Login request received for: " + username);
        loginMessage.setStyle("-fx-text-fill: green;");
        
        System.out.println("Login attempt - Username: " + username + ", Password: " + password);
        // Business logic (authentication) happens in other classes
    }
    
    // This method will be called when open account button is clicked
 @FXML
private void handleOpenAccount() {
    try {
        // Load the Open Account FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OpenAccount.fxml"));
        Parent root = loader.load();

        // Create a new window (Stage)
        Stage stage = new Stage();
        stage.setTitle("Open Account");
        stage.setScene(new Scene(root));
        stage.show();  // Display the Open Account screen

        // Optional: update message in Login screen
        loginMessage.setText("Open Account screen opened");
        loginMessage.setStyle("-fx-text-fill: blue;");

    } catch (Exception e) {
        e.printStackTrace();
        loginMessage.setText("Failed to open Open Account screen");
        loginMessage.setStyle("-fx-text-fill: red;");
    }
}

    
    // Helper method for alerts - only for input format errors
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}