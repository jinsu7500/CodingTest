/***********************************************************************************************
4153 : 직각삼각형
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;
public class Main
{   
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	                                                   

        int[] arr = new int[3];
        boolean flag = true;
        while(flag)
        {            
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for(int i =0 ; i<3; i++)
            {                
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] == 0)
                {
                    flag = false;                    
                    break;
                }                    
            }
            if(!flag)
                break;
            Arrays.sort(arr);
            if(Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2))
                System.out.println("right");
            else
                System.out.println("wrong");                
        }        
    }   
}
