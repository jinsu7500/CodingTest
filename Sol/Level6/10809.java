/************************************************************************************************/
/* 10809번 : 알파벳 찾기
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));        

        //arr
        int[] outputArr = new int[26];
        Arrays.fill(outputArr, -1);

        //input
        String S = bfr.readLine();
        char[] inputArr = new char[S.length()];

        // 소문자 a의 아스키코드 97
        for(int i = 0 ; i< S.length(); i++)
        {
            inputArr[i] = S.charAt(i);
            //System.out.println(inputArr[i]- 97);
            if(outputArr[inputArr[i]- 97] == -1)
            {
                outputArr[inputArr[i]- 97] = i;
            }            
        }
        for(int j = 0 ; j<26 ; j++)
        {
            System.out.print(outputArr[j] + " ");
        }
    }
}
