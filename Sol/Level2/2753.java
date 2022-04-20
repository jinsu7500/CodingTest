/************************************************************************************************/
/* 2753번 : 윤년
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
        int year = Integer.parseInt(bfr.readLine());

        //4의 배수
        if(year % 4 == 0)
        {
            if((year % 100) != 0 || (year % 400) == 0)
            {
                System.out.println(1);
            }
            else
            {
                System.out.println(0);
            }
        }
        else
        {
            System.out.println(0);
        }
    }
}
