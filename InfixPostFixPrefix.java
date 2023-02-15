public class InfixPostFixPrefix {
    public int top = -1;
    public char[] stack;

    InfixPostFixPrefix(int size) {
        stack = new char[size];
    }

    public void push(char ele) {
        if (top == stack.length - 1) {
            System.out.println("Stack Full");
        } else {
            top++;
            stack[top] = ele;
        }
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack Empty");
            return '\0';
        } else {
            return stack[top--];
        }
    }

    public char peek() {
        return stack[top];
    }

    public int presidence(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return 1;
    }

    public String convert(String infix){
        char[] temp = infix.toCharArray();
        String postfix = "";

        for(char c : temp){
            if(Character.isLetter(c)){
                postfix = postfix + c;
            }else if(c == '('){
                push(c);
            }else if(c == ')'){
                while(top != -1 && peek() != '('){
                    postfix = postfix + pop();
                }
                if(top != -1){
                    pop();
                }
            }else{
                while(top != -1 && presidence(c) <= presidence(peek()) && peek() != '('){
                    postfix = postfix + pop();
                }
                push(c);
            }
        }
        while(top != -1){
            postfix = postfix + pop();
        }
        return postfix;
    }


    public String reversBraces(String str){
        String obj = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                obj = obj + ')';
            }else if(str.charAt(i) == ')'){
                obj = obj + '(';
            }else{
                obj = obj + str.charAt(i);
            }
        }
        return obj;
    }

    public String reverseString(String infix){
        StringBuilder str = new StringBuilder();
        str.append(infix);
        str = str.reverse();
        return str.toString();
    }

    public static void main(String[] args) {
        // String infix = "(((A-(B+C))*D)^(E+F))";
        String infix = "(A+B^C*(D+E^F/G))";

        InfixPostFixPrefix obj = new InfixPostFixPrefix(infix.length());

        System.out.println(obj.convert(infix));

        System.out.println(obj.reverseString(obj.convert(obj.reversBraces(obj.reverseString(infix)))));

    }
}