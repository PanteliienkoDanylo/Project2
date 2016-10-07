package ua.epam.project2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Text{

    /**
     * This is array contains java keywords
     */
    private static final String[] KEY_WORDS = new String[]{
            "abstract", "continue", "for", "new", "switch",
            "assert", "default", "goto", "package", "synchronized",
            "boolean", "do", "if" ,"private" ,"this",
            "break", "double" ,"implements", "protected","throw",
            "byte",	"else", "import" ,"public" ,"throws",
            "case", "enum", "instanceof", "return", "transient",
            "catch", "extends",	"int", "short",	"try",
            "char",	"final", "interface", "static", "void",
            "class", "finally", "long", "strictfp",	"volatile",
             "const", "float", "native", "super" ,"while",
            "{", "}", ";"
    };

    /**
     * This is HashSet contains KEY_WORDS
     */
    private static final Set<String> KEY_WORDS_SET = new HashSet<String>();

    /**
     * Initialization KEY_WORD_SET
     */
    static{
        for(String s : KEY_WORDS){
            KEY_WORDS_SET.add(s);
        }
    }

    /**
     * Paragraph's ArrayList
     */
    private List<Paragraph> paragraphList;
    private List<Code> codeList;

    /**
     * Constructor
     * @param string parameter of Text
     */
    public Text(String string){
        paragraphList = new ArrayList<Paragraph>();
        codeList = new ArrayList<Code>();
        add(string);
    }

    /**
     * Split text on paragraphs
     * @param string object's parameter
     */
    public void add(String string){
        Pattern pattern = Pattern.compile("\n\n");
        String[] array = pattern.split(string);
        for(int i = 0; i < array.length; i++) {
            Paragraph p = new Paragraph(array[i]);
            if(isCode(p)) {
                paragraphList.add(p);
            }else {
                codeList.add(new Code(string));
            }
        }
    }

    /**
     * Check paragraph is code
     * @param paragraph paragraph
     * @return boolean
     */
    private boolean isCode(Paragraph paragraph){
        int count = 0, keyWordCount = 0 ;
        for(Sentence s : paragraph.getSentenceList()){
            for(SentenceItem w : s.getCompositeList()){
                count++;
                if(KEY_WORDS_SET.contains(w.getString())){
                    keyWordCount++;
                }
            }
        }
        return 100 * (keyWordCount + 1) / count < 50;
    }

    /*
    private boolean isCode(Sentence sentence){
        int count = 0, keyWordCount = 0 ;
            for(Word w : sentence.getCompositeList()){
                count++;
                if(KEY_WORDS_SET.contains(w.getString())){
                    keyWordCount++;
                }
            }
        return 100 * (keyWordCount+1) / count > 50;
    }
    */

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public List<Code> getCodeList() {
        return codeList;
    }
}
