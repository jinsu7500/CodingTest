
/************************************************************************************************/
/* 11654번 : 아스키 코드
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
                
        bfw.write(String.valueOf(bfr.read()));
        bfw.flush();        
        bfw.close();
    }
}
