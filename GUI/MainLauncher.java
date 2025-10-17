import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Buttons for each screen
        Button loginBtn = new Button("Open Login Screen");
        Button depositBtn = new Button("Open Deposit Screen");
        Button balanceBtn = new Button("Open Balance Screen");
        Button withdrawBtn = new Button("Open Withdraw Screen");

        // Button actions: load corresponding FXML
        loginBtn.setOnAction(e -> openFXML("LoginView.fxml", "Login Screen"));
        depositBtn.setOnAction(e -> openFXML("DepositView.fxml", "Deposit Screen"));
        balanceBtn.setOnAction(e -> openFXML("BalanceView.fxml", "Balance Screen"));
        withdrawBtn.setOnAction(e -> openFXML("WithdrawView.fxml", "Withdraw Screen"));

        // Layout
        VBox root = new VBox(10, loginBtn, depositBtn, balanceBtn, withdrawBtn);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Banking GUI Launcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to open FXML in a new Stage
    private void openFXML(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
