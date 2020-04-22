package by.matusevich.task2.interpreter;

import by.matusevich.task2.operation.AbstractMathExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionCalculator {

    List<Character> operators = new ArrayList<>();

    private final static String REGEX_OPERATORS_SPLIT = "[+-/*]";

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char symbol = lexeme.charAt(0);

            boolean isOperator;
            isOperator = Pattern.matches(REGEX_OPERATORS_SPLIT,String.valueOf(symbol));

            if(isOperator){
                operators.add(symbol);
            }else {

            }
        }
    }

    public int calculate(Context context) {
        return 0;
    }
}
