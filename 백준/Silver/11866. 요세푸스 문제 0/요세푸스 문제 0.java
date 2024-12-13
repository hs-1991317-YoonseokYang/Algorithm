
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		boolean[] array= new boolean[1000];
		int counter=0;//k번째 수를 찾기위한 카운터
		int counter2=0;//n개 수를 모두 제거했는지 확인하기 위한 카운터
		int start=0;
		int iter=0;
		
		for (int i=0;i<n;i++)
			array[i]=true;
		
		
		System.out.print("<");
		while(true) {
			
			
			int tmp=start+iter;
			if(array[(tmp)%n]==true)
				counter++;
			
			if(counter==k) {//k번째 수를 찾았다면
				array[(start+iter)%n]=false;
				System.out.print((start+iter)%n+1);
				start=(start+iter)%n; // 위치를 갱신하기... <- 근데 그냥 끝난 부분에서 시작해도 됨?? ㅇㅇ 맞다맏음
				counter=0;
				iter=0;
				if(++counter2==n)
					break;
				
				System.out.print(", ");
				continue;
			}
		
				
			iter++;
			
			
			
		}
		
		System.out.print(">");
		
		
	}

}
