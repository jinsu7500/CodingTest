/************************************************************************************************/
/* 1929번 : 소수 구하기
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		//1 <= M <= N <= 1,000,000
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		for(int i = M ; i<= N ; i++)
		{
			if(checkIsPrimeNumber(i) && i != 1)
			{
				System.out.println(i);
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
