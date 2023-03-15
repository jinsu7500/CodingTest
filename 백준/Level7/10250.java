/************************************************************************************************/
/* 10250번 : ACM 호텔
/************************************************************************************************/

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		

		//testcase
		int T = Integer.parseInt(bfr.readLine());

		for(int i = 0 ; i<T ; i++)
		{
			StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");
			//height
			int H = Integer.parseInt(st.nextToken());
			//width
			int W = Integer.parseInt(st.nextToken());
			//N
			int N = Integer.parseInt(st.nextToken());

			// 순서 / 층수 = 호실수 (올림처리)
			// 순서 % 층수 = 층수
			// 제한 width? -> 필요없음

			if(N % H == 0)
			{
				int YY = H * 100;
				int XX = N / H;
				System.out.println(YY + XX);					
			}
			else			
			{
				int YY = (N % H) * 100;
				int XX = (N / H) + 1;
				System.out.println(YY + XX);				
			}
		}
	}
}
