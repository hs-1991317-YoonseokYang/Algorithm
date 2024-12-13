
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		
		int result=factorial(n,k)/factorial(k);
		
		System.out.print(result);
		
	}
	
	public static int factorial(int n, int k) {
		int result=1;
		int c=n-k;
		for(int i=n;i>c;i--) {
			result= result*i;
		}
		return result;
	}
	
	public static int factorial(int n) {
		int result=1;
		for(int i=n;i>1;i--)
			result*=i;
		return result;
	}
	
	
	
	
}