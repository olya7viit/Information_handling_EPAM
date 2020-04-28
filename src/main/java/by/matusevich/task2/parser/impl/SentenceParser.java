package by.matusevich.task2.parser.impl;

import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.entity.TextComposite;
import by.matusevich.task2.entity.ComponentType;
import by.matusevich.task2.exception.ImpossibleOperationException;
import by.matusevich.task2.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends TextParser {

    private static final String REGEX_SENTENCE_SPLIT = ".+?([.]{3}|[.!?])";

    public SentenceParser() {
        super(new WordParser());
    }

    @Override
    public TextComponent parse(String text) throws ImpossibleOperationException {

        TextComponent componentParagraph = new TextComposite(ComponentType.PARAGRAPH);

        Pattern patternSentence = Pattern.compile(REGEX_SENTENCE_SPLIT);
        Matcher matcherSentence = patternSentence.matcher(text);

        while (matcherSentence.find()) {
            String sentence = text.substring(matcherSentence.start(), matcherSentence.end());
            String trimmedSentence = sentence.trim();

            TextComponent componentSentence = nextParser.parse(trimmedSentence);
            componentParagraph.add(componentSentence);
        }

        return componentParagraph;
    }
}