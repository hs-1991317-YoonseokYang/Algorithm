

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
	
			int a=in.nextInt();
			int b=in.nextInt();
			
			
			int tmp;
			if(a>b) {
				tmp=a; a=b; b=tmp;
			}
			
			int g=0;
			
			if(b%a==0)
				g=a;
			else {
				for(int i=a/2;i>0;i--) {
					if(a%i==0&&b%i==0) {
						g=i; break;
					}
				}
			}
			
			int aa=a/g;//소인수
			
			System.out.println(g);
			System.out.println(aa*b);
			
			
			
	
		
				
	}

}
