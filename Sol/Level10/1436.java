/************************************************************************************************/
/* 1436번: 영화감독 숌
/************************************************************************************************/     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //input
        int N = Integer.parseInt(bfr.readLine());

        System.out.println(endOfDay(N));
    }

    public static int endOfDay(int N)
    {
        /**
         * 666,1666,2666,3666,4666,5666,6666,7666,8666,9666,10666,11666,12666,13666,14666,15666,16660,16666,...
	 * String에서 666을 검색, 브루트 포스 알고리즘 활용
         */
        int count = 0;
        int temp = 0;
        for(;;)
        {
            String name = Integer.toString(temp);
            if(name.contains("666"))
            {
                count++;
                if(count == N)
                {
                    return temp;
                }            
            }
            temp++;
        }
    }
}
