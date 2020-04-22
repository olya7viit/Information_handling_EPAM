package by.matusevich.task2.interpreter;

import java.util.ArrayDeque;

public class Context {

    private static final Context INSTANCE = new Context();

    private ArrayDeque<Integer> values = new ArrayDeque<>();

    public static Context getInstance() {
        return INSTANCE;
    }

    private Context() {
    }

    public Integer popValue() {
        return values.pop();
    }

    public void pushValue(Integer value) {
        this.values.push(value);
    }

}
