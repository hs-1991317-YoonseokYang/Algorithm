import java.io.*;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution()  throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        long sum=0;
        st=new StringTokenizer(br.readLine());
        int numberOfToken=st.countTokens();
        for(int i=0;i<numberOfToken;i++)//이렇게 하면 문제가 되는구나
            sum+=Long.parseLong(st.nextToken());
        bw.write(String.valueOf(sum));
        bw.flush();

        br.close();
        bw.close();
    }

}