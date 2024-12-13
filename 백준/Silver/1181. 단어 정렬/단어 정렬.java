import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hashSet= new HashSet<>();
		PriorityQueue<Word1> priorityQueue = new PriorityQueue<>();
		
		
		int n= Integer.parseInt(br.readLine());	
		
		for(int i=0;i<n;i++) {
			
			hashSet.add(br.readLine());
		}
		
		Iterator<String> i= hashSet.iterator();
		
		while(i.hasNext())
			priorityQueue.add(new Word1(i.next()));
		
		StringBuilder sb = new StringBuilder();
		while(!priorityQueue.isEmpty()) {
			Word1 word=priorityQueue.poll();
		      sb.append(word.str).append("\n");
		}
	    System.out.println(sb);


	}

}

class Word1 implements Comparable<Word1>{
	String str;
	int len;
	
	public Word1(String str) {
		this.str =str;
		this.len=str.length();
	}
	@Override
	public int compareTo(Word1 o) {
		if(this.len>o.len)
			return 1;
		else if(this.len<o.len)
			return -1;
		else if(this.len==o.len) {
			if(str.compareTo(o.str)<0)
				return -1;
			else if(str.compareTo(o.str)>0)
				return 1;	
				
		}
		return 0;
	}
}
