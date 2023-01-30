/************************************************************************************************/
/* 15552번 : 빠른 A + B
/************************************************************************************************/
// import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int T = Integer.parseInt(bfr.readLine());

        for(int i = 0 ; i<T ; i++)
        {
            StringTokenizer st = new StringTokenizer(bfr.readLine()," ");       
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bfw.write(String.valueOf(A + B));
            bfw.write("\n");
        }    
        bfw.flush();    
    }
}
