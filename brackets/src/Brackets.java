public class Brackets {
    private static final String[] leftBrackets = {"(","[","{","<"};
    private static final String[] rightBrackets = {")","]","}",">"};

    public static String[] getLeftBrackets() {
        return leftBrackets;
    }

    public static String[] getRightBrackets() {
        return rightBrackets;
    }

    public static void analyze(String string) {
        Stack<String> brackets = new Stack<>();
        String current;
        for(int i = 0; i < string.length(); i++) {
            current = string.substring(i,i+1);
            if (isBracket(current, getLeftBrackets())) {
                brackets.push(current);
            }
            else {
                if (isBracket(current, getRightBrackets())) {
                    if (canClose(current, brackets.getHead())) {
                        brackets.pop();
                    }
                    else {
                        throw new IllegalArgumentException("Wrong brackets order!");
                    }
                }
            }
        }
    }

    public static boolean isBracket(String letter, String[] brackets) {
        boolean result = false;
        for (String bracket: brackets) {
            if (letter.equals(bracket)) {
                result = true;
            }
        }
        return result;
    }

    public static boolean canClose(String current, String previous) {
        if (previous == null) {
            return false;
        }
        int number = -1;
        int i = 0;
        do {
            if (current.equals(rightBrackets[i])) {
                number = i;
                break;
            }
            i++;
        } while (number < 0);
        return previous.equals(leftBrackets[number]);
    }
}
