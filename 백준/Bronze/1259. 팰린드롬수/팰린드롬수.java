import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			
			while(true) {
				
				String input = in.next();
				
				if(input.equals("0"))
					break;
				
				
				StringBuilder original=new StringBuilder(input);
				StringBuilder reversed=new StringBuilder(input).reverse();
				
				
				//System.out.println("로그"+str.toString());
				
				//System.out.println("로그"+str.reverse().toString());
				
				//System.out.println(str.reverse().toString().equals(str.toString()));
				
			
				if(original.toString().equals(reversed.toString()))
					System.out.println("yes");
				else
					System.out.println("no");
				
			}
			
	}

}