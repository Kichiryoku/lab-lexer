
import java.util.Scanner;
public class Code {
    private static Code codeInstance = null;
    private Code() {}
    public static Code getInstance() {
        if (codeInstance == null) {
            codeInstance = new Code();
        }
        return codeInstance;
    }
    public String code = "";
    public int size;
    private int pos = 0;
    Scanner codeInput = new Scanner(System.in);
    void inputCode() {
        while (codeInput.hasNext()) {
            code = code.concat(codeInput.nextLine());
        }
        size = code.length();
    }
    public boolean endOfCode() {
        return pos == size + 1;
    }
    char getChar() {
        char ret = 0;
        if (pos != size) {
            ret = code.charAt(pos);
        }
        pos++;
        return ret;
    }
    void unGetChar() {
        if (pos >= 0) pos--;
    }

}
