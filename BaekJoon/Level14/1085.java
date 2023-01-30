/***********************************************************************************************
1085: 직사각형에서 탈출
한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 
오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 x, y, w, h가 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다.
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
public class Main
{   
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	                                           
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        //now point
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        //top-right point        
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] array = new int[4];
        // 0 : h-y , 1 : w-x, 2 : y, d : x
        array[0] = h-y;
        array[1] = w-x;
        array[2] = y;
        array[3] = x;
        Arrays.sort(array);
        System.out.println(array[0]);        

    }   
}
