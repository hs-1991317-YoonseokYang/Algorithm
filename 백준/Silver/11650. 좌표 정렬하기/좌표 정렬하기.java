

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String token[]=new String[2];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		for(int i=0; i<n;i++) {
			token=br.readLine().split(" ");
			pq.add(new Point(Integer.parseInt(token[0]),Integer.parseInt(token[1])));
		}
		
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<n; i++) {
			Point point=pq.poll();
			sb.append(point.a+" "+point.b).append("\n");
		}
		
		System.out.print(sb);
	}

}

class Point implements Comparable<Point>{
	int a, b;
	
	public Point(int a,int b) {
		this.a=a;
		this.b=b;
	}
	
	@Override
	public int compareTo(Point point) {
		if(a<point.a)
			return -1;
		else if(a>point.a)
			return 1;
		else if(a==point.a) {
			if(b<point.b)
				return -1;
			else
				return 1;
		}
			
		return 0;
	}
	
}
