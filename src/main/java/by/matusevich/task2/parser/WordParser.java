package by.matusevich.task2.parser;

import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.entity.TextComposite;
import by.matusevich.task2.entity.ComponentType;

public class WordParser extends TextParser {

    private static String REGEX_WORD_SPLIT = " ";

    public WordParser() {
        super(new SymbolParser());
    }

    @Override
    public TextComponent parse(String text) {

        TextComponent componentSentence = new TextComposite(ComponentType.SENTENCE);
        String[] words = text.split(REGEX_WORD_SPLIT);

        for (String word : words) {
            TextComponent componentWord = nextParser.parse(word);
            componentSentence.add(componentWord);
        }
        return componentSentence;
    }
}