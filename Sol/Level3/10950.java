/************************************************************************************************/
/* 10950번 : A + B - 3
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int T = Integer.parseInt(bfr.readLine());

        for(int i = 0 ; i<T ; i++)
        {
            StringTokenizer st = new StringTokenizer(bfr.readLine()," ");       
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(A + B);
        }        
    }
}
