package ua.epam.project2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph{

    /**
     * Sentence's list
     */
    private List<Sentence> sentenceList;

    /**
     * Constructor
     * @param string object's parameter
     */
    public Paragraph(String string){
        sentenceList = new ArrayList<Sentence>();
        add(string);

    }

    /**
     * Split text on paragraphs
     * @param string object's parameter
     */
    public void add(String string){
        Pattern pattern = Pattern.compile("[!?.]");
        Matcher matcher = pattern.matcher(string);
        int end = 0;
        while(matcher.find()){
            sentenceList.add(new Sentence(string.substring(end, matcher.start()),
                    new EndOfSentence(string.charAt(matcher.start()))));
            end = matcher.end();
        }
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }
}
