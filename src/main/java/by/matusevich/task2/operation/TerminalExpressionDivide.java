package by.matusevich.task2.operation;

import by.matusevich.task2.interpreter.Context;

public class TerminalExpressionDivide implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue()/context.popValue());
    }
}
