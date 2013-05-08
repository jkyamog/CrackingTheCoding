package cracking.the.coding;

import java.util.Stack;

public class StackSort {

	public static void main(String[] args) {
		
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();
		
		a.push(3);
		a.push(2);
		a.push(4);
		a.push(1);

		while(!a.empty()) {
			if (b.empty() || a.peek().compareTo(b.peek()) == -1) {
				System.out.println("first");
				b.push(a.pop());
			} else {
				Integer t = a.pop();
				System.out.println("second " + t);
				while (!b.empty() && t.compareTo(b.peek()) == 1) {
					a.push(b.pop());
				}
				b.push(t);
			}
		}
		
		while(!b.empty()) {
			System.out.println(b.pop());
		}
	}

}
