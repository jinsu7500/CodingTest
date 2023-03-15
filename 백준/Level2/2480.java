/************************************************************************************************/
/* 2480번 : 주사위 세개
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
        StringTokenizer st = new StringTokenizer(bfr.readLine()," ");       

        //분리
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int three = Integer.parseInt(st.nextToken());

        //계산        
        if(one == two && two == three)
        {
            System.out.println(10000 + (one * 1000));
        }
        else if(one == two || one == three)
        {
            System.out.println( 1000 + (one * 100));
        }
        else if(two == three)
        {
            System.out.println(1000 + (two * 100));
        }
        else
        {
            System.out.println((Math.max(one, Math.max(two, three)) * 100));
        }
    }
}
