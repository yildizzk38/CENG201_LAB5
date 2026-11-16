package Exercise3;

public class Stack {
    private char[] items;
    private int top;
    public Stack(int capacity) {
        items = new char[capacity];
        top = -1;
    }
    public void push(char value) {
        // Step 1: Check whether the stack is full.
        if (isFull()) {
            System.out.println("Stack overflow!");
            return;
        }
        // Step 2: Increase top.
        top++;
        // Step 3: Insert the character at the top position.
        items[top] = value;
    }
    public char pop() {
        // Step 1: Check whether the stack is empty.
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return '\0';
        }
        // Step 2: Store the character at the top position.
        char poppedChar = items[top];
        // Step 3: Decrease top.
        top--;
        // Step 4: Return the removed character.
        return poppedChar;
    }
    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return items[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == items.length - 1;
    }
}
