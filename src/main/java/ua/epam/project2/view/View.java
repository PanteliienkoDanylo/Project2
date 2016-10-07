package ua.epam.project2.view;

import ua.epam.project2.model.Word;

import java.util.List;

public class View {

    /**
     * Get path to file, which we will be use
     * @return path to file
     */
    public String getFilePath(){
        return "D:/epam.project2.txt";
    }

    /**
     * Print all word, which lay in list
     * @param wordList list, which we use for take word for print
     */
    public void printWords(List<Word> wordList){
        for(Word w : wordList){
            System.out.println(w);
        }
    }


}
