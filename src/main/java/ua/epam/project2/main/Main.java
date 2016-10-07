package ua.epam.project2.main;

import ua.epam.project2.controller.Controller;
import ua.epam.project2.model.Text;

import java.io.IOException;

public class Main {

    /**
     * Create object of Controller and giving control to create objects
     * @param args command line arguments
     * @throws IOException when controller can not read file
     */
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        Text text = controller.readFile();
        controller.outputSortedWords(text);
        System.out.println("=================");
        controller.outputOriginalText(text);
    }
}
