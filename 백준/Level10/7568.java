/************************************************************************************************/
/* 7568번 : 덩치
/************************************************************************************************/        

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        
        //사람수
        int N = Integer.parseInt(bfr.readLine());
        
        //배열선언
        int[][] arr = new int[N][2];

        //배열입력
        for(int i = 0 ; i<N ; i++)
        {
            StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");            
            //몸무게 입력
            arr[i][0] = Integer.parseInt(st.nextToken());
            //키 입력
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
       
        
        for(int i = 0 ; i< N ; i++)
        {
            int rank = 0;
            for(int j = 0 ; j<N; j++)
            {
                if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1])
                {
                    rank++;
                }
            }
            
            System.out.print(rank+1 +" ");
        }
        System.out.println();
    }
}
