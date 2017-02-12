/**
 * Created by nick on 2/11/17.
 */
package java_hangman;
import java.util.*;

public class Game {

    public Game(){

        //Asks user if they want to play
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would You Like To Play?(Y/N)");
        String play_response = scanner.next();

        if (play_response.equals("y") || play_response.equals("Y")){

            //If yes create new game round object
            System.out.println("selected yes");
            new GameRound();

        }else{

            //Otherwise stop
            System.out.println("selected no");
            return;

        }
    }
}
