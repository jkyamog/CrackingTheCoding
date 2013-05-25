package cracking.the.coding;

import java.util.Stack;

/**
 * write a program to sort a stack in ascending order, you should not make any assumptions about how the 
 * stack is implemented.  The following are the only functions that should be used to write the program:
 * push | pop | peek | isEmpty
 */

public class C0306 {

	public static void main(String[] args) {
		
		Stack<Integer> a = new Stack<Integer>();
		
		a.push(3);
		a.push(2);
		a.push(4);
		a.push(1);
		
		Stack<Integer> b = sort(a);

		while(!b.empty()) {
			System.out.println(b.pop());
		}
	}
	
	public static Stack<Integer> sort(Stack<Integer> a) {
		Stack<Integer> b = new Stack<Integer>();
		while(!a.empty()) {
				int t = a.pop();
				while (!b.empty() && t > b.peek()) {
					a.push(b.pop());
				}
				b.push(t);
		}
		
		return b;
	}

}
