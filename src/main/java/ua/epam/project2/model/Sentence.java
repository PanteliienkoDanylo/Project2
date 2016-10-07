package ua.epam.project2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Sentence{

    /**
     * TODO: interface of abstract class which will be implements or extend Word, Punctuation and EndOfSentence
     * TODO: create List<interface> and add sort!!! and then output this list
     *
     */

    /**
     * Character set
     */
    private static final Set<Character> CHARACTER_SET = new HashSet<Character>();

    /**
     * Composite list
     */
    private List<SentenceItem> compositeList;

    /**
     * Words list
     */
    private List<Word> words;

    /**
     * Initialization character set
     */
    static{
        CHARACTER_SET.add(',');
        CHARACTER_SET.add(';');
        CHARACTER_SET.add(':');
    }

    /**
     * EndOfSentence
     */
    private EndOfSentence endOfSentence;

    /**
     * Constructor
     * @param string sentence
     * @param endOfSentence end punctuation
     */
    public Sentence(String string, EndOfSentence endOfSentence){
        this.endOfSentence = endOfSentence;
        compositeList = new ArrayList<SentenceItem>();
        words = new ArrayList<Word>();
        add(string);
        //addWords(string);
    }

    /**
     * Split text on paragraphs
     * @param string object's parameter
     */
    public void add(String string){
        Pattern pattern = Pattern.compile("\\s");
        String[] array = pattern.split(string);
        for(int i = 0; i < array.length; i++) {
            char[] charArray = array[i].toCharArray();
            int charArrayLength = charArray.length;
            if(charArrayLength != 0 && CHARACTER_SET.contains(charArray[charArrayLength - 1])){
                compositeList.add(Word.getInstance(array[i].substring(0, charArrayLength - 1)));
                compositeList.add(Punctuation.getInstance(','));
                words.add(Word.getInstance(array[i].substring(0, charArrayLength - 1)));
            }else{
                compositeList.add(Word.getInstance(array[i]));
                words.add(Word.getInstance(array[i]));
            }
            /*if(!array[i].equals("")) {
                compositeList.add(Word.getInstance(array[i]));
            }
            /*
            if(charArrayLength != 0 && charArray[charArrayLength - 1] == ','){
                compositeList.add(Punctuation.getInstance(','));
            }
            */
        }
    }

    /*
    public void addWords(String string){
        Pattern pattern = Pattern.compile("\\s");
        String[] array = pattern.split(string);
        for(int i = 0; i < array.length; i++) {
            if(!array[i].equals("")) {
                words.add(Word.getInstance(array[i]));
            }
        }
    }
    */

    public List<SentenceItem> getCompositeList() {
        return compositeList;
    }

    public List<Word> getWords() {
        return words;
    }

    /**
     * To string
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(SentenceItem w : compositeList){
            sb.append(w);
            sb.append(" ");
        }
        sb.append(endOfSentence);
        return sb.toString();
    }
}
