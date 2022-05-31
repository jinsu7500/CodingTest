/************************************************************************************************/
/* 1316번 : 그룹 단어 체커 *****
/************************************************************************************************/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bfr.readLine());
		int count = N;		

		for(int i = 0 ; i < N ; i++)
		{
			String inputArr = bfr.readLine();
			boolean alphabet[] = new boolean[26];

			for(int j = 0 ; j<inputArr.length() - 1 ; j++)			
			{
				if(inputArr.charAt(j) != inputArr.charAt(j+1))
				{
					if(alphabet[inputArr.charAt(j+1) - 97] == true)
					{
						count--;
						break;
					}
				}
				alphabet[inputArr.charAt(j)-97] = true;
			}		
		}
		System.out.println(count);
	}
}


