/************************************************************************************************/
/* 2675번 : 문자열 반복
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        //testCase
        int T = Integer.parseInt(bfr.readLine());

        for(int i = 0 ; i < T ; i++)
        {
            String input = bfr.readLine();                  
            StringTokenizer st = new StringTokenizer(input," ");

            //반복횟수
            int R = Integer.parseInt(st.nextToken());
            String arr = st.nextToken();
            
            //문자열 쪼개기
            String[] StringArray = arr.split(""); 

            //String output = "";
            //for(int j = 0 ; j<R ; j++)
            for(int k = 0 ; k<StringArray.length ; k++)
            {
                //for(int k = 0 ; k<StringArray.length ; k++)
                for(int j = 0 ; j<R ; j++)
                {
                    bfw.write(StringArray[k]);
                }
            } 
            bfw.write("\n");
        }
        bfw.flush();
        bfw.close();
    }
}
