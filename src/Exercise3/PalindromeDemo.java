package Exercise3;

import java.util.Scanner;
public class PalindromeDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Step 1: Ask the user to enter a string.
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        // Step 2: Create a Stack and a Queue with the length of the input string as capacity.
        int length = text.length();
        Stack stack = new Stack(length);
        Queue queue = new Queue(length);
        // Step 3: Traverse the string from left to right.
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            stack.push(ch);
            queue.enqueue(ch);
        }
        // Step 4: Assume the string is a palindrome.
        boolean isPalindrome = true;
        // Step 5: Compare characters while the queue is not empty.
        while (!queue.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.dequeue();
            if (stackChar != queueChar) {
                isPalindrome = false;
                break; // Stop comparing if a mismatch is found.
            }
        }
        // Step 6: Display whether the string is a palindrome.
        if (isPalindrome) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
        input.close();
    }
}
