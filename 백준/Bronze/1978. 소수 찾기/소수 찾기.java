import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//에라토스테네스 체
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		boolean[] primeNumberList=makePrimeNumberList(1000);
		
		int n= in.nextInt();
		
		int count=0;
		for(int i=0;i<n;i++) {
			int a=in.nextInt();
			if(!primeNumberList[a])
				count++;
			
		}	
		System.out.print(count);
	}

	public static boolean[] makePrimeNumberList(int n){
		boolean[] check = new boolean[1001];
		//소수는 false
		check[0]=true;
		check[1]=true;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			//이미 소수가 아닌수로 판별됐다면 
			if(check[i]) continue;
        
			//소수가 아닌 수 true로 변경
			//자기 자신 제외한 수 ex)i=2, j=4,6,8,10,...
			//i*i 이하의 수는 이미 검사했으므로 i*i부터 시작
			for(int j=i*i; j<=n; j+=i) { 
				check[j]=true;
			}
		}
		return check;
	}

}
