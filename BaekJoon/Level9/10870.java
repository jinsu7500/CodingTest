/************************************************************************************************/
/* 10870번 : 피보나치 수 5 ( 재귀함수 활용)
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bfr.readLine());
		System.out.println(fibonacci(N));
		

		
	}

	public static int fibonacci(int N)
	{		
		if(N <= 1 )
			return N;
		else
		{
			return fibonacci(N-1) + fibonacci(N-2);
		}
	}
}
