

import java.util.Scanner;

public class Main {
	
	static int [] memoization= new int[500001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		int num= in.nextInt();
		System.out.print(Main.function(num));
	}
	
	public static int function(int n) {
		int numberOfEvenNum;
		
		if(memoization[n]!=0)
			return memoization[n];
		
		if(n==1) {
			memoization[n]=1;
			return 1;
		}	
		else if(n%2==0) {//짝수라면
			numberOfEvenNum=n/2;
			memoization[n]= 2*function(numberOfEvenNum);
			return memoization[n];
		}
		else if(n%2==1) {//홀수
			numberOfEvenNum=(n-1)/2;
			memoization[n]= 2*(function(numberOfEvenNum+1)-1);
			return memoization[n];
		}
		else
			return 0;//실패?
	}

}
