/************************************************************************************************/
/* 11720번 : 숫자의 합
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main
{
    public static void main(String arg[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bfr.readLine());

        String[] input = bfr.readLine().split("");        
        int sum = 0;

        for(int i = 0 ; i < n ; i++)
        {
            sum += Integer.parseInt(input[i]);
        }

        bfw.write(String.valueOf(sum));
        bfw.flush();        
        bfw.close();
    }
}
