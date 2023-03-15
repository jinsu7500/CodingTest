/************************************************************************************************/
/* 8393번 : 합
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
        int temp = 0;
        
        for(int i = 1 ; i < T+1 ; i++)
        {
            temp += i;
        }       
        System.out.println(temp); 
    }
}
