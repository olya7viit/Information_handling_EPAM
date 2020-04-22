package by.matusevich.task2.parser;

import by.matusevich.task2.entity.TextComponent;

public abstract class TextParser {

    protected TextParser nextParser;

    public TextParser () {
    }

    public TextParser (TextParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract TextComponent parse(String text);
}