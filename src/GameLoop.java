import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GameLoop{
    public static boolean play = true;

    public static void gameLoop(){
        while(play){
            boolean hintUsed = false;
            //generate answer by calling method and storing array in variable
            char[] answerArray = CreateArrays.generateAnswer();
            //set conditions for while(game) loop

            boolean gameOver = false;
            String[] winArray = {"red", "red", "red", "red"};

            //loop until correct pattern is guessed
            //if guess is not perfect, have user try new guess
            int score = 0;
            while(!gameOver){
                //call user input array and store it in new variable
                char[] userArray = CreateArrays.userInputGuess();

                //pass user input and random into test arrays
                String[] clueOutput = Computation.testGuess(userArray, answerArray);

                //computer gives feedback as red, white or nothing
                showClues(clueOutput);

                if(Arrays.equals(winArray, clueOutput)){
                    //if guess is perfect, print out "you win" and print out their score
                    System.out.println("\n \nYou Win!!!!");
                    gameOver = true;
                    System.out.println("Your score is " + (score + 1)+ "\n");
                    break;
                }

                //ask user if they want a hint, if so, give them the first color and add 2 to score
                System.out.println("\nTry again\n");
                if(!hintUsed){
                    System.out.println("Would you like a hint? Type: ");
                    System.out.println("1. Yes\n2. No, or \n3. Don't ask again");
                    int hintChoice = Main.numInput.nextInt();
                    if(hintChoice ==1){
                        System.out.println("The first color is " + answerArray[0]);
                        hintUsed = true;
                        score += 2;
                    }else if(hintChoice ==3){
                        hintUsed = true;
                    }
                }

                System.out.println("Please enter new guess");

                //count how many times user has guessed
                score ++;
            }//end while game over

            playAgain();

        }//end while play loop

    }//end game loop

    //this method prints out the clue "pegs"
    public static void showClues(String[] clueOutput){
        for(int k = 0; k< clueOutput.length; k++){
            if(clueOutput[k] != null && clueOutput[k].equals("red")){
                System.out.print(clueOutput[k] + " ");
            }
        }
        for(int x = 0; x< clueOutput.length; x++){
            if(clueOutput[x] != null && clueOutput[x].equals("white")){
                System.out.print(clueOutput[x] + " ");
            }
        }
    }//end showClues method

    public static void playAgain(){
        //ask if they want to play again
        System.out.println("Do you want to play again? \nType: \n 1. for yes or \n 2. for no ");
        int playInput = Main.numInput.nextInt();
        if(playInput != 1){
            System.out.println("Thanks for playing!");
            play = false;
        }else{
            System.out.println("Okay, let's play!");
            System.out.println("\n Please enter your guess. \n Remember, use only the following characters: B G O R W Y  \n with no spaces or commas \n");
        }
    }

}
