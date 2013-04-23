package cracking.the.coding;

import java.util.ArrayList;
import java.util.List;

public class StackWithMin {
	
	public static class Stack {
		
		int stackPtr = -1;
		int minPtr = -1;
		
		List<Integer> stack = new ArrayList<Integer> ();
		List<Integer> minStack = new ArrayList<Integer> ();
		
		public void push(Integer object) {
			stackPtr++;
			stack.add(object);
			if (minPtr == -1 || (stack.get(stackPtr).compareTo(minStack.get(minPtr)) < 0)) {
				minPtr++;
				minStack.add(object);
			}
			
		}
		
		public Integer pop() {
			if (stackPtr > -1) {
				if (stack.get(stackPtr).compareTo(minStack.get(minPtr)) == 0) {
					minPtr--;
				}
				stackPtr--;
				
				return stack.get(stackPtr + 1);
			}
			return null;
		}
		
		public Integer min() {
			if (minPtr > -1) return minStack.get(minPtr);
			else return null;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("stack: ");
			for (int i = 0; i <= stackPtr; i++) {
				sb.append(stack.get(i) + " | ");
			}
			sb.append("minStack: ");
			for (int i = 0; i <= minPtr; i++) {
				sb.append(minStack.get(i) + " | ");
			}
			
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		
		StackWithMin.Stack stack = new StackWithMin.Stack();
		
		stack.push(7);
		stack.push(2);
		stack.push(9);
		System.out.println(stack.toString());
		System.out.println(new Integer(2).equals(stack.min()));
		
		stack.pop();
		stack.push(1);
		System.out.println(stack.toString());
		System.out.println(new Integer(2).equals(stack.min()));
		
		stack.pop();
		System.out.println(stack.toString());
		System.out.println(new Integer(2).equals(stack.min()));

		stack.pop();
		System.out.println(stack.toString());
		System.out.println(new Integer(7).equals(stack.min()));
		
		stack.pop();
		System.out.println(stack.toString());
		System.out.println(stack.min() == null);
	}

}
