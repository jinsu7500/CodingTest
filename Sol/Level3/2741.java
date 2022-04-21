/************************************************************************************************/
/* 2741번 : N 찍기
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int N = Integer.parseInt(bfr.readLine());

        for(int i = 1 ; i <= N ; i++)
        {            
            bfw.write(String.valueOf(i));
            bfw.write("\n");
        }    
        bfw.flush();    
    }
}
