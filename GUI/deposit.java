
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;

public class deposit implements Initializable {

    // FXML Controls
    @FXML private TextField accountNumberField;
    @FXML private TextField accountNameField;
    @FXML private ComboBox<String> accountTypeCombo;
    @FXML private TextField amountField;
    @FXML private ComboBox<String> fundSourceCombo;
    @FXML private ComboBox<String> depositMethodCombo;
    @FXML private TextArea notesArea;
    @FXML private Button submitButton;
    @FXML private Button clearButton;
    @FXML private Button cancelButton;
    @FXML private Label statusLabel;

    // Data for combo boxes
    private ObservableList<String> accountTypes = FXCollections.observableArrayList(
        "Savings Account", "Current Account", "Fixed Deposit", "Business Account"
    );
    
    private ObservableList<String> fundSources = FXCollections.observableArrayList(
        "Salary", "Business Income", "Investment", "Gift", "Loan", "Other"
    );
    
    private ObservableList<String> depositMethods = FXCollections.observableArrayList(
        "Cash", "Check", "Bank Transfer", "Mobile Payment"
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up combo boxes
        setupComboBoxes();
        
        // Set up button actions
        setupButtonActions();
    }

    private void setupComboBoxes() {
        accountTypeCombo.setItems(accountTypes);
        fundSourceCombo.setItems(fundSources);
        depositMethodCombo.setItems(depositMethods);
    }

    private void setupButtonActions() {
        // Submit button action
        submitButton.setOnAction(event -> {
            statusLabel.setText("Deposit form submitted successfully!");
            statusLabel.setStyle("-fx-text-fill: green;");
        });

        // Clear button action
        clearButton.setOnAction(event -> {
            clearForm();
            statusLabel.setText("Form cleared");
            statusLabel.setStyle("-fx-text-fill: blue;");
        });

        // Cancel button action
        cancelButton.setOnAction(event -> {
            clearForm();
            statusLabel.setText("Deposit cancelled");
            statusLabel.setStyle("-fx-text-fill: orange;");
        });
    }

    private void clearForm() {
        accountNumberField.clear();
        accountNameField.clear();
        accountTypeCombo.getSelectionModel().clearSelection();
        amountField.clear();
        fundSourceCombo.getSelectionModel().clearSelection();
        depositMethodCombo.getSelectionModel().clearSelection();
        notesArea.clear();
    }

    // Getter methods for FXML controls (for testing or external access)
    public TextField getAccountNumberField() { return accountNumberField; }
    public TextField getAccountNameField() { return accountNameField; }
    public ComboBox<String> getAccountTypeCombo() { return accountTypeCombo; }
    public TextField getAmountField() { return amountField; }
    public ComboBox<String> getFundSourceCombo() { return fundSourceCombo; }
    public ComboBox<String> getDepositMethodCombo() { return depositMethodCombo; }
    public TextArea getNotesArea() { return notesArea; }
    public Button getSubmitButton() { return submitButton; }
    public Button getClearButton() { return clearButton; }
    public Button getCancelButton() { return cancelButton; }
    public Label getStatusLabel() { return statusLabel; }
}
