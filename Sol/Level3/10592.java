/************************************************************************************************/
/* 10952번 : A+B -5
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
		
		for(;;) 
		{
			//공백으로 split
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			if(A == 0 && B == 0) 
			{
				break;
			}
			else 
			{
				bfw.write(A+B +"\n");
			}	 		
		}	 
		
		bfr.close();
		bfw.flush();
		bfw.close();
	}
}
