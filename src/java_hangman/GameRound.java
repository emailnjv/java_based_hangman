/**
 * Created by nick on 2/10/17.
 */
package java_hangman;
import java.util.*;

class GameRound {

    String actual_word;
    String display_word;
    int guesses_left;
    static ArrayList<Character> guess_list = new ArrayList<>();

    GameRound() {

        //Gets word to use from JSON list
        this.actual_word = java_hangman.Random.random_word_selector();

        //Gets the word to display
        this.display_word = java_hangman.Display_word.return_word(actual_word);

        //Initializes guess' left
        this.guesses_left = 6;

        //Start guess recursion
        this.guess();

    }

    private void guess() {

        //Prints status and prompts for guess
        System.out.println("Guess' Left: " + guesses_left + " Games Won: " + java_hangman.Main.wins + " Games Lost: " + java_hangman.Main.losses);
        System.out.println(display_word);
        System.out.println("Guess a letter");
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next(".").charAt(0);

        //Process' guess
        HashMap words = java_hangman.Word.letter_comparison(actual_word, display_word, c, guess_list);
        this.display_word = words.get("word").toString();

        //Process' response from guess processor
        if (words.get("correct_guess").equals("false")) {

            this.guesses_left = this.guesses_left - 1;
            System.out.println("You've Guessed Wrong!");

        } else if (words.get("correct_guess").equals("true")) {

            System.out.println("You've Guessed Correct");

        } else {

            System.out.println("You've Already guessed " + c + "!");

        }

        //If you did'nt win or loose recall guess method
        if ((this.guesses_left != 0) && (!(this.display_word.equals(this.actual_word)))) {

            this.guess();

        } else if (this.display_word.equals(this.actual_word)) {

            //If you won increase win counter and create new game
            java_hangman.Main.wins++;
            System.out.println("You've Won!");
            new Game();

        } else {

            //If you won increase loose counter and create new game
            java_hangman.Main.losses++;
            System.out.println("You've Lost!");
            new Game();

        }
    }
}
