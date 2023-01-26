/*
Dee Brecke
2/24/2022
MastermindFinalProject.java
Create a program that works like the game "mastermind"
*/
import java.util.*;
import java.io.*;

class Main{
    public static Scanner numInput = new Scanner(System.in);

    public static void main(String[] args)throws FileNotFoundException
    {
        //explain the rules if necessary
        Printrules.printIntro();
        GameLoop.gameLoop();
    }//end main method

}//end main class
