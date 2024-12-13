

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input=br.readLine();
		int n= Integer.parseInt(input);
		
		PriorityQueue<Integer> pq= new PriorityQueue<>(n);
		
		
		
		for(int i=0;i<n;i++) {
			input=br.readLine();
			int num=Integer.parseInt(input);
			pq.add(num);
		}
		
		StringBuilder sb= new StringBuilder();
		while(!pq.isEmpty()) {
			int a=pq.poll();
			sb.append(a).append('\n');
		}
		System.out.print(sb);
	}
	
}
