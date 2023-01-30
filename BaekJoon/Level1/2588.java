/************************************************************************************************/
/* 2588번 : 곱셈
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int A = Integer.parseInt(bfr.readLine());
        int B = Integer.parseInt(bfr.readLine());   

        //1
        System.out.println(A * (B % 10));
        //10
        System.out.println(A * ( (B % 100) / 10));
        //100
        System.out.println(A * ( B / 100));     
        //result
        System.out.println(A*B);
    }
}
