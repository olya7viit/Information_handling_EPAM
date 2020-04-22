package by.matusevich.task2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextComposite implements TextComponent {

    private final static String PARAGRAPH_SPLIT = "\n    ";
    private final static String WORD_SPLIT = " ";

    private List<TextComponent> components = new ArrayList<>();
    private ComponentType type;

    public TextComposite(ComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextComposite)) return false;
        TextComposite composite = (TextComposite) o;
        return Objects.equals(components, composite.components) &&
                type == composite.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, type);
    }

    @Override
    public String toString() {

        StringBuilder stringComponents = new StringBuilder();
        for (TextComponent textComponent: components) {
            switch (textComponent.getType()) {

                case PARAGRAPH:
                    stringComponents.append(PARAGRAPH_SPLIT);
                    break;

                case WORD:
                    stringComponents.append(WORD_SPLIT);
                    break;
            }
            stringComponents.append(textComponent.toString());
        }
        return stringComponents.toString();
    }
}