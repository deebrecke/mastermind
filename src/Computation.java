public class Computation {
    //this method compares user input with computer's answer

    //first check to see which letters are exactly equal
    public static String[] testGuess(char[] guessArray, char[] masterArray){
        String[] masterClues = new String[4];

        //create new array to check answer against current guess
        char[]testArray = new char[4];
        for(int i = 0; i < testArray.length; i++){
            testArray[i] = masterArray[i];
        }
        //check for exact matches
        for(int i = 0; i< testArray.length; i++){
            if(guessArray[i] == testArray[i]){
                //check for an exact match and remove checked
                testArray[i] = 0;
                guessArray[i] = 0;
                masterClues[i] = "red";
            }

            //then check remaining colors for right color wrong spot
            for(int j = 0; j< testArray.length; j++){
                if(guessArray[j] !=0 && guessArray[j] == testArray[i]){
                    //System.out.println("there but not exact match: white");
                    testArray[i] = 0;
                    guessArray[j] = 0;
                    masterClues[i] = "white";
                }
            }
        }//end outermost for loop for checking matches
        return (masterClues);
    }//end testGuess method
}
