package by.matusevich.task2.reader;

import by.matusevich.task2.exception.FileReadingException;
import by.matusevich.task2.reader.impl.TextFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextFileReaderTest {

    private TextFileReader reader = TextFileReader.getInstance();

    @Test(expectedExceptions = FileReadingException.class)
    public void read_wrongPath_fileReadingException() throws FileReadingException {
        reader.read("src/main/resources/file.txt");
    }

    @Test
    public void read_text_true() throws FileReadingException {
        String expected = "\tHello... I'm Olya.\n" +
                "\tBye.\n";
        String result = reader.read("src/main/resources/file.txt");

        Assert.assertEquals(result, expected);
    }

}