package by.matusevich.task2.action;

import by.matusevich.task2.comparator.ParagraphComparator;
import by.matusevich.task2.entity.ComponentType;
import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.exception.ImpossibleOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAction {

    private static final TextAction INSTANCE = new TextAction();

    private static final Logger LOGGER = LogManager.getLogger();

    public static TextAction getInstance() { return INSTANCE; }

    private TextAction() {}

    public void sortParagraphs(TextComponent component) throws ImpossibleOperationException {
        if (component.getType() != ComponentType.TEXT) {
            LOGGER.error("It is not a text! ");
            throw new ImpossibleOperationException("It is not a text!");
        }
        ParagraphComparator comparator = new ParagraphComparator();
        List<TextComponent> paragraphs = component.getComponents();
        paragraphs.sort(comparator);
    }


    public List<TextComponent> getSentences(TextComponent component) throws ImpossibleOperationException {
        if (component.getType() != ComponentType.TEXT) {
            LOGGER.error("It is not a text! ");
            throw new ImpossibleOperationException("It is not a text!");
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
            LOGGER.error("It is not a text! ");
            throw new ImpossibleOperationException("It is not a text!");
        }

        List<TextComponent> paragraphs = component.getComponents();

        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();
            sentences.removeIf(e -> e.getComponents().size() < value);
        }
    }


    public long numberIdenticalWords(TextComponent component) throws ImpossibleOperationException {
        if (component.getType() != ComponentType.TEXT) {
            LOGGER.error("It is not a text! ");
            throw new ImpossibleOperationException("It is not a text!");
        }

        Map<String, Integer> identicalWords = new HashMap<>();
        List<TextComponent> paragraphs = component.getComponents();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponents();

            for (TextComponent sentence : sentences) {
                List<TextComponent> words = sentence.getComponents();

                for (TextComponent word : words) {
                    String strWord;
                        StringBuilder builderWord = new StringBuilder();

                        for (TextComponent element : word.getComponents()) {
                            if (element.getType() != ComponentType.PUNCTUATION) {
                                builderWord.append(element);
                            }
                        }
                        strWord = builderWord.toString();

                    if (identicalWords.containsKey(strWord)) {
                        identicalWords.put(strWord, identicalWords.get(strWord) + 1);
                    } else {
                        identicalWords.put(strWord, 1);
                    }
                }
            }
        }
        return identicalWords.values().stream().filter(a -> a > 1).count();
    }
}
