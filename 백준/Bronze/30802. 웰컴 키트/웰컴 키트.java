import java.util.Scanner;
import java.lang.Math;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int minTshirtOrder=0;
		int penOrder=0;
		int remainingPens=0;
		int n=in.nextInt();
		int[] sizeList = new int[6];
		
		
		for(int i=0;i<sizeList.length;i++) {
			sizeList[i]=in.nextInt();
		}
		
		int t= in.nextInt();
		int p= in.nextInt();
		
		for(int i=0;i<sizeList.length;i++) {
			minTshirtOrder+= (int)Math.ceil((double)sizeList[i]/t); 
		}
		
		System.out.println(minTshirtOrder);
		System.out.printf("%d ",penOrder=n/p);
		System.out.print(remainingPens=n%p);
		
		
	}
}