/************************************************************************************************/
/* 1157번 : 단어 공부
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        //input
        String[] inputArr = bfr.readLine().toUpperCase().split(""); 
        int[] count = new int[26];
        Arrays.fill(count, 0);
        
        int max = -1;
        char statement = '?';

        for(int i = 0 ; i< inputArr.length; i++)
        {   
            //알파벳 카운트
            count[inputArr[i].charAt(0) - 65]++;

            //Max값 체크
            if(max < count[inputArr[i].charAt(0) - 65])
            {
                max = count[inputArr[i].charAt(0) - 65];
                statement = inputArr[i].charAt(0);
            }
            //MAX값이 두개일경우
            else if(max == (count[inputArr[i].charAt(0) - 65]) )
            {
                statement = '?';
            }
        }
        bfw.write(statement);
        bfw.flush();
        bfw.close();
    }
}
