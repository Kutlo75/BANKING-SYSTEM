
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

public class AccountViewController {
    
    // Header
    @FXML private Label welcomeLabel;
    
    // Account Operations
    @FXML private Button depositButton;
    @FXML private Button withdrawButton;
    @FXML private Button viewBalanceButton;
    @FXML private Button transactionHistoryButton;
    @FXML private Button openAccountButton;
    @FXML private Button logoutButton;
    
    // Account Information - Dynamic based on account type
    @FXML private Label accountTypeHeaderLabel;
    @FXML private Label accountBalanceLabel;
    @FXML private Label accountTypeLabel;
    @FXML private Label accountNumberLabel;
    @FXML private Label accountStatusLabel;
    @FXML private Label feature1Label;
    @FXML private Label feature1ValueLabel;
    @FXML private Label feature2Label;
    
    // Account Operations
    @FXML private Label operationsHeaderLabel;
    @FXML private ComboBox<String> operationTypeCombo;
    @FXML private TextField operationAmountField;
    @FXML private Button executeOperationButton;
    @FXML private Label operationMessageLabel;
    
    // Transaction History
    @FXML private VBox transactionHistoryList;
    @FXML private Button refreshHistoryButton;
    
    @FXML
    private void initialize() {
        // ONLY UI setup - NO business logic
        initializeNoAccountView();
    }
    
    private void initializeNoAccountView() {
        // Display when no account is opened
        welcomeLabel.setText("Welcome to Banking System");
        
        accountTypeHeaderLabel.setText("Account Information");
        accountBalanceLabel.setText("0.00");
        accountTypeLabel.setText("No Account Opened");
        accountNumberLabel.setText("Account: Please open an account");
        accountStatusLabel.setText("Status: No active account");
        
        feature1Label.setText("Account Features");
        feature1ValueLabel.setText("Open an account to view features");
        feature2Label.setText(" ");
        
        operationsHeaderLabel.setText("Account Operations");
        operationTypeCombo.setPromptText("No account available");
        operationTypeCombo.getItems().clear();
        
        // Clear transaction history
        clearTransactionHistory();
    }
    
    // Method to update view based on account type
    public void updateAccountView(String accountType, String customerName, String accountNumber, 
                                 String balance, String... additionalInfo) {
        // ONLY update display - NO business logic
        welcomeLabel.setText("Welcome, " + customerName + "!");
        accountTypeLabel.setText(accountType);
        accountNumberLabel.setText("Account: " + accountNumber);
        accountBalanceLabel.setText(balance);
        accountStatusLabel.setText("Status: Active");
        
        // Configure view based on account type
        switch(accountType) {
            case "Savings Account":
                setupSavingsAccountView(additionalInfo);
                break;
            case "Current Account":
                setupCurrentAccountView(additionalInfo);
                break;
            case "Investment Account":
                setupInvestmentAccountView(additionalInfo);
                break;
            case "Student Account":
                setupStudentAccountView(additionalInfo);
                break;
            case "Business Account":
                setupBusinessAccountView(additionalInfo);
                break;
            default:
                setupDefaultAccountView(additionalInfo);
        }
    }
    
    private void setupSavingsAccountView(String[] info) {
        accountTypeHeaderLabel.setText("Savings Account Details");
        feature1Label.setText("Interest Rate");
        feature1ValueLabel.setText((info.length > 0 ? info[0] : "2.5%") + " per annum");
        feature2Label.setText("Minimum Balance: " + (info.length > 1 ? info[1] : "$100"));
        
        operationsHeaderLabel.setText("Savings Account Operations");
        operationTypeCombo.getItems().clear();
        operationTypeCombo.getItems().addAll("Deposit", "Withdrawal", "Calculate Interest");
        operationTypeCombo.setPromptText("Select operation");
    }
    
    private void setupCurrentAccountView(String[] info) {
        accountTypeHeaderLabel.setText("Current Account Details");
        feature1Label.setText("Overdraft Limit");
        feature1ValueLabel.setText((info.length > 0 ? info[0] : "$5,000"));
        feature2Label.setText("Monthly Fee: " + (info.length > 1 ? info[1] : "$10"));
        
        operationsHeaderLabel.setText("Current Account Operations");
        operationTypeCombo.getItems().clear();
        operationTypeCombo.getItems().addAll("Deposit", "Withdrawal", "Overdraft Request");
        operationTypeCombo.setPromptText("Select operation");
    }
    
    private void setupInvestmentAccountView(String[] info) {
        accountTypeHeaderLabel.setText("Investment Account Details");
        feature1Label.setText("Investment Return");
        feature1ValueLabel.setText((info.length > 0 ? info[0] : "7.2%") + " YTD");
        feature2Label.setText("Risk Level: " + (info.length > 1 ? info[1] : "Medium"));
        
        operationsHeaderLabel.setText("Investment Account Operations");
        operationTypeCombo.getItems().clear();
        operationTypeCombo.getItems().addAll("Deposit", "Withdrawal", "View Portfolio", "Trade Stocks");
        operationTypeCombo.setPromptText("Select operation");
    }
    
    private void setupStudentAccountView(String[] info) {
        accountTypeHeaderLabel.setText("Student Account Details");
        feature1Label.setText("Student Benefits");
        feature1ValueLabel.setText("No monthly fees");
        feature2Label.setText("Overdraft: " + (info.length > 0 ? info[0] : "$500 interest-free"));
        
        operationsHeaderLabel.setText("Student Account Operations");
        operationTypeCombo.getItems().clear();
        operationTypeCombo.getItems().addAll("Deposit", "Withdrawal", "Apply for Student Loan");
        operationTypeCombo.setPromptText("Select operation");
    }
    
    private void setupBusinessAccountView(String[] info) {
        accountTypeHeaderLabel.setText("Business Account Details");
        feature1Label.setText("Business Features");
        feature1ValueLabel.setText("Multi-user access");
        feature2Label.setText("Transaction Limit: " + (info.length > 0 ? info[0] : "$50,000 daily"));
        
        operationsHeaderLabel.setText("Business Account Operations");
        operationTypeCombo.getItems().clear();
        operationTypeCombo.getItems().addAll("Deposit", "Withdrawal", "Pay Employees", "Business Transfer");
        operationTypeCombo.setPromptText("Select operation");
    }
    
    private void setupDefaultAccountView(String[] info) {
        accountTypeHeaderLabel.setText("Account Details");
        feature1Label.setText("Account Features");
        feature1ValueLabel.setText("Standard banking features");
        feature2Label.setText(" ");
        
        operationsHeaderLabel.setText("Account Operations");
        operationTypeCombo.getItems().clear();
        operationTypeCombo.getItems().addAll("Deposit", "Withdrawal");
        operationTypeCombo.setPromptText("Select operation");
    }
    
    private void clearTransactionHistory() {
        transactionHistoryList.getChildren().clear();
        Label noTransactions = new Label("No transactions available");
        noTransactions.setStyle("-fx-text-fill: #666; -fx-font-style: italic;");
        transactionHistoryList.getChildren().add(noTransactions);
    }
    
    // Button handlers - ONLY collect input and validate format
    
    @FXML
    private void handleDeposit() {
        System.out.println("Deposit Funds requested");
        operationMessageLabel.setText("Opening deposit form...");
        operationMessageLabel.setStyle("-fx-text-fill: #1565c0;");
    }
    
    @FXML
    private void handleWithdraw() {
        System.out.println("Withdraw Funds requested");
        operationMessageLabel.setText("Opening withdrawal form...");
        operationMessageLabel.setStyle("-fx-text-fill: #1565c0;");
    }
    
    @FXML
    private void handleViewBalance() {
        System.out.println("View Balance requested");
        operationMessageLabel.setText("Displaying account balance...");
        operationMessageLabel.setStyle("-fx-text-fill: #1565c0;");
    }
    
    @FXML
    private void handleTransactionHistory() {
        System.out.println("Transaction History requested");
        operationMessageLabel.setText("Loading transaction history...");
        operationMessageLabel.setStyle("-fx-text-fill: #1565c0;");
    }
    
    @FXML
    private void handleOpenAccount() {
        System.out.println("Open New Account requested");
        operationMessageLabel.setText("Redirecting to account opening...");
        operationMessageLabel.setStyle("-fx-text-fill: #1565c0;");
    }
    
    @FXML
    private void handleExecuteOperation() {
        String operationType = operationTypeCombo.getValue();
        String amount = operationAmountField.getText();
        
        if (operationType == null) {
            showAlert("Input Error", "Please select operation type");
            return;
        }
        
        if (amount == null || amount.trim().isEmpty() || !isNumeric(amount)) {
            showAlert("Input Error", "Please enter valid amount");
            return;
        }
        
        operationMessageLabel.setText(operationType + " request submitted: " + amount);
        operationMessageLabel.setStyle("-fx-text-fill: #2e7d32;");
        
        System.out.println("Operation collected - Type: " + operationType + ", Amount: " + amount);
    }
    
    @FXML
    private void handleRefreshHistory() {
        System.out.println("Refresh History requested");
        operationMessageLabel.setText("Refreshing transaction history...");
        operationMessageLabel.setStyle("-fx-text-fill: #1565c0;");
    }
    
    @FXML
    private void handleLogout() {
        System.out.println("Logout requested");
        operationMessageLabel.setText("Logging out...");
        operationMessageLabel.setStyle("-fx-text-fill: #1565c0;");
    }
    
    private boolean isNumeric(String value) {
        if (value == null || value.trim().isEmpty()) return false;
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