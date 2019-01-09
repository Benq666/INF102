package mandatory0.src.main.java.no.uib.ii.inf102.f18.mandatory0;

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

// 1 3 + 2 4 5 - + /   == ((1+3)/(2+(4-5)))
// 100 30 20 + 2 * -   == (100-((30+20)*2))
