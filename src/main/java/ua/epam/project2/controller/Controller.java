package ua.epam.project2.controller;

import ua.epam.project2.model.Paragraph;
import ua.epam.project2.model.Sentence;
import ua.epam.project2.model.Text;
import ua.epam.project2.model.Word;
import ua.epam.project2.view.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controller {

    /**
     * View
     */
    private View view;

    /**
     * Constructor
     */
    public Controller(){
        view = new View();
    }

    /**
     * Output to console original text
     * @param text text from file
     */
    public void outputOriginalText(Text text){
        for(Paragraph p : text.getParagraphList()){
            for(Sentence s : p.getSentenceList()){
                System.out.println(s);
            }
        }
    }

    /**
     * Read file
     * @return Text
     * @throws IOException file cannot found
     */
    public Text readFile() throws IOException {
        return new Text(getString(view.getFilePath()));
    }

    /**
     * Output all sorted words
     * @param text text from file
     */
    public void outputSortedWords(Text text){
        List<Word> wordList = new ArrayList<Word>();
        for(Paragraph p : text.getParagraphList()){
            for(Sentence s : p.getSentenceList()){
                for(Word w : s.getWords()){
                    wordList.add(w);
                }
            }
        }
        //TODO hashMap !!!with key - real word, value - word with lowerCase();
        Collections.sort(wordList, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {

                return o1.getString().toLowerCase().compareTo(o2.getString().toLowerCase());
            }
        });
        view.printWords(wordList);
    }

    /**
     *
     * @param fileName File name which we will be use
     * @return text from file
     * @throws IOException file cannot found
     */
    private String getString(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        try{
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while(line != null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();

        }finally {
            bufferedReader.close();
        }

    }
}
