/************************************************************************************************/
/* 10872번 : 팩토리얼
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bfr.readLine());
		System.out.println(fatorial(N));

		
	}

	public static int fatorial(int N)
	{		
		if(N == 0)
			return 1;
		if(N <= 1 )
			return N;

		else
		{
			return fatorial(N-1) * N;
		}
	}
}
