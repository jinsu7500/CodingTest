
/************************************************************************************************/
/* 9498번 : 시험 성적
/************************************************************************************************/
//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));        

        //입력
        int A = Integer.parseInt(bfr.readLine()); 
        
        if(A >= 90 )
        {
            System.out.println("A");
        }
        else if(A >= 80 && A <= 89)
        {
            System.out.println("B");
        }
        else if(A >= 70 && A <= 79 )
        {
            System.out.println("C");
        }
        else if(A >= 60 && A <= 69 )
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("F");
        }
    }
}
