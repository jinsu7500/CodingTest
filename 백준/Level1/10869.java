/************************************************************************************************/
/* 10869번 : 사칙연산
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //string 읽기
        String str = br.readLine();

        //공백 분리
        StringTokenizer st = new StringTokenizer(str," ");

        //입력선언
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //결과 출력
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
        
    }
}
