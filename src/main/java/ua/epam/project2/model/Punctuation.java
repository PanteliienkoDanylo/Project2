package ua.epam.project2.model;

import java.util.HashMap;
import java.util.Map;

public class Punctuation implements SentenceItem {

    /**
     * Punctuation character
     */
    private Character character;

    /**
     * Punctuation's map
     */
    private static Map<Character, Punctuation> punctuationMap= new HashMap<Character, Punctuation>();

    /**
     * Constructor
     * @param character punctuation character
     */
    public Punctuation(Character character){
        this.character = character;
    }

    /**
     * Pattern Flyweight
     * @param character
     * @return
     */
    public static Punctuation getInstance(Character character){
        if(punctuationMap.containsKey(character)){
            return punctuationMap.get(character);
        }else {
            return new Punctuation(character);
        }

    }

    public Character getString() {
        return character;
    }

    @Override
    public String toString() {
        return character.toString();
    }
}
