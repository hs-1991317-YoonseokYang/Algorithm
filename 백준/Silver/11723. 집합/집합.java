import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
//		
		Set set= new Set();
		
//		int M = in.nextInt();
		int M = Integer.parseInt(br.readLine());
		
		String operation;
		int num;
		
		for(int i=0;i<M;i++) {
			String[] str=br.readLine().split("\\s");
			//operation = in.next();
			
			switch(str[0]) {
				
				case "add":
					num=Integer.valueOf(str[1]);
					set.add(num);
					break;
				case "remove":
					num=Integer.valueOf(str[1]);
					set.remove(num);
					break;
				case "check":
					num=Integer.valueOf(str[1]);
					bw.write(String.valueOf(set.check(num)));
					bw.write("\n");
//					System.out.println(set.check(num));
					break;
				case "toggle":
					num=Integer.valueOf(str[1]);
					set.toggle(num);
					break;
				case "all":
					set.all();
					break;
				case "empty":
					set.empty();
					break;
			}
		}
        bw.flush();
        bw.close();

	}

}

class Set {
	
//	private static HashSet<String> hashSet= new HashSet<String>();
	private static int[] array= new int[21];
	
	public Set() {}
	
	public void add(int num) {
		array[num]=1;
	}
	
	public void remove(int num) {
		array[num]=0;
	}
	public int check(int num) {
		return array[num]==1 ? 1 : 0;
	}
	
	public void toggle(int num) {
		if(array[num]==1)
			array[num]=0;
		else
			array[num]=1;
	}
	
	public void all() {
		for(int i=1;i<=20;i++)
			array[i]=1;
	}
	
	public void empty() {
		Arrays.fill(array, 0);
	}
	
	
	
	
}
