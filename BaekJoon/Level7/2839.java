
/************************************************************************************************/
/* 2839번 : 설탕 배달
/************************************************************************************************/

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		//설탕 목표 KG
		int N = Integer.parseInt(bfr.readLine());

		int count = 0;

		// if (N == 4 || N == 7) {
		// 	System.out.println(-1);
		// }
		// else if (N % 5 == 0) {
		// 	System.out.println(N / 5);
		// }
		// else if (N % 5 == 1 || N % 5 == 3) {
		// 	System.out.println((N / 5) + 1);
		// }
		// else if (N % 5 == 2 || N % 5 == 4) {
		// 	System.out.println((N / 5) + 2);
		// }
		for(;;)		
		{
			if(N%5 == 0)
			{
				System.out.println(N/5 + count);
				break;
			}
			else if(N <= 0)
			{
				System.out.println(-1);
				break;
			}
			N -= 3;
			count++;
		}
	}
}
