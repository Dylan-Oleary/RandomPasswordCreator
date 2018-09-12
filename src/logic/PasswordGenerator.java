package logic;

import java.util.Random;

public class PasswordGenerator {
    private String characters;
    private String password;
    private int passwordLength;
    private Random random;

    public PasswordGenerator(int passwordLength, boolean specialCharacters){
        this.password = "";
        this.characters = "";
        setPasswordLength(passwordLength);
        setCharacters(specialCharacters);
        this.random = new Random();
    }

    public String getPassword() {
        return password;
    }


    //This method verifies that the user has entered a password length between 5 and 20 characters

    public void setPasswordLength(int passwordLength) {
        if(passwordLength >= 5 && passwordLength <= 20)
            this.passwordLength = passwordLength;
        else
            throw new IllegalArgumentException("Sorry, you must choose a number between 5 - 20");
    }

    public int getPasswordLength(){
        return passwordLength;
    }

    //This method determines whether or not the password will contain special characters

    public void setCharacters(boolean specialCharacters){
        if(specialCharacters == true){
            characters = "abcdefghijklmnopqrstuvwxyz123456789!@#$%^&*";
        }else{
            characters = "abcdefghijklmnopqrstuvwxyz123456789";
        }
    }

    //This method builds the password string

    public void buildPassword(){
        for(int i = 0; i < passwordLength; i++) {
            int characterChooser = random.nextInt(characters.length()); //Chooses a random number from 0 - # of chars

            password += characters.charAt(characterChooser);
        }
    }

    @Override
    public String toString(){
        return "Your password is: " + password;
    }
}
