package Exercise1;

public class QueueDemo {
    public static void main(String[] args) {
        String[] students = {
                "Ali", "Ayse", "Mehmet", "Zeynep", "Ahmet",
                "Elif", "Mustafa", "Fatma", "Can", "Ece",
                "Burak", "Deniz", "Emre", "Selin", "Mert",
                "Ceren", "Kerem", "Dilan", "Onur", "Seda"
        };
        // Create your Queue object with capacity 10.
        Queue<String> queue = new Queue<>(10);
        // Insert the first 10 student names into the queue.
        for (int i = 0; i < 10; i++) {
            queue.enqueue(students[i]);
        }
        // Display the original queue.
        System.out.println("Original Queue: " + queue);
        // Display the queue size.
        System.out.println("Queue Size: " + queue.size());
        // Display the first student using peek().
        System.out.println("First Student: " + queue.peek());
        // Remove three students using dequeue().
        System.out.println("\nRemoving three students:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Removed: " + queue.dequeue());
        }
        // Display the remaining queue.
        System.out.println("\nQueue After Removal: " + queue);
        // Display the final queue size.
        System.out.println("Final Queue Size: " + queue.size());

    }
}
