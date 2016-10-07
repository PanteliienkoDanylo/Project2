package ua.epam.project2.model;

import java.util.HashMap;
import java.util.Map;

public class EndOfSentence implements SentenceItem {

    /**
     * End of sentence
     */
    private Character character;

    private static Map<Character, EndOfSentence> endOfSentenceMap = new HashMap<Character, EndOfSentence>();

    /**
     * Constructor
     * @param character end symbol of sentence
     */
    public EndOfSentence(Character character){
        this.character = character;
    }

    /**
     * Pattern Flyweight
     * @param character EndOfSentence character
     * @return
     */
    public static EndOfSentence getInstance(Character character){
        if(endOfSentenceMap.containsKey(character)){
            return endOfSentenceMap.get(character);
        }else {
            return new EndOfSentence(character);
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
