

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n= Integer.parseInt(br.readLine());
		
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num= Integer.parseInt(st.nextToken()); 
			if(hashMap.containsKey(num)) {
				int value=hashMap.get(num);
				hashMap.replace(num, ++value);
				continue;
			}
			hashMap.put(num, 1);
		}
		
		int m= Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m;i++) {
			int cardNum= Integer.parseInt(st.nextToken()); 
			if(!hashMap.containsKey(cardNum)) {
				bw.write("0 ");
				continue;
			}
			bw.write(hashMap.get(cardNum)+" "); 
			
		}
		bw.flush();   //남아있는 데이터를 모두 출력시킴
		bw.close();   //스트림을 닫음
		
		// TODO Auto-generated method stub
		

	}

}
