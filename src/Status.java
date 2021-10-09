public class Status {
    static int stat = 0;

    static boolean isSplit(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n';
    }

    static boolean isNonDigit(char ch) {
        return Character.isAlphabetic(ch) || ch == '_';
    }

    static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    static boolean isSingle(char ch) {
        return ch == ';' || ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '+'
                || ch == '*' || ch == '/' || ch == '<' || ch == '>';
    }
}
