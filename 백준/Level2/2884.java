/************************************************************************************************/
/* 2884번 : 알람 시계
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
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //입력
        StringTokenizer st = new StringTokenizer(bfr.readLine()," ");

        //분리
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //계산
        if(M < 45)
        {
            H--;
            M = 60 - (45 - M);
            if(H < 0)
            {
                H = 23;
            }       
            System.out.println(H + " " + M);            
        }
        else 
        {            
            System.out.println(H + " " + (M - 45));
        }        
    }
}
