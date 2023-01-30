/************************************************************************************************/
/* 10871번 : X보다 작은 수
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		//output
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		//공백으로 split
		StringTokenizer st = new StringTokenizer(bfr.readLine());		
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		//수열A input
		st = new StringTokenizer(bfr.readLine());
		
		for(int i = 0 ; i < N ; i++) 
		{
			int arr = Integer.parseInt(st.nextToken());
			if(arr < X) 
			{
				bfw.write(arr + " ");
			}
		}	 
		
		bfr.close();
		bfw.flush();
		bfw.close();
	}
}
