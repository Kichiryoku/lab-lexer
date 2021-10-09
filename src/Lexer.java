public class Lexer {
    static Code code;
    public static void lexer() {
        char ch;
        boolean err = false;
        Token t = new Token();
        while (!code.endOfCode()) {
            if (err) {
                System.out.println("Err");
                break;
            }
            ch = code.getChar();
            switch (Status.stat) {
                case 0: // not in any status
                    if (Status.isSingle(ch)) {
                        t = new Token(ch);
                        t.printChar();
                    } else if (ch == '=') {
                        Status.stat = 1;
                        t = new Token(ch);
                    } else if (Status.isDigit(ch)) {
                        Status.stat = 2;
                        t = new Token(ch);
                    } else if (Status.isNonDigit(ch)) {
                        Status.stat = 3;
                        t = new Token(ch);
                    } else if (Status.isSplit(ch)) continue;
                    else err = true;
                    break;
                case 1:   // status is '=' or "=="
                    if (ch == '=' && t.tokenSize() < 2) { t.tokenStrCat('='); }
                    else {
                        Status.stat = 0;
                        t.printChar();
                        code.unGetChar();
                    }
                    break;
                case 2: // number
                    if (Status.isDigit(ch)) { t.tokenStrCat(ch); }
                    else {
                        Status.stat = 0;
                        t.str2num();
                        code.unGetChar();
                    }
                    break;
                case 3: // ident or reserved
                    if (Status.isNonDigit(ch) || Status.isDigit(ch)) { t.tokenStrCat(ch); }
                    else {
                        Status.stat = 0;
                        t.identOrReversed();
                        code.unGetChar();
                    }
                    break;
            }
        }

    }
    public static void main(String[] args) {
        code = Code.getInstance();
        code.inputCode();
        lexer();
        System.exit(0);
    }
}
