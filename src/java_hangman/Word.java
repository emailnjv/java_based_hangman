/**
 * Created by nick on 2/10/17.
 */
package java_hangman;
import java.util.ArrayList;
import java.util.HashMap;

public class Word {

    //Process' guess
    static public HashMap letter_comparison(String actual_word, String return_word, Character c, ArrayList guess_list) {

        String final_product = "";
        String correct_guess = "false";
        HashMap<String, String> response = new HashMap();

        //While final product is complete do this
        while (final_product.length() != return_word.length()) {

            //If guess is novel
            if (!(guess_list.contains(c))) {

                for (int i = 0; i < actual_word.length(); i++) {

                    if (c.equals(actual_word.charAt(i))) {

                        //If matching character
                        final_product += actual_word.charAt(final_product.length());
                        correct_guess = "true";

                    } else if (return_word.charAt(i) == actual_word.charAt(i)) {

                        //If on previously restored index
                        final_product += actual_word.charAt(i);

                    } else {

                        //If character doesn't match
                        final_product += "_";

                    }
                }

                //Add guess to guess list
                java_hangman.GameRound.guess_list.add(c);

            } else {

                //If you've guessed this character before
                final_product = return_word;
                correct_guess = "duplicate";

            }
        }

        //puts responses in response object for return
        response.put("word", final_product);
        response.put("correct_guess", correct_guess);
        return response;

    }
}
