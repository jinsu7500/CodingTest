
/************************************************************************************************/
/* 2292번 : 벌집
/************************************************************************************************/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
	//1열이 증가할때마다 6배수로 방이 커짐
	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bfr.readLine());
		int count = 1;
		int range = 2;

		if(N == 1)
		{
			System.out.println(1);
		}
		else
		{
			while(range <= N)
			{
				range = range + (count * 6);
				count++;
			}
			System.out.println(count);
		}

	}
}
