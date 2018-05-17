import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BracketsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void analyze_string_with_wrong_brackets_order() {
        Brackets.analyze("( < a a > >  )");
    }

    @Test
    public void analyzing_string_with_brackets() {
        Brackets.analyze("( < a a > )");
        Brackets.analyze("( < { [a a]} > )");
        Brackets.analyze("( <{{[[a a] ]}   } > )");
    }

    @Test
    public void is_left_bracket() {
        assertTrue(Brackets.isBracket("(", Brackets.getLeftBrackets()));

        assertFalse(Brackets.isBracket(")", Brackets.getLeftBrackets()));

        assertTrue(Brackets.isBracket("[", Brackets.getLeftBrackets()));
        assertTrue(Brackets.isBracket("{", Brackets.getLeftBrackets()));
        assertTrue(Brackets.isBracket("<", Brackets.getLeftBrackets()));
    }

    @Test
    public void is_right_bracket() {
        assertTrue(Brackets.isBracket(")", Brackets.getRightBrackets()));

        assertFalse(Brackets.isBracket("(", Brackets.getRightBrackets()));

        assertTrue(Brackets.isBracket("]", Brackets.getRightBrackets()));
        assertTrue(Brackets.isBracket("}", Brackets.getRightBrackets()));
        assertTrue(Brackets.isBracket(">", Brackets.getRightBrackets()));
    }

    @Test
    public void letter_is_not_a_bracket() {
        assertFalse(Brackets.isBracket("a", Brackets.getLeftBrackets()));
        assertFalse(Brackets.isBracket("a", Brackets.getRightBrackets()));
        assertFalse(Brackets.isBracket(" ", Brackets.getLeftBrackets()));
        assertFalse(Brackets.isBracket(" ", Brackets.getRightBrackets()));
    }

    @Test
    public void can_not_close_bracket_if_there_was_no_such_bracket_before() {
        assertFalse(Brackets.canClose(")", null));
        assertFalse(Brackets.canClose(")", "<"));
        assertFalse(Brackets.canClose(")", "{"));
        assertFalse(Brackets.canClose(")", "["));
    }

    @Test
    public void can_close_bracket_if_there_was_such_bracket_before() {
        assertTrue(Brackets.canClose(")", "("));
        assertTrue(Brackets.canClose(">", "<"));
        assertTrue(Brackets.canClose("}", "{"));
        assertTrue(Brackets.canClose("]", "["));
    }
}
