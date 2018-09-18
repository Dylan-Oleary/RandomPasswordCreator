package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.PasswordGenerator;


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private ChoiceBox lengthChoiceBox;

    //Special characters button
    @FXML
    private RadioButton specialYes;
    @FXML
    private RadioButton specialNo;

    //Capital letters button
    @FXML
    private RadioButton capitalYes;
    @FXML
    private RadioButton capitalNo;

    //Lower case letters button
    @FXML
    private RadioButton lowerCaseChoiceYes;
    @FXML
    private RadioButton lowerCaseChoiceNo;

    //Number choice button
    @FXML
    private RadioButton numberChoiceYes;
    @FXML
    private RadioButton numberChoiceNo;

    //Duplicate letters button
    @FXML
    private RadioButton duplicateYes;
    @FXML
    private RadioButton duplicateNo;

    @FXML
    private Button generatePassword;
    @FXML
    private TextField showPassword;
    @FXML
    private Button copyPassword;
    @FXML
    private Button clearPassword;

    /** Generates a password for the user */
    @FXML
    public void generatePasswordButtonPushed(){

        /**This block grabs the value from the choice box and converts it
         * to an integer that will passed into our PasswordGenerator class
         */
        String passwordLength = lengthChoiceBox.getValue().toString();
        int passwordLengthArgument = Integer.parseInt(passwordLength);


        /** This block assigns either true or false to the PasswordGenerator with respect to including special
         * characters in the password
         */
        boolean specialCharactersDecision = true;


        if(specialYes.isSelected()){
            specialCharactersDecision = true;
        }

        if(specialNo.isSelected()){
            specialCharactersDecision = false;
        }

        /** This block assigns either true or false to the PasswordGenerator with respect to including capital
         * letters in the password
         */

        boolean capitalLettersDecision = true;

        if(capitalYes.isSelected()){
            capitalLettersDecision = true;
        }

        if(capitalNo.isSelected()){
            capitalLettersDecision = false;
        }

        /** This block determines whether or not the password will contain lowercase letters */
        boolean lowerCaseDecision = true;

        if(lowerCaseChoiceYes.isSelected()){
            lowerCaseDecision = true;
        }

        if(lowerCaseChoiceNo.isSelected()){
            lowerCaseDecision = false;
        }

        /** This block determines whether or not the password will contain numbers */
        boolean numberDecision = true;

        if(numberChoiceYes.isSelected()){
            numberDecision = true;
        }

        if(numberChoiceNo.isSelected()){
            numberDecision = false;
        }

        /** This block determines whether the password will be built to exclude duplicate characters */
        boolean duplicateDecision = true;

        if(duplicateYes.isSelected()){
            duplicateDecision = false;
        }

        if(duplicateNo.isSelected()){
            duplicateDecision = true;
        }


        /** The password is built */
        try{
            PasswordGenerator password = new PasswordGenerator(passwordLengthArgument, specialCharactersDecision, capitalLettersDecision,
                    duplicateDecision, lowerCaseDecision, numberDecision);
            password.buildPassword();

            showPassword.setText(password.getPassword());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("You can't make a password without any characters! :(");
            alert.showAndWait();
        }

    }

    /** Copies the password to the system clipboard */
    @FXML
    public void copyPasswordButtonPushed(){
        String passwordToBeCopied = showPassword.getText();
        StringSelection stringSelection = new StringSelection(passwordToBeCopied);

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    /** Clears the TextField where the generated password is shown */
    @FXML
    public void clearPasswordButtonPushed(){
        showPassword.setText("");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showPassword.setText("");
        lengthChoiceBox.setValue(5);

        for(int i = 5; i <=20; i++){
            lengthChoiceBox.getItems().add(i);
        }
    }



}
