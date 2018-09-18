package logic;

import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator {
    private String characters;
    private String password;
    private int passwordLength;
    private Random random;
    private boolean duplicateDecision;

    public PasswordGenerator(int passwordLength, boolean specialCharacters, boolean capitalLetters, boolean duplicateDecision,
                            boolean lowerCase, boolean numbers){
        this.password = "";
        this.characters = "";
        setPasswordLength(passwordLength);
        setCharacters(specialCharacters, capitalLetters, lowerCase, numbers);
        this.duplicateDecision = duplicateDecision;
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

    public void setCharacters(boolean specialCharacters, boolean capitalLetters, boolean lowerCase, boolean numbers){
        // We first decide whether we want special characters in the password

        if(lowerCase == true){
            if(specialCharacters == true){
                characters = "abcdefghijklmnopqrstuvwxyz!@#$%^&*-+=";
            }else{
                characters = "abcdefghijklmnopqrstuvwxyz";
            }

            //Next, we decide if we want capital letters in the password

            if(capitalLetters == true){
                characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + characters;
            }

            //Deciding if the character pool will contain numbers

            if(numbers == true){
                characters = characters + "123456789";
            }
        }

        if(lowerCase == false){
            if(specialCharacters == true){
                characters = "!@#$%^&*-+=";
            }

            if(capitalLetters == true){
                characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + characters;
            }

            if(numbers == true){
                characters = characters + "123456789";
            }
        }
    }

    //This method builds the password string

    public void buildPassword(){

        //This if/else block determines whether or not we build the password with duplicate characters

        if(!duplicateDecision == true){
            ArrayList<Integer> chosenNumbers = new ArrayList<>();

            for(int i = 0; i < passwordLength; i++){
                int characterChooser = random.nextInt(characters.length()); //Chooses a random number from 0 - # of chars

                while(chosenNumbers.contains(characterChooser)){
                    characterChooser = random.nextInt(characters.length());
                }

                if(!chosenNumbers.contains(characterChooser)){
                    password+= characters.charAt(characterChooser);
                    chosenNumbers.add(characterChooser);
                }
            }
        }else{
            for(int i = 0; i < passwordLength; i++) {
                int characterChooser = random.nextInt(characters.length()); //Chooses a random number from 0 - # of chars

                password += characters.charAt(characterChooser);
            }
        }
    }

    @Override
    public String toString(){
        return "Your password is: " + password;
    }
}
