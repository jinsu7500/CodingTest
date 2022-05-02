
/************************************************************************************************/
/* 2577번 : 숫자의 개수
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
public class Main
{
    public static void main(String[] args)throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));        

        //입력
        int A = Integer.parseInt(bfr.readLine());
        int B = Integer.parseInt(bfr.readLine());
        int C = Integer.parseInt(bfr.readLine());
        int number = A * B * C;
        int[] digits = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();   
        int[] count = new int[10];             

        //sol
        for(int i =0; i<digits.length; i++)
        {
            for(int j = 0; j<count.length ; j++)
            {
                if(digits[i] == j)
                {
                    count[j] +=1;                    
                }
            }
        }

        //output
        for(int k = 0 ; k<count.length; k++)
        {
            bfw.write(String.valueOf(count[k]) + "\n");
        }
        bfw.flush();
    }
}
