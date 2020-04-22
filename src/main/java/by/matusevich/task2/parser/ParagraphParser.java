package by.matusevich.task2.parser;

import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.entity.TextComposite;
import by.matusevich.task2.entity.ComponentType;

public class ParagraphParser extends TextParser {

    private final static String REGEX_PARAGRAPH_SPLIT = "\n\t";

    public ParagraphParser() {
        super(new SentenceParser());
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent componentSentences = new TextComposite(ComponentType.TEXT);

        String[] paragraphs = text.split(REGEX_PARAGRAPH_SPLIT);

        for (String paragraph : paragraphs) {
            TextComponent componentSentence = nextParser.parse(paragraph);
            componentSentences.add(componentSentence);
        }

        return componentSentences;
    }


}