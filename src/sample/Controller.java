package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import logic.PasswordGenerator;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private ChoiceBox lengthChoiceBox;
    @FXML
    private RadioButton yes;
    @FXML
    private RadioButton no;
    @FXML
    private Button generatePassword;
    @FXML
    private TextField showPassword;

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


        if(yes.isSelected()){
            specialCharactersDecision = true;
        }

        if(no.isSelected()){
            specialCharactersDecision = false;
        }



        /** The password is built */
        PasswordGenerator password = new PasswordGenerator(passwordLengthArgument, specialCharactersDecision);
        password.buildPassword();


        showPassword.setText(password.getPassword());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showPassword.setText("");

        for(int i = 5; i <=20; i++){
            lengthChoiceBox.getItems().add(i);
        }
    }



}
