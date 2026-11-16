package Exercise2;

public class Node {
    String customerName;
    Node next;
    public Node(String customerName) {
        // Step 1: Store the customer's name.
        this.customerName = customerName;
        // Step 2: Initialize the next pointer as null.
        this.next = null;
    }
}
