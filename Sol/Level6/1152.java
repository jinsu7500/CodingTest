/************************************************************************************************/
/* 1152번 : 단어의 개수
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] Args) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        System.out.print(st.countTokens()); 
    }
}
