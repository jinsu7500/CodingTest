import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {  
        //BufferReader,BufferWriter 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));       

        int total = Integer.parseInt(bfr.readLine());
        int n = Integer.parseInt(bfr.readLine());

        int sum = 0;
        for(int i = 0 ; i< n ; i++){
            //Stringtokenizer        
            StringTokenizer st = new StringTokenizer(bfr.readLine());

            int price = Integer.parseInt(st.nextToken());
            int conut = Integer.parseInt(st.nextToken());
            sum += (price*conut);
        }

        if(total == sum)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
