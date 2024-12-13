
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		PriorityQueue<Member> pq= new PriorityQueue<>();
		
		int n= in.nextInt();
		
		for(int i=0;i<n;i++) {
			int age=in.nextInt();
			String name=in.next();
			pq.add(new Member(age,name,i));
		}
		
		while(!pq.isEmpty()) {
			Member m=pq.poll();
			System.out.println(m.getAge()+" "+m.getName());
		}
	}
}

class Member implements Comparable<Member>{
	
	private String name;
	private int age;
	private int id;
	
	public Member(int age,String name, int id) {
		this.name=name;
		this.age=age;
		this.id=id;
	}
	

	@Override
	public int compareTo(Member o) {
		
		if(age <o.age)
			return -1;
		else if(age>o.age)
			return 1;
		else if(age==o.age)
			if(id<o.id)
				return -1;
			else
				return 1;
		return 0;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	
}

