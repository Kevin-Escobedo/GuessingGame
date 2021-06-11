package guess;

import java.util.Random;

public class GuessingGame
{
    private Random rand;
    private int num;
    public int tries;

    GuessingGame(int difficulty)
    /*
    Difficulty is encoded as:
        0 - Easy (1 - 10)
        1 - Normal (1 - 100)
        2 - Hard (1 - 1000)
    */
    {
        rand = new Random();
        tries = 0;

        switch(difficulty)
        {
            case 0:
                num = 1 + rand.nextInt(10);
                break;
            
            case 1:
                num = 1 + rand.nextInt(100);
                break;

            case 2:
                num = 1 + rand.nextInt(1000);
                break;
            
            default:    //Default difficulty will be normal
                num = 1 + rand.nextInt(100);
                break;
        }
    }

    int compare(int guess)
    /*
    Compares the guess to the random number
    
    Returns a negative if the guess is too low
    Returns 0 if the guess equals the random number
    Returns a positive if the guess is too high
    */
    {
        tries++;
        return guess - num;
    }
}
