/************************************************************************************************/
/* 2525번 : 오븐 시계
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
        int time = Integer.parseInt(bfr.readLine());

        //분리
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());        

        //계산
        M = M + time;
        while(M >= 60)
        {
            H++;
            M = M - 60;
            if(H > 23)
            {
                H = 0;
            }
        }        
        //출력
        System.out.println(H + " " + M); 
    }
}
