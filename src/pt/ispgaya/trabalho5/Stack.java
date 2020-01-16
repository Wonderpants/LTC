package pt.ispgaya.trabalho5;

public class Stack {
    static
    class StringStack {

        private String[] stackArray;
        private int top;

        public StringStack() {
            stackArray = new String[30];
            top = -1;
        }

        public void push(String j) {
            stackArray[++top] = j;
        }

        public void pop() {
            top--;
        }

        public String peek() {
            return stackArray[top];
        }
    }

    static
    class CharStack {

        private Character[] stackArray;
        private int top;

        public CharStack() {
            stackArray = new Character[30];
            top = -1;
        }

        public void push(Character j) {
            stackArray[++top] = j;
        }

        public Character pop() {
            return stackArray[top--];
        }

        public Character peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return (top != -1);
        }
    }
}