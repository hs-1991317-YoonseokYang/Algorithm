import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            operater(a,b);
        }
    }
    
    public static void operater(int a, int b){
       System.out.println(a+b);
        
    }
}