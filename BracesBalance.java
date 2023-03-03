/*  Braces balancing question
 *      {[()]}      -->     YES
 *      {[()]}[]    -->     Yes
 *      {[]()}      -->     YES
 *      ({[}])      -->     NO
 *      ({[])       -->     NO
 */

public class BracesBalance {

    char[] stack;
    int top = -1;

    BracesBalance(int size) {
        stack = new char[size];
    }

    public char push(char ch) {
        if (top == stack.length - 1) {
            System.out.println("stack is full");
        } else {
            top++;
            stack[top] = ch;
        }
        return ch;
    }

    public char pop(char ch) {
        return stack[top--];
    }

    public boolean openingBraces(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public boolean closingBraces(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public boolean sameTypeClosing(char previous, char next) {
        if (previous == '(' && next == ')'){
            pop(next);
            return true;
        }else if (previous == '[' && next == ']'){
            pop(next);
            return true;
        }else if (previous == '{' && next == '}'){
            pop(next);
            return true;
        }else
            return false;
    }

    public String bracesBalancing(String input) {
        String output = "Default";
        for (int i = 0; i < input.length(); i++) {
            if (openingBraces(input.charAt(i))) {
                push(input.charAt(i));
            } else if (closingBraces(input.charAt(i))) {
                sameTypeClosing(stack[top], input.charAt(i));
            }

            if(top == -1)
                output = "Balanced";
            else
                output = "Unbalanced";
        }
        return output;
    }

    public static void main(String[] args) {
        String question = "({[])";

        BracesBalance obj = new BracesBalance(question.length());
        System.out.println(obj.bracesBalancing(question));
    }
}
