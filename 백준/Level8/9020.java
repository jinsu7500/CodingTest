/************************************************************************************************/
/* 9020번 : 골드바흐의 추측
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bfr.readLine());
		int n = 0;			
		
		for(int i = 0 ; i< T ; i++)
		{
			n = Integer.parseInt(bfr.readLine());

			int a = n / 2;
			int b = n / 2;
			
			//a는 감소, b는 증가하면서 소수찾기
			while(true)
			{	
				if(checkIsPrimeNumber(a) && checkIsPrimeNumber(b))
				{
					System.out.println(a + " " + b);
					break;
				}
				else
				{
					a--;
					b++;
				}
			}

		}

	}

 	//소수 체크
	public static boolean checkIsPrimeNumber(int num) {
		for(int i=2 ; i*i<=num; i++) {
			if(num%i ==0) {
				return false; //num이 i의 배수면 소수가 아니므로 false
			}
		}
		return true;
	}
}
