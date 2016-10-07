package ua.epam.project2.model;

import java.util.HashMap;
import java.util.Map;

public class Word implements SentenceItem {

    /**
     * Word's string
     */
    private String string;

    /**
     * Word's map
     */
    private static Map<String, Word> wordMap= new HashMap<String, Word>();

    /**
     * Constructor
     * @param string parameters of Word
     */
    public Word(String string){
        this.string = string;
    }

    /**
     * Pattern Flyweight
     * @param string Word's string
     * @return Word
     */
    public static Word getInstance(String string){
        if(wordMap.containsKey(string)){
            return wordMap.get(string);
        }else{
            Word word = new Word(string);
            wordMap.put(string, word);
            return word;
        }
    }


    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        return string;
    }
}
