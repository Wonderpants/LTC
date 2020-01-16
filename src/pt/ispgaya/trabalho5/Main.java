package pt.ispgaya.trabalho5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        int opcao;
        String x;
        System.out.print("\n Programa de Conversão de Expressões");
        do {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n ----1: Converter Infix -> Postfix");
            System.out.print("\n ----2: Converter Postfix -> Infix");
            System.out.print("\n ----3: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            opcao = Read.Int();
            switch (opcao) {
                case 1: {
                    System.out.print("\n Informe a expressão infixa (string) -> ");
                    x = Read.String();
                    System.out.println("\t" + Convert.infixToPostfix(x));
                    Read.String();
                    break;
                }
                case 2: {
                    System.out.print("\n Informe a expressão posfixa (string) -> ");
                    x = Read.String();
                    System.out.print("\t" + Convert.getInfix(x));
                    Read.String();
                    break;
                }
            } // fim switch
        } while (opcao != 3);
    }
}

class Convert {
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder("");

        exp = exp.replaceAll(" ", "");

        Stack.CharStack stack = new Stack.CharStack();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) result.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (stack.isEmpty() && stack.peek() != '(') result.append(stack.pop());

                if (stack.isEmpty() && stack.peek() != '(') return "Invalid Expression"; // invalid expression
                else stack.pop();
            } else {
                while (stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    if (stack.peek() == '(') return "Invalid Expression";
                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        while (stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    static String getInfix(String exp) {
        Stack.StringStack s = new Stack.StringStack();
        exp = exp.replaceAll(" ", "");

        try {
            for (int i = 0; i < exp.length(); i++) {
                if (Character.isLetterOrDigit(exp.charAt(i))) {
                    s.push(exp.charAt(i) + "");
                } else {
                    String op1 = s.peek();
                    s.pop();
                    String op2 = s.peek();
                    s.pop();
                    s.push("(" + op2 + exp.charAt(i) + op1 + ")");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Expressão Invalida";
        }

        return s.peek();
    }
}

class Read {
    private Read() {
    }

    static int Int() {
        while (true) {
            try {
                return Integer.parseInt(String().trim());
            } catch (Exception e) {
                System.out.println("Not an Integer");
            }
        }
    }

    static String String() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
            s = in.readLine();
        } catch (IOException e) {
            System.out.println(" Error ");
        }
        return s;
    }

}
