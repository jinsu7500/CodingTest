/***********************************************************************************************
25305 : 커트라인

2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 $N$명의 학생들이 응시했다.

이들 중 점수가 가장 높은 $k$명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.

커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

입력
첫째 줄에는 응시자의 수 $N$과 상을 받는 사람의 수 $k$가 공백을 사이에 두고 주어진다.

둘째 줄에는 각 학생의 점수 $x$가 공백을 사이에 두고 주어진다.

출력
상을 받는 커트라인을 출력하라.


ex)
input
5 2
100 76 85 93 98

output
98
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
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        
        int N = Integer.parseInt(st.nextToken());        
        int k = Integer.parseInt(st.nextToken());
        Integer[] array = new Integer[N];

        st = new StringTokenizer(bfr.readLine());
        //input
        for(int i = 0 ; i<N ; i++)
        {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array,Collections.reverseOrder());             
        
        System.out.println(array[k-1]);
    }   
}
