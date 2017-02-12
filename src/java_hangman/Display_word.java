/**
 * Created by nick on 2/10/17.
 */
package java_hangman;

public class Display_word {

    static String return_word = "";

    //Generates placeholders
    static String return_word(String actual_word) {

        //executes while return isn't ready
        while (return_word.length() != actual_word.length()) {
                    return_word += "_";
        }

        return return_word;

        }
    }

