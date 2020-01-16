package pt.ispgaya.trabalho2;

import java.util.*;

class Pilha {
    private String[] pilha;
    private int top;
    private int capacity;

    Pilha(int size) {
        pilha = new String[size];
        capacity = size;
        top = -1;
        System.out.println("New stack with size of " + capacity);
    }

    void show() {
        System.out.println(Arrays.toString(this.pilha));
    }

    void push(String var) {
        if (isFull()) {
            System.out.println("OverFlow");
        } else {
            System.out.println("Inserting \"" + var + "\"");
            pilha[++top] = var;
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("UnderFlow");
        } else {
            System.out.println("Removing \"" + peek() + "\"");
            pilha[top--] = null;
        }
    }

    private String peek() {
        if (!isEmpty()) {
            return pilha[top];
        } else {
            return "-1";
        }
    }

    private Boolean isEmpty() {
        return top == -1;
    }

    private Boolean isFull() {
        return top == capacity - 1;
    }
}

public class Main {

    public static void main(String[] args) {
        List<String> functions = new ArrayList<String>();
        functions.add("2 * x + y");
        functions.add("num1 / (num2 + num3) * 100");
        functions.add("a - 2.5 * b + 3.6 / c");
        functions.forEach(func -> {
            func = func.replaceAll("([() ])", "");
            String[] vars = func.split("([-+*/])");
            Pilha stack = new Pilha(vars.length);
            for (String var : vars) { stack.push(var); }
            stack.show();
            for (int i = 0; i < vars.length; i++) { stack.pop(); }
            stack.show();
            System.out.println();
        });
    }
}
