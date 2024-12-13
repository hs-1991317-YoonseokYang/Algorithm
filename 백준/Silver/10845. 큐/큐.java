

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Scanner in = new Scanner(System.in);
		Queue queue = new Queue();
		int n= in.nextInt();
		//List<Integer>list = new ArrayList<>();
		//list.g
		for(int i=0;i<n;i++) {
			String str=in.next();
			
			switch(str) {
			 case "push": 
				 int x=in.nextInt();
				 queue.push(x);
				 break;
			 case "front":
				 System.out.println(queue.front());
				 break;
			 case "back":
				 System.out.println(queue.back());
				 break;
			 case "size":
				 System.out.println(queue.size());
				 break;
			 case "empty":
				 System.out.println(queue.empty());
				 break;
			 case "pop":
				 System.out.println(queue.pop());
				 break;
			}
			
		}
	}
}

class Queue{
	private final int MAX=10000;
	private int[] list;
	private int front;
	private int back;
	
	public Queue() {
		list= new int[MAX];
		front=0; back=0;
	}
	
	
	public void push(int n) {
		back++;
		list[back%MAX]=n;
	}
	
	public int empty() {
		if(front%MAX==back%MAX)//원형큐를 만드려던 시도
			return 1;
		else return 0;
	}
	
	public int pop() {
		if(empty()==1)
			return -1;
		return list[1+front++];//이거 어떡하지?
	}
	
	public int size() {
		if(empty()==1)
			return 0;
		return back-front;
	}
	
	public int front() {
		if(empty()==1)
			return -1;
		return list[front+1];
	}
		
		public int back() {
			if(empty()==1)
				return -1;
			return list[back];
	}
	
	
}
