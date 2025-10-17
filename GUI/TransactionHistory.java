
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransactionHistory {

    @FXML
    private Button btnBack; // Navigates to previous screen

    @FXML
    private TableView<?> tblTransactions; // Table showing all transactions

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colBalance;

    @FXML
    private TableColumn<?, ?> colDescription;

    /**
     * Initializes the Transaction History view.
     */
    @FXML
    public void initialize() {
        // Placeholder — later, you’ll load transactions here
        System.out.println("Transaction History View loaded.");
    }

    /**
     * Handles Back button click.
     */
    @FXML
    private void handleBackAction() {
        System.out.println("Back button clicked in Transaction History!");
        // TODO: Add navigation back to dashboard or balance view
    }
}

