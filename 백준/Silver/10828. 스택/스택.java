

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner in = new Scanner(System.in);
		Stack stack = new Stack();
		int n= in.nextInt();
		
		for(int i=0;i<n;i++) {
			String str=in.next();
			
			switch(str) {
			 case "push": 
				 int x=in.nextInt();
				 stack.push(x);
				 break;
			 case "top":
				 System.out.println(stack.top());
				 break;
			 case "size":
				 System.out.println(stack.size());
				 break;
			 case "empty":
				 System.out.println(stack.empty());
				 break;
			 case "pop":
				 System.out.println(stack.pop());
				 break; 
			}
			
		}
	}
}

class Stack{
	private final int MAX=10000;
	private int[] list;
	private int top;
	
	public Stack() {
		list= new int[MAX];
		top=-1;
	}
	
	
	public void push(int n) {
		if(top==-1)
			top=0;
		else
			top++;
		list[top]=n;
	}
	
	public int empty() {
		if(top==-1)
			return 1;
		else return 0;
	}
	
	public int pop() {
		if(empty()==1)
			return -1;
		return list[top--];
	}
	
	public int size() {
		if(top==-1)
			return 0;
		return top+1;
	}
	
	public int top() {
		if(empty()==1)
			return -1;
		return list[top];
	}
	
	
}
