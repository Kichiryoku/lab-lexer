public class Token {
    private String token;
    Token(char ch) { token = String.valueOf(ch); }
    Token(String s) { token = s; }
    Token() { token = ""; }
    void str2num() {
        System.out.printf("Number(%s)\n", token);
    }
    void identOrReversed() {
        switch (token) {
            case "if":
            case "else":
            case "while":
            case "continue":
            case "break":
            case "return":
                String res = Character.toUpperCase(token.charAt(0)) + token.substring(1);
                System.out.println(res);
                break;
            default:
                System.out.printf("Ident(%s)\n", token);
                break;
        }
    }
    void printChar() {
        String res = "";
        switch (token) {
            case "=" -> res = "Assign";
            case ";" -> res = "Semicolon";
            case "(" -> res = "LPar";
            case ")" -> res = "RPar";
            case "{" -> res = "LBrace";
            case "}" -> res = "RBrace";
            case "+" -> res = "Plus";
            case "*" -> res = "Mult";
            case "/" -> res = "Div";
            case "<" -> res = "Lt";
            case ">" -> res = "Gt";
            case "==" -> res = "Eq";
        }
        System.out.println(res);
    }
    void tokenStrCat(char ch) { token = token.concat(String.valueOf(ch)); }
}
