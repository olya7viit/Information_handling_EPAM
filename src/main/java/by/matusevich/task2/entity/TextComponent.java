package by.matusevich.task2.entity;

import by.matusevich.task2.exception.ImpossibleOperationException;

import java.util.List;

public interface TextComponent {

    void add(TextComponent component) ;

    void remove(TextComponent component);

    ComponentType getType();

    List<TextComponent> getComponents();
}