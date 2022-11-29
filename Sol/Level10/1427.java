/***********************************************************************************************
1427 : 소트인사이드

배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
입력
첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.


ex)
input
2143

output
4321
************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main
{    
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	            
        String strNum = bfr.readLine();
        Integer[] arrNum = new Integer[strNum.length()];

        for(int i = 0 ; i<strNum.length(); i++)
        {
            arrNum[i] = strNum.charAt(i) - '0';
        }

        Arrays.sort(arrNum,Collections.reverseOrder());
        
        for(int i = 0 ; i<strNum.length();i++)
        {
            System.out.print(arrNum[i]);
        }

    }   
}
