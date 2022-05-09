/************************************************************************************************/
/* 1065번 : 한수
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {  
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(hansu(Integer.parseInt(bfr.readLine())));
    }

    public static int hansu(int num)
    {
        int count = 0;
        if(num < 100)
        {
            return num;
        }
        else
        {
            count = 99;
            for(int i = 100; i <num+1 ; i++)
            {
                int hundread = i/100;
                int ten = (i/10) % 10;
                int one = i % 10;

                if((hundread - ten) == (ten - one))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
