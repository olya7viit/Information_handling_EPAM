package by.matusevich.task2.action;

import by.matusevich.task2.comparator.ParagraphComparator;
import by.matusevich.task2.entity.ComponentType;
import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.exception.ImpossibleOperationException;

import java.util.ArrayList;
import java.util.List;

public class TextAction {

    private static final TextAction INSTANCE = new TextAction();

    public static TextAction getInstance() { return INSTANCE; }

    private TextAction() {}

    public void sortParagraphs(TextComponent component) throws ImpossibleOperationException {
        if (component.getType() != ComponentType.TEXT) {
            //log
            throw new ImpossibleOperationException("Given parameter to sortParagraphs method is not a text!");
        }
        ParagraphComparator comparator = new ParagraphComparator();
        List<TextComponent> paragraphs = component.getComponents();
        paragraphs.sort(comparator);
    }


    public List<TextComponent> getSentences(TextComponent component) throws ImpossibleOperationException {
        if (component.getType() != ComponentType.TEXT) {
            //log
            throw new ImpossibleOperationException("Given parameter to sortParagraphs method is not a text!");
        }

        List<TextComponent> paragraphs = component.getComponents();
        List<TextComponent> sentencesWithMaxWord = new ArrayList<>();
        int maxLength=0;

        for (TextComponent paragraph : paragraphs) {

            List<TextComponent> sentences;
            sentences = paragraph.getComponents();

            for (TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getComponents();

                for (TextComponent word : words) {
                    if (word.getComponents().size() > maxLength) {
                        maxLength = word.getComponents().size();
                        sentencesWithMaxWord.clear();
                        sentencesWithMaxWord.add(sentence);

                    } else if (word.getComponents().size() == maxLength) {
                        sentencesWithMaxWord.add(sentence);
                    }
                }
            }
        }
        return sentencesWithMaxWord;
    }

    
    public void deleteSentences(TextComponent component, int value) throws ImpossibleOperationException {
        if (component.getType() != ComponentType.TEXT) {
            //log
            throw new ImpossibleOperationException("Given parameter to sortParagraphs method is not a text!");
        }

        List<TextComponent> paragraphs = component.getComponents();

        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();
            sentences.removeIf(e -> e.getComponents().size() < value);
        }
    }

}
