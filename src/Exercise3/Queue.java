package Exercise3;

public class Queue {
    private char[] items;
    private int front;
    private int rear;
    private int count;
    public Queue(int capacity) {
        items = new char[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }
    public void enqueue(char value) {
        // Step 1: Check whether the queue is full.
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        // Step 2: Calculate the next rear position using circular indexing.
        rear = (rear + 1) % items.length;
        // Step 3: Insert the character into the array.
        items[rear] = value;
        // Step 4: Increase count.
        count++;
    }
    public char dequeue() {
        // Step 1: Check whether the queue is empty.
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return '\0';
        }
        // Step 2: Store the character at the front position.
        char removedChar = items[front];
        // Step 3: Move front to the next position using circular indexing.
        front = (front + 1) % items.length;
        // Step 4: Decrease count.
        count--;
        // Step 5: Return the removed character.
        return removedChar;
    }
    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return items[front];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == items.length;
    }
    public int size() {
        return count;
    }
}