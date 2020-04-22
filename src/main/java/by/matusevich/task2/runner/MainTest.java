package by.matusevich.task2.runner;

import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.exception.FileReadingException;
import by.matusevich.task2.parser.TextParser;
import by.matusevich.task2.parser.ParagraphParser;
import by.matusevich.task2.reader.TextReader;
import by.matusevich.task2.reader.impl.TextFileReader;

public class MainTest {

    public static void main(String[] args) {

        TextReader reader = TextFileReader.getInstance();
        String text;
        try {
            text = reader.read("src/main/resources/file1.txt");
        } catch (FileReadingException e) {
            text = "Olya.";
        }

        TextParser textParser = new ParagraphParser();

        TextComponent textComponent;
        textComponent = textParser.parse(text);
        System.out.println(textComponent.toString());
    }

}
