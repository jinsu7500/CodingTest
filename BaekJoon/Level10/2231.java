/************************************************************************************************/
/* 2231번 : 분해합
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //input
        int N = Integer.parseInt(bfr.readLine());
        //자리수
        int cipher = String.valueOf(N).length();
        //시작 최소값
        int startPoint = N - (9 * cipher);        
        //생성자
        int constructor = 0;

        for(int i = startPoint ; i<N ; i++)
        {
            int sum = i;
            int k = i;
            while(k > 0)            
            {
                sum += k%10;
                k /= 10;
            }
            if(sum == N)            
            {
                constructor = i;
                break;
            }
        }
        System.out.println(constructor);
    }
}
