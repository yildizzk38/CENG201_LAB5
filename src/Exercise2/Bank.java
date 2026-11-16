package Exercise2;

public class Bank {
    private String[] tellers;
    private Queue waitingQueue;
    public Bank() {
        // Step 1: Create a String array with 3 elements for tellers.
        tellers = new String[3];
        // Step 2: Initialize all teller positions as null.
        for (int i = 0; i < tellers.length; i++) {
            tellers[i] = null;
        }
        // Step 3: Create a waiting Queue object.
        waitingQueue = new Queue();
    }
    public void arrive(String customerName) {
        // Step 1: Display the customer's arrival message.
        System.out.println("\nCustomer " + customerName + " arrived.");
        // Step 2 & 3: Search for an available teller (null value).
        for (int i = 0; i < tellers.length; i++) {
            if (tellers[i] == null) {
                tellers[i] = customerName;
                System.out.println(customerName + " is assigned to Teller " + (i + 1) + ".");
                return;
            }
        }
        // Step 4: If all tellers are busy, add customer to waitingQueue.
        waitingQueue.enqueue(customerName);
        System.out.println("All tellers are busy.");
        System.out.println(customerName + " joins the waiting queue.");
    }
    public void completeTransaction(int tellerNumber) {
        // Step 1: Validate tellerNumber (must be between 1 and 3).
        if (tellerNumber < 1 || tellerNumber > 3) {
            System.out.println("Invalid teller number!");
            return;
        }
        int index = tellerNumber - 1;
        // Step 2: Check whether the teller is already available.
        if (tellers[index] == null) {
            System.out.println("Teller " + tellerNumber + " is already available.");
            return;
        }
        // Step 3: Display the completed customer's name.
        System.out.println("\nTeller " + tellerNumber + " completed " + tellers[index] + "'s transaction.");
        // Step 4: Set the selected teller position to null.
        tellers[index] = null;
        // Step 5: Assign next waiting customer to this teller.
        assignNextCustomer(tellerNumber);
    }
    public void assignNextCustomer(int tellerNumber) {
        // Step 1 & 2: Check whether there are customers waiting.
        if (!waitingQueue.isEmpty()) {
            String nextCustomer = waitingQueue.dequeue();
            tellers[tellerNumber - 1] = nextCustomer;
            System.out.println(nextCustomer + " is assigned to Teller " + tellerNumber + ".");
        }
    }
    public void displayStatus() {
        System.out.println("\n---------- BANK STATUS ----------");
        for (int i = 0; i < tellers.length; i++) {
            System.out.print("Teller " + (i + 1) + ": ");
            if (tellers[i] == null) {
                System.out.println("Available");
            } else {
                System.out.println(tellers[i]);
            }
        }
        System.out.print("Waiting Queue: ");
        waitingQueue.display();
        System.out.println("---------------------------------");
    }
}
