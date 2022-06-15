/************************************************************************************************/
/* 4948번 : 베르트랑 공준
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {	
		boolean trigger = true;
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		while(trigger)
		{
			
			int input = Integer.parseInt(bfr.readLine());
			int count = 0;

			if(input == 0 )
			{
				trigger = false;
				//System.out.println(count);
				break;
			}

			for(int i = input+1; i<= (input*2) ; i++)
			{
				if(checkIsPrimeNumber(i) && i != 1)
				{
					count++;
				}
			}
			System.out.println(count);
		}		
	}

	// 	//소수 체크
	public static boolean checkIsPrimeNumber(int num) {
		for(int i=2 ; i*i<=num; i++) {
			if(num%i ==0) {
				return false; //num이 i의 배수면 소수가 아니므로 false
			}
		}
		return true;
	}

}
		
