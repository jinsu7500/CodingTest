import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// import LV2.SelfTicTactoe;
public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        long N = Long.parseLong(bfr.readLine());

        System.out.println(4*N);
    

    }
}

