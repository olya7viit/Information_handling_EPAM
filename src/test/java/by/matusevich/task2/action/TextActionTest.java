package by.matusevich.task2.action;

import by.matusevich.task2.entity.ComponentType;
import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.entity.TextComposite;
import by.matusevich.task2.exception.FileReadingException;
import by.matusevich.task2.exception.ImpossibleOperationException;
import by.matusevich.task2.parser.TextParser;
import by.matusevich.task2.parser.impl.ParagraphParser;
import by.matusevich.task2.reader.TextReader;
import by.matusevich.task2.reader.impl.TextFileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextActionTest {

    private TextAction textAction = TextAction.getInstance();
    private TextComponent textComponent;

    @BeforeMethod
    public void init() throws FileReadingException, ImpossibleOperationException {
        TextReader reader = TextFileReader.getInstance();
        TextParser textParser = new ParagraphParser();
        String text = reader.read("src/main/resources/file.txt");

        textComponent = textParser.parse(text);
    }

    @Test
    public void sortParagraphs_text_true() throws ImpossibleOperationException {
        textAction.sortParagraphs(textComponent);
    }

}
