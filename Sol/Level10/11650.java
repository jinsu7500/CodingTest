/***********************************************************************************************
11650 : 좌표 정렬하기
2차원 평면 위의 점 N개가 주어진다. 
좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

5
3 4
1 1
1 -1
2 2
3 3

1 -1
1 1
2 2
3 3
3 4
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
        int count = Integer.parseInt(bfr.readLine());
        int array[][] = new int[count][2];
        
        //input
        for(int i = 0 ; i< count ; i++)
        {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            array[i][0] = Integer.parseInt(st.nextToken()); //x
            array[i][1] = Integer.parseInt(st.nextToken()); //y
        }

        //compare 
        Arrays.sort(array, (int[] x1, int[] x2 ) -> {

            if(x1[0] == x2[0]){
                return x1[1] - x2[1];
            }
            return  x1[0] - x2[0];
        });

        //output
        for(int i = 0 ; i<array.length; i++)
        {
            System.out.println(array[i][0] + " " + array[i][1]);
        }
    }   
}
