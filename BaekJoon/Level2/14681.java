/************************************************************************************************/
/* 14681번 : 사분면 고르기
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int ptnX = Integer.parseInt(bfr.readLine());
        int ptnY = Integer.parseInt(bfr.readLine());

        if(ptnX > 0)
        {
            if(ptnY > 0)
            {
                System.out.println(1);
            }
            else
            {
                System.out.println(4);
            }
        }
        else
        {   
            if(ptnY > 0)
            {
                System.out.println(2);
            }
            else
            {
                System.out.println(3);
            }
        }
    }
}
