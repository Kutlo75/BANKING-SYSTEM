
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BalanceViewController {

    @FXML
    private Label lblBalance; // Displays current balance

    @FXML
    private Button btnBack; // Navigates to previous screen

    @FXML
    private Button btnDeposit; // Navigates to deposit screen

    /**
     * Initializes the Balance View UI.
     * Called automatically after FXML components are loaded.
     */
    @FXML
    public void initialize() {
        // Display default balance (for now static)
        lblBalance.setText("P 0.00");
    }

    /**
     * Handles the Back button click.
     * (Later you can add navigation logic here)
     */
    @FXML
    private void handleBackAction() {
        System.out.println("Back button clicked!");
        // TODO: Add navigation to previous scene
    }

    /**
     * Handles the Deposit button click.
     * (Later you can link this to DepositView.fxml)
     */
    @FXML
    private void handleDepositAction() {
        System.out.println("Deposit button clicked!");
        // TODO: Add navigation to Deposit view
    }
}

