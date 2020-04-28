package by.matusevich.task2.comparator;

import by.matusevich.task2.entity.ComponentType;
import by.matusevich.task2.entity.TextComponent;
import by.matusevich.task2.entity.TextComposite;

import java.util.Comparator;
import java.util.List;

public class ParagraphComparator implements Comparator<TextComponent> {

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        TextComposite paragraph1 = (TextComposite) o1;
        TextComposite paragraph2 = (TextComposite) o2;
        if (paragraph1.getType() != ComponentType.PARAGRAPH ||
                paragraph2.getType() != ComponentType.PARAGRAPH) {
            return 0;
        }
        List<TextComponent> components1 = paragraph1.getComponents();
        List<TextComponent> components2 = paragraph2.getComponents();
        return components1.size() - components2.size();
    }
}
