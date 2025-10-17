

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;

public class WithdrawalView  implements Initializable {

    // FXML Controls - Account Information
    @FXML private TextField accountNumberField;
    @FXML private TextField accountNameField;
    @FXML private ComboBox<String> accountTypeCombo;

    // FXML Controls - Withdrawal Details
    @FXML private TextField amountField;
    @FXML private ComboBox<String> withdrawalMethodCombo;
    @FXML private ComboBox<String> purposeCombo;

    // FXML Controls - Additional Notes
    @FXML private TextArea notesArea;

    // FXML Controls - Buttons and Status
    @FXML private Button submitButton;
    @FXML private Button clearButton;
    @FXML private Button cancelButton;
    @FXML private Label statusLabel;

    // Data for combo boxes
    private ObservableList<String> accountTypes = FXCollections.observableArrayList(
        "Savings Account", "Current Account", "Fixed Deposit", "Business Account"
    );
    
    private ObservableList<String> withdrawalMethods = FXCollections.observableArrayList(
        "Cash", "ATM", "Bank Transfer", "Check", "Mobile Payment"
    );
    
    private ObservableList<String> purposes = FXCollections.observableArrayList(
        "Personal Use", "Bill Payment", "Shopping", "Emergency", "Investment", "Other"
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up combo boxes with data
        setupComboBoxes();
        
        // Set up button actions
        setupButtonActions();
        
        // Set up input validation
        setupInputValidation();
    }

    private void setupComboBoxes() {
        accountTypeCombo.setItems(accountTypes);
        withdrawalMethodCombo.setItems(withdrawalMethods);
        purposeCombo.setItems(purposes);
    }

    private void setupButtonActions() {
        // Submit button action
        submitButton.setOnAction(event -> {
            if (validateInput()) {
                statusLabel.setText("Withdrawal request submitted successfully!");
                statusLabel.setStyle("-fx-text-fill: green;");
                // Here you would normally call business logic
            }
        });

        // Clear button action
        clearButton.setOnAction(event -> {
            clearForm();
            statusLabel.setText("Form cleared successfully!");
            statusLabel.setStyle("-fx-text-fill: blue;");
        });

        // Cancel button action
        cancelButton.setOnAction(event -> {
            clearForm();
            statusLabel.setText("Withdrawal cancelled!");
            statusLabel.setStyle("-fx-text-fill: orange;");
        });
    }

    private void setupInputValidation() {
        // Only allow numbers in amount field
        amountField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                amountField.setText(oldValue);
            }
        });

        // Only allow numbers in account number field
        accountNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                accountNumberField.setText(oldValue);
            }
        });
    }

    private boolean validateInput() {
        // Check if account number is provided
        if (accountNumberField.getText().isEmpty()) {
            statusLabel.setText("Please enter account number!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return false;
        }

        // Check if amount is provided and valid
        if (amountField.getText().isEmpty()) {
            statusLabel.setText("Please enter withdrawal amount!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return false;
        }

        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                statusLabel.setText("Amount must be greater than zero!");
                statusLabel.setStyle("-fx-text-fill: red;");
                return false;
            }
        } catch (NumberFormatException e) {
            statusLabel.setText("Please enter a valid amount!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return false;
        }

        // Check if withdrawal method is selected
        if (withdrawalMethodCombo.getValue() == null) {
            statusLabel.setText("Please select withdrawal method!");
            statusLabel.setStyle("-fx-text-fill: red;");
            return false;
        }

        statusLabel.setText("Validation successful!");
        statusLabel.setStyle("-fx-text-fill: green;");
        return true;
    }

    private void clearForm() {
        // Clear all input fields
        accountNumberField.clear();
        accountNameField.clear();
        accountTypeCombo.getSelectionModel().clearSelection();
        amountField.clear();
        withdrawalMethodCombo.getSelectionModel().clearSelection();
        purposeCombo.getSelectionModel().clearSelection();
        notesArea.clear();
    }

    // Getter methods for accessing form data (for testing or external use)
    public String getAccountNumber() { return accountNumberField.getText(); }
    public String getAccountName() { return accountNameField.getText(); }
    public String getAccountType() { return accountTypeCombo.getValue(); }
    public String getAmount() { return amountField.getText(); }
    public String getWithdrawalMethod() { return withdrawalMethodCombo.getValue(); }
    public String getPurpose() { return purposeCombo.getValue(); }
    public String getNotes() { return notesArea.getText(); }
    
    // Getter methods for UI controls (for testing)
    public TextField getAccountNumberField() { return accountNumberField; }
    public TextField getAccountNameField() { return accountNameField; }
    public ComboBox<String> getAccountTypeCombo() { return accountTypeCombo; }
    public TextField getAmountField() { return amountField; }
    public ComboBox<String> getWithdrawalMethodCombo() { return withdrawalMethodCombo; }
    public ComboBox<String> getPurposeCombo() { return purposeCombo; }
    public TextArea getNotesArea() { return notesArea; }
    public Button getSubmitButton() { return submitButton; }
    public Button getClearButton() { return clearButton; }
    public Button getCancelButton() { return cancelButton; }
    public Label getStatusLabel() { return statusLabel; }
}