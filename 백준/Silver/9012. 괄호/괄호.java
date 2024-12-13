

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine()); 
		
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			int sum=0;
			for(int t=0;t<str.length();t++) {
				if(str.charAt(t)=='(')sum++;
				else if(str.charAt(t)==')')sum--;
				if(sum<0) {
					System.out.println("NO");
					break;
				}
			}
			if(sum==0)
				System.out.println("YES");
			else if(sum>0)
				System.out.println("NO");
			
		
		}
	}

}
