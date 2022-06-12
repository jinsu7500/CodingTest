
/************************************************************************************************/
/* 11653번 : 소인수분해
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bfr.readLine());
		primeFactorization(N);

	}

	public static void primeFactorization(int num) {
		for(int i=2 ; i <= Math.sqrt(num); i++) {
			while(num % i == 0)
			{
				System.out.println(i);
				num /= i;
			}
		}
		if(num != 1)
		{
			System.out.println(num);
		}		
	}
}

