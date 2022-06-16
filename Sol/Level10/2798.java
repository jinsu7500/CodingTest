/************************************************************************************************/
/* 2798번 : 블랙잭
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        //카드의 갯수
        int N = Integer.parseInt(st.nextToken());

        //목표 카드숫자
        int M = Integer.parseInt(st.nextToken());

        int [] caryArray = new int[N];

        StringTokenizer st2 = new StringTokenizer(bfr.readLine());
        
        for(int i = 0; i<N ; i++)
        {
            caryArray[i] = Integer.parseInt(st2.nextToken());
        }

        int max = 0;

        //첫번째 카드 선택
        for(int i = 0 ; i< N-2 ; i++)
        {
            //두번째 카드 선택
            for(int j = i+1 ; j < N-1 ; j++)
            {
                //세번째 카드 선택
                for(int k = j+1 ; k < N ; k++)
                {
                    int sum = caryArray[i] + caryArray[j] + caryArray[k];
                    if(sum <= M)
                    {
                        max = Math.max(max,sum);
                    }
                    if(max == M)
                    {
                        System.out.println(max);
                        return;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
