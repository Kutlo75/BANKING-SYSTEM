
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load your LoginView from Scene Builder
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        
        primaryStage.setTitle("Banking System");
        primaryStage.setScene(new Scene(root, 800, 600));  // ← Match your FXML size
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}