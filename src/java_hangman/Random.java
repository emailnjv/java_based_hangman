/**
 * Created by nick on 2/10/17.
 */
package java_hangman;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.concurrent.*;

public class Random {

    static String actual_word;

    //Selects random word from JSON file
    static String random_word_selector() {

        try {

            //Parses JSON file
            JSONParser parser = new JSONParser();
            FileReader word_list_file = new FileReader("./word_list.json");
            JSONObject json_object = (JSONObject) parser.parse(word_list_file);
            JSONArray json_array = (JSONArray) json_object.get("word_list");

            //Selects random word from JSON
            int word_list_index = ThreadLocalRandom.current().nextInt(4);
            actual_word = (String) json_array.get(word_list_index);

        } catch (Exception e) {

            e.printStackTrace();

        }

        //returns actual word
        return actual_word;

    }
}

