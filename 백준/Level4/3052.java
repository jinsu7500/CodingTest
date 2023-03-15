/************************************************************************************************/
/* 3052번 : 나머지
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] input = new int[10];       
        boolean bl;
        int cnt = 0; 

        //input
        for(int i=0; i<input.length ; i++)
        {
            input[i] = Integer.parseInt(bfr.readLine()) % 42;            
        }
        
        //sol
        for(int i=0; i<input.length; i++ ) 
        {
			bl = false; 
			for(int k=i+1; k<input.length; k++ ) 
            {
				if( input[i] == input[k] ) 
                { 
					bl = true;
					break; 
				}
			}
			if( bl == false ) {
				cnt++; 
			} 
		}
                
        //output        
        System.out.println(cnt);
    }
}
