import java.util.Stack;

public class bracketBalanceCollection {

    boolean isOpening(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    char reverseBracket(char ch) {
        if (ch == '(')
            return ')';
        else if (ch == '[')
            return ']';
        else if (ch == '{')
            return '}';
        else if(ch == ')')
            return '(';
        else if(ch == ']')
            return '[';
        else
            return '{';
    }

    boolean bracketBalancing(String str) {
        Stack<Character> sk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (isOpening(str.charAt(i))) {
                sk.push(str.charAt(i));
            } else if (!isOpening(str.charAt(i))) {
                if(!sk.empty()){
                    if(sk.peek() == reverseBracket(str.charAt(i)))
                        sk.pop();
                    else
                        return false;
                }else
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        bracketBalanceCollection obj = new bracketBalanceCollection();
        System.out.println(obj.bracketBalancing("]"));
    }
}
