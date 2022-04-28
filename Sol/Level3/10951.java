/************************************************************************************************/
/* 10951번 : A+B - 4
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
		String str;
		while((str = bfr.readLine()) != null)
		{
			//공백으로 split
			StringTokenizer st = new StringTokenizer(str);
			
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			bfw.write(A+B +"\n");
				 		
		}	 
		
		bfr.close();
		bfw.flush();
		bfw.close();
	}
}
