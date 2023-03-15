/************************************************************************************************/
/* 2869번 : 달팽이는 올라가고싶다.
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine()," ");

		//낮에 올라가는 거리
		int A = Integer.parseInt(st.nextToken());
		//밤에 떨어지는 거리
		int B = Integer.parseInt(st.nextToken());
		//총 막대거리
		int V = Integer.parseInt(st.nextToken());

		int days = 0;

		days = (V - B) / (A -B);
		if((V - B) % (A - B) !=0)
		{
			days++;
		}

		System.out.println(days);

	}
}
