import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringTest {
    public static void main(String[] args) {

        SpelExpressionParser parser = new SpelExpressionParser();
        // 1. SpelExpressionParser  extends  TemplateAwareExpressionParser  implements  ExpressionParser
        // 2. InternalSpelExpressionParser  extends  TemplateAwareExpressionParser  implements  ExpressionParser

        Expression expression = parser.parseExpression("100*(2+10)+66");
        System.out.println(expression.getValue());
    }
}
