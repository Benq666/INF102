package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

/**
 * Reverse Polish to Infix Notation (Easy)
 * https://uib.kattis.com/problems/uib.revpolishtoinfixeasy
 *
 * The following is an example of an expression written in reverse polish notation:
 *
 * 1 3 + 2 4 5 - + /
 *
 * It is a postfix notation, and is computer friendly when it comes to calculating the answer; however, this notation
 * is hard to read for the human eye. Implement a program which takes an arbitrary reverse polish expression and
 * converts it to a fully bracketed expression in infix notation. In the above example, the output would be:
 *
 * ((1+3)/(2+(4-5)))
 *
 * Input
 * The first and only line contains a sequence of tokens separated by single whitespaces. A token may be either
 * a non-negative 32-bit integer or one of the operators { +, -, *, /} . The line will contain at most 5000 tokens.
 * The tokens form a valid reverse polish expression.
 *
 * Output
 * Output a single line with the infix notation.
 *
 *
 * Solved by Andrey Belinskiy
 *
 */
public class RevPolishToInfix {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        MyDynamicArrayStack<String> stack = new MyDynamicArrayStack<String>();
        Kattio io = new Kattio(System.in, System.out);

        String[] arr = io.getLine().split(" ");

        for (String elem : arr) {
            if (elem.equals("+") || elem.equals("-") ||
                    elem.equals("/") || elem.equals("*")) {
                String a = stack.pop(), b = stack.pop();
                sb.append("(").append(b).append(elem).append(a).append(")");
                stack.push(sb.toString());
                sb.setLength(0);
            } else
                stack.push(elem);
        }

        io.println(stack.pop());

        io.close();
    }
}

/*
Sample Input 1:
1 3 + 2 4 5 - + /

Sample Output 1:
((1+3)/(2+(4-5)))

Sample Input 2:
100 30 20 + 2 * -

Sample Output 2:
(100-((30+20)*2))
 */

