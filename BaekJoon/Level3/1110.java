/************************************************************************************************/
/* 1110번 : 더하기 사이클
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		//output
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//orgNum
		int orgNum = Integer.parseInt(bfr.readLine());
		int resultNum = orgNum;
		int count = 0;
	
		//loop
		do
		{			
			orgNum = ((orgNum % 10) * 10) + (((orgNum / 10) + (orgNum % 10)) % 10);			
			count++;			
		}
		while(orgNum != resultNum);
		System.out.println(count);
	}
}
