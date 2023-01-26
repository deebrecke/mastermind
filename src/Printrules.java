import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Printrules{

    //this method checks to see if user knows rules and gets them ready to play
    public static void printIntro()throws FileNotFoundException{
        File f = new File("rules.txt");
        Scanner rules = new Scanner(f);
        System.out.println("Welcome to Mastermind");
        System.out.println("Do you know how to play? Type: \n 1. for yes or \n 2. for no ");
        //connect to a text file with the rules if they type no or any invalid input
        int rulesInput = Main.numInput.nextInt();
        if(rulesInput != 1){
            if(rulesInput ==2){
                while(rules.hasNextLine()){
                    //print text file of rules for the game
                    System.out.println(rules.nextLine());
                }
            }else{
                System.out.println("Not a valid choice, here are the rules:");
                while(rules.hasNextLine()){
                    //print text file of rules for the game
                    System.out.println(rules.nextLine());
                }
            }
        }
        System.out.println("\n Okay, let's play!");
        System.out.println("\n Please enter your guess. \n Use only the following characters: B G O R W Y  \n with no spaces or commas \n for example: RBGY");
    }


}
