package Practice;

import java.util.*;

public class StackPractice {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushes: " + stack);

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        
        System.out.println("Stack: " + stack);
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Stack after peek: " + stack);
        
//        System.out.println("Is stack empty? " + stack.isEmpty());
        
        System.out.println("Stack: " + stack);
        System.out.println("Position of 'Y': " + stack.search("Y"));
        System.out.println("Position of 'A': " + stack.search("A"));
        System.out.println("Position of 'A': " + stack.search(10));
        
        
    }
}
