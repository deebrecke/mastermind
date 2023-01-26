/*
Dee Brecke
2/24/2022
CreateArrays.java
Class to create the two main arrays used in mastermind game
*/
import java.util.*;

public class CreateArrays{
    public static Scanner textInput = new Scanner(System.in);

    //have computer generate a random "answer"
    public static char[] generateAnswer(){
        char[] answerArray = new char[4];
        char[] colorArray = {'R', 'B', 'G', 'Y', 'W','O'};

        for(int i = 0; i < answerArray.length; i++){
            Random rand = new Random();
            int randInt = rand.nextInt(6);
            answerArray[i] = colorArray[randInt];
        }
        return answerArray;
    }//end generateAnswer method

    //this method takes user input and makes sure it is in uppercase then checks the validity of the input
    public static char[] userInputGuess(){
        String guess = textInput.next().toUpperCase();
        //check for validity of input
        boolean valid = false;
        while(!valid){
            //check for correct number of colors
            if(guess.length() == 4){
                //then check for valid colors

                //create array of invalid inputs
                String invalidInputs = "ACDEFHIJKLMNPQSTUVXZ";
                char[] notValidArray = new char[20];
                for(int i = 0; i< notValidArray.length; i++){
                    notValidArray[i] = invalidInputs.charAt(i);
                }

                //check guess for any invalid inputs
                for (int i = 0; i < guess.length(); i++){
                    char checkInput = guess.charAt(i);
                    for (char c : notValidArray) {
                        if (c == checkInput) {
                            //have user try again with valid inputs
                            System.out.println(c + " is not a valid color");
                            System.out.println("Please use only characters: B G O R W Y");
                            guess = textInput.next().toUpperCase();
                        } else {
                            //correct number of valid inputs
                            valid = true;
                        }
                    }
                }
            }//end if statement checking for 4 colors
            else{
                //invalid number of inputs
                System.out.println("Please enter exactly 4 colors");
                guess = textInput.next().toUpperCase();
            }
        }//end validity-check while loop

        System.out.println("\nYou guessed " + guess + "\n");
        char[] inputArray = new char[4];
        for(int i = 0; i< inputArray.length; i++){
            inputArray[i] = guess.charAt(i);
        }
        return(inputArray);
    }//end of userInputGuess method
}//end CreateArrays class
