/************************************************************************************************/
/* 1193번 : 분수찾기
/************************************************************************************************/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(bfr.readLine());

		int count =1;
		int sum =0;

		while(true)
		{
			if(X <= sum + count)
			{
				//대각선이 홀수일경우
				if(count % 2 == 1)
				{
					System.out.println((count - (X - sum -1) + "/" + (X-sum)));
					break;
				}

				//짝수일경우				
				else
				{
					System.out.println( (X-sum) + "/" + (count - (X - sum -1)));
					break;
				}
			}
			else
			{
				sum += count;
				count++;
			}
		}

	}
}
