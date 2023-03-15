
/************************************************************************************************/
/* 1330번 : 두 수 비교하기
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //입력
        StringTokenizer st = new StringTokenizer(bfr.readLine()," ");

        //입력
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());   

        if(A > B)
        {
            System.out.println(">");
        }
        else if(A < B)
        {
            System.out.println("<");
        }
        else
        {
            System.out.println("==");
        }
    }
}
