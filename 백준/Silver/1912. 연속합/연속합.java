

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
//		int n= Integer.parseInt(br.readLine());
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] array=new int[n];
		int[] sumArray=new int[n];
		
		for(int i=0;i<n;i++)
			array[i]= in.nextInt();
		
		sumArray[0]= array[0];
		for(int i=1;i<n;i++) {
		
			if(sumArray[i-1]>0)
				sumArray[i]=sumArray[i-1] + array[i];
			else
				sumArray[i]=array[i];
			
		}
		
		System.out.print(findMax(sumArray));
	}
	
	public static int findMax(int[] array) {
		int len= array.length;
		
		if(len==0)
			System.out.print("빈배열");
		
		int max=array[0];
		
		for(int i=1;i<len;i++) {
			if(array[i]>max)
				max=array[i];
		}
		return max;
	}

}
