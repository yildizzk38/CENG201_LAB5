package Exercise1;

public class Queue<T> {
    private T[] items;
    private int front; // first element of the queue
    private int rear;  // last element of the queue
    private int count;
    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        items = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }
    public void enqueue(T value) {
        // Step 1: Check whether the queue is full.
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + value);
            return;
        }
        // Step 2: Calculate the next rear position.
        rear++;
        // Step 3: Insert the new element into the array.
        items[rear] = value;
        // Step 4: Increase count.
        count++;
    }
    public T dequeue() {
        // Check whether the queue is empty.
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        }
        // Store the element at the front position.
        T removedItem = items[front];
        items[front] = null;
        // Move front to the next position.
        front++;
        // Decrease count.
        count--;
        // Return the removed element.
        return removedItem;
    }
    public T peek() {
        // Check whether the queue is empty.
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        // Return the front element without removing it.
        return items[front];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        // Notice: In a linear (non-circular) array, it reaches the end when rear == items.length - 1
        return count == items.length || rear == items.length - 1;
    }
    public int size() {
        return count;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            int index = front + i;
            result.append(items[index]);
            if (i < count - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
