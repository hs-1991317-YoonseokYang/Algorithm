import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int[] list= new int[3];
		
		while(true) {
		int flag=0;
		for(int i=0;i<list.length;i++) {
			list[i]=in.nextInt();
			if(list[i]==0)
				flag++;
		}
		if(flag==3)
			return;
		
		
		System.out.println(identifyRightAngleTriangle(list));
		}
		
	}
	
	public static String identifyRightAngleTriangle(int[] list) {
		int h=list[0];
			
		//int len=list.length; 
		
		for(int i=1; i<list.length;i++) {
			if(h<list[i])
				h=list[i];
		}
		
	
		
		int sum=0;
		for(int i=0;i<list.length;i++) {
			sum+=list[i]*list[i];
		}
		
		if(2*h*h==sum&& h!=0)
			return "right";
		else
			return "wrong";
					
		
	}

}
