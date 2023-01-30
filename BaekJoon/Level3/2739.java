/************************************************************************************************/
/* 2739번 : 구구단
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
        int input = Integer.parseInt(bfr.readLine());

        for(int i = 1 ; i<10 ; i++)
        {
            System.out.println(input + " * " + i + " = " + (input * i));
        }        
    }
}
