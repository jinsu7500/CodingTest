/************************************************************************************************/
/* 1978번 : 소수 찾기
/************************************************************************************************/

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int count = 0;
		for(int i = 0 ; i < N ; i++)
		{
			int A = Integer.parseInt(st.nextToken());
			if(checkIsPrimeNumber(A) && A != 1)
			{
				count++;
			}
			
		}

		System.out.println(count);
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
