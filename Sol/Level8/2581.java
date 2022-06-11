
/************************************************************************************************/
/* 2581번 : 소수
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(bfr.readLine());
		int N = Integer.parseInt(bfr.readLine());

		int sum = 0;
		int min = 0;
		boolean trigger = true;

		for(int i = M ; i <= N ; i++)
		{
			if(checkIsPrimeNumber(i) && i != 1)
			{
				sum += i;
				if(trigger)
				{
					min = i;
					trigger = false;
				}				
			}
		}
		if(sum != 0 || min != 0)
		{
			System.out.println(sum);
			System.out.println(min);
		}
		else
		{
			System.out.println(-1);
		}

	}

	public static boolean checkIsPrimeNumber(int num) {
	for(int i=2 ; i*i<=num; i++) {
		if(num%i ==0) {
			return false; //num이 i의 배수면 소수가 아니므로 false
		}
	}
	return true;
	}
}
