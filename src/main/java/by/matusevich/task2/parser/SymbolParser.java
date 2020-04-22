package by.matusevich.task2.parser;

import by.matusevich.task2.entity.Symbol;
import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.entity.TextComposite;
import by.matusevich.task2.entity.ComponentType;
import by.matusevich.task2.parser.TextParser;

import java.util.regex.Pattern;

public class SymbolParser extends TextParser {

    private static final String REGEX_LETTER_SPLIT = "";
    private static final String REGEX_PUNCTUATION_SPLIT = "[\\.!?,']";
    private static final int LETTER_POSITION = 0;
    private static final int PUNCTUATION_POSITION = 0;

    public SymbolParser() {
        super(null);
    }

    @Override
    public TextComponent parse(String text) {

        TextComponent componentWord = new TextComposite(ComponentType.WORD);
        String[] letters = text.split(REGEX_LETTER_SPLIT);

        for (String letter : letters) {
            TextComponent component;
            if (Pattern.matches(REGEX_PUNCTUATION_SPLIT, letter)) {
                component = new Symbol(letter.charAt(PUNCTUATION_POSITION), ComponentType.PUNCTUATION);
            } else {
                component = new Symbol(letter.charAt(LETTER_POSITION), ComponentType.LETTER);
            }
            componentWord.add(component);
        }

        return componentWord;
    }
}