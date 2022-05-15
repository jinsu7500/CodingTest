//************************************************************************************************/
/* 2908번 : 상수
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] Args) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));             
        
        //input
        String str = bfr.readLine();
        StringBuffer sb = new StringBuffer(str);

        //reverse
        String reverseStr = sb.reverse().toString();

        //split
        StringTokenizer st = new StringTokenizer(reverseStr," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        //output
        if(A>B)
        {
            System.out.println(A);
        }
        else
        {
            System.out.println(B);
        }
    }
}
