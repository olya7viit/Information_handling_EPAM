package by.matusevich.task2.entity;

import java.util.List;

public class Symbol implements TextComponent {

    private char symbol;
    private ComponentType type;


    public Symbol(char symbol, ComponentType type) {
        this.symbol = symbol;
        this.type=type;
    }

    @Override
    public void add(TextComponent component)  {

    }

    @Override
    public List<TextComponent> getComponents()  {
        throw new UnsupportedOperationException("Cannot be removed to leaf");
    }

    @Override
    public void remove(TextComponent component)  {
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}