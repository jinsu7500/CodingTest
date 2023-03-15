/************************************************************************************************/
/* 1712번 : 손익분기점
/************************************************************************************************/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
	//A+Bx == Cx ?
	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine()," ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int x = C - B;
		if(x <= 0)
			System.out.println(-1);
		else
			System.out.println((A / x) + 1);
	}
}
