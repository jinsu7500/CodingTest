/************************************************************************************************/
/* 2775번 : 부녀회장이 될테야
/************************************************************************************************/

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	
		//testCase
		int T = Integer.parseInt(bfr.readLine());
		
      // 시간초과남
		// for(int i = 0 ; i<T ; i++)
		// {
		// 	int sum = 0;
		// 	int k = Integer.parseInt(bfr.readLine());
		// 	int n = Integer.parseInt(bfr.readLine());

		// 	//k층까지
		// 	for(int j = 0 ; j<=k ;k++)			
		// 	{
		// 		//n호실까지
		// 		for(int l = n ; n>0 ; n--)
		// 		{
		// 			sum += n;
		// 		}
		// 	}
		// 	System.out.println(sum);
		// }

		int[][] apartment = new int[15][15];
		for(int i = 0 ; i< 15 ; i++)
		{
			apartment[i][1] = 1;		//각층의 1호실
			apartment[0][i] = i;		// 0층의 1~n호실
		}

		//1~14층까지
		for(int i = 1 ; i< 15; i++)
		{
			//2호실~14호실
			for(int j = 2 ; j<15 ; j++) 
			{
				apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
			}
		}

		for(int i = 0; i<T ; i++)
		{
			int k = Integer.parseInt(bfr.readLine());
			int n = Integer.parseInt(bfr.readLine());
			System.out.println(apartment[k][n]);;			
		}
		
	}
}
	
