package by.matusevich.task2.reader;

import by.matusevich.task2.exception.FileReadingException;

public interface TextReader {

    String read(String path) throws FileReadingException;
}
