
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import java.time.LocalDate;

public class OpenAccountBoundary {
    
    // Personal Information Fields
    @FXML private TextField fullNameField;
    @FXML private DatePicker dobPicker;
    @FXML private ComboBox<String> genderCombo;
    @FXML private ComboBox<String> maritalStatusCombo;
    @FXML private TextField nationalityField;
    @FXML private TextField occupationField;
    @FXML private TextField idNumberField;
    
    // Contact Information Fields
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextArea addressField;
    
    // Account Details Fields
    @FXML private ComboBox<String> accountTypeCombo;
    @FXML private ComboBox<String> currencyCombo;
    @FXML private TextField initialDepositField;
    @FXML private TextField monthlyIncomeField;
    
    // Buttons and Messages
    @FXML private Button submitButton;
    @FXML private Button cancelButton;
    @FXML private Label messageLabel;
    
    @FXML
    private void initialize() {
        // ONLY UI setup - NO business logic
        setupGenderComboBox();
        setupMaritalStatusComboBox();
        setupAccountTypeComboBox();
        setupCurrencyComboBox();
    }
    
    private void setupGenderComboBox() {
        genderCombo.getItems().addAll("Male", "Female", "Other", "Prefer not to say");
    }
    
    private void setupMaritalStatusComboBox() {
        maritalStatusCombo.getItems().addAll("Single", "Married", "Divorced", "Widowed");
    }
    
    private void setupAccountTypeComboBox() {
        accountTypeCombo.getItems().addAll("Savings Account", "Investmnt Account", "Cheque Account" 
                                          );
    }
    
    private void setupCurrencyComboBox() {
        currencyCombo.getItems().addAll("USD - US Dollar", "EUR - Euro", "GBP - British Pound", 
                                       "JPY - Japanese Yen", "CAD - Canadian Dollar");
    }
    
    @FXML
    private void handleSubmit() {
        // ONLY collect input - NO business logic
        String fullName = fullNameField.getText();
        LocalDate dob = dobPicker.getValue();
        String gender = genderCombo.getValue();
        String maritalStatus = maritalStatusCombo.getValue();
        String nationality = nationalityField.getText();
        String occupation = occupationField.getText();
        String idNumber = idNumberField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String accountType = accountTypeCombo.getValue();
        String currency = currencyCombo.getValue();
        String initialDeposit = initialDepositField.getText();
        String monthlyIncome = monthlyIncomeField.getText();
        
        // ONLY validate input format - NO business rules
        if (!validateInputFormat()) {
            return;
        }
        
        // Input format is valid - show success message
        messageLabel.setText("Application form submitted successfully!");
        messageLabel.setStyle("-fx-text-fill: green;");
        
        // ONLY display collected data - NO processing
        System.out.println("Form data collected for processing elsewhere");
    }
    
    @FXML
    private void handleCancel() {
        // ONLY navigation - NO business logic
        messageLabel.setText("Application cancelled");
        messageLabel.setStyle("-fx-text-fill: orange;");
    }
    
    private boolean validateInputFormat() {
        // ONLY validate format - NO business rules
        
        if (isFieldEmpty(fullNameField.getText())) {
            showAlert("Format Error", "Full name is required");
            return false;
        }
        
        if (dobPicker.getValue() == null) {
            showAlert("Format Error", "Date of birth is required");
            return false;
        }
        
        if (genderCombo.getValue() == null) {
            showAlert("Format Error", "Please select gender");
            return false;
        }
        
        if (maritalStatusCombo.getValue() == null) {
            showAlert("Format Error", "Please select marital status");
            return false;
        }
        
        if (isFieldEmpty(nationalityField.getText())) {
            showAlert("Format Error", "Nationality is required");
            return false;
        }
        
        if (isFieldEmpty(occupationField.getText())) {
            showAlert("Format Error", "Occupation is required");
            return false;
        }
        
        if (isFieldEmpty(idNumberField.getText())) {
            showAlert("Format Error", "ID number is required");
            return false;
        }
        
        if (isFieldEmpty(emailField.getText()) || !emailField.getText().contains("@")) {
            showAlert("Format Error", "Valid email address is required");
            return false;
        }
        
        if (isFieldEmpty(phoneField.getText())) {
            showAlert("Format Error", "Phone number is required");
            return false;
        }
        
        if (isFieldEmpty(addressField.getText())) {
            showAlert("Format Error", "Address is required");
            return false;
        }
        
        if (accountTypeCombo.getValue() == null) {
            showAlert("Format Error", "Please select account type");
            return false;
        }
        
        if (currencyCombo.getValue() == null) {
            showAlert("Format Error", "Please select currency");
            return false;
        }
        
        if (isFieldEmpty(initialDepositField.getText()) || !isNumeric(initialDepositField.getText())) {
            showAlert("Format Error", "Valid initial deposit amount is required");
            return false;
        }
        
        return true;
    }
    
    private boolean isFieldEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    
    private boolean isNumeric(String value) {
        if (isFieldEmpty(value)) return false;
        try {
            Double.parseDouble(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}