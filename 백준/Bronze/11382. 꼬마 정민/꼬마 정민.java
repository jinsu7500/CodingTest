import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {  
        //BufferReader,BufferWriter 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));       

        //Stringtokenizer        
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.print(A+B+C);
    }
}
