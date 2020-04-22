package by.matusevich.task2.operation;

import by.matusevich.task2.interpreter.Context;

public class NonTerminalExpressionNumber implements AbstractMathExpression {

    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
