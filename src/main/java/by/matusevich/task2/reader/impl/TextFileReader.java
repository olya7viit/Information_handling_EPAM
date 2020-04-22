package by.matusevich.task2.reader.impl;

import by.matusevich.task2.exception.FileReadingException;
import by.matusevich.task2.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileReader implements TextReader {

    private static final TextFileReader INSTANCE = new TextFileReader();

    private static final Logger LOGGER = LogManager.getLogger();

    public static TextFileReader getInstance() { return INSTANCE; }

    private TextFileReader() {}

    @Override
    public String read(String fileName) throws FileReadingException {

        Path path = Paths.get(fileName);

        try (Stream<String> lineStream = Files.lines(Paths.get(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            lineStream.forEach(s -> {
                stringBuilder.append(s);
                stringBuilder.append('\n');
            });
            return stringBuilder.toString();
        } catch (IOException e) {
            LOGGER.error("Can't read from file " + path);
            throw new FileReadingException("Can't read from file " + path, e);
        }
    }
}
