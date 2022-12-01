/***********************************************************************************************
1004: 어린왕자
어린 왕자는 소혹성 B-664에서 자신이 사랑하는 한 송이 장미를 위해 살아간다.
어느 날 장미가 위험에 빠지게 된 것을 알게 된 어린 왕자는, 장미를 구하기 위해 은하수를 따라 긴 여행을 하기 시작했다. 
하지만 어린 왕자의 우주선은 그렇게 좋지 않아서 행성계 간의 이동을 최대한 피해서 여행해야 한다. 아래의 그림은 어린 왕자가 펼쳐본 은하수 지도의 일부이다.


빨간 실선은 어린 왕자가 출발점에서 도착점까지 도달하는데 있어서 필요한 행성계 진입/이탈 횟수를 최소화하는 경로이며, 
원은 행성계의 경계를 의미한다. 이러한 경로는 여러 개 존재할 수 있지만 적어도 3번의 행성계 진입/이탈이 필요하다는 것을 알 수 있다.

위와 같은 은하수 지도, 출발점, 도착점이 주어졌을 때 
어린 왕자에게 필요한 최소의 행성계 진입/이탈 횟수를 구하는 프로그램을 작성해 보자. 
행성계의 경계가 맞닿거나 서로 교차하는 경우는 없다. 또한, 출발점이나 도착점이 행성계 경계에 걸쳐진 경우 역시 입력으로 주어지지 않는다.

입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
 그 다음 줄부터 각각의 테스트케이스에 대해 첫째 줄에 출발점 (x1, y1)과 도착점 (x2, y2)이 주어진다. 
 두 번째 줄에는 행성계의 개수 n이 주어지며, 세 번째 줄부터 n줄에 걸쳐 행성계의 중점과 반지름 (cx, cy, r)이 주어진다.

출력
각 테스트 케이스에 대해 어린 왕자가 거쳐야 할 최소의 행성계 진입/이탈 횟수를 출력한다.
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
        
        //testCase
        int T = Integer.parseInt(bfr.readLine());
        for(int testCase = 0 ;  testCase<T ; testCase++)
        {
            int result = 0;
            //Start,End Point
            StringTokenizer st = new StringTokenizer(bfr.readLine());      
            
            int x1 = Integer.parseInt(st.nextToken());  //startPoint x1
            int y1 = Integer.parseInt(st.nextToken()); // startPoint y1

            int x2 = Integer.parseInt(st.nextToken());  //endPoint x2
            int y2 = Integer.parseInt(st.nextToken());  //endPoint y2

            //planet count N
            int N = Integer.parseInt(bfr.readLine());
            //arr   0:cx, 1: cy , 2: r
            int[][] planetArr = new int[N][3];

            for(int i = 0 ; i<N ; i++)
            {
                st = new StringTokenizer(bfr.readLine());
                planetArr[i][0] = Integer.parseInt(st.nextToken());     //cx                
                planetArr[i][1] = Integer.parseInt(st.nextToken());     //cy
                planetArr[i][2] = Integer.parseInt(st.nextToken());     //r

                boolean st_contatin = hasContain(x1, y1, planetArr[i][0], planetArr[i][1], planetArr[i][2]);
                boolean ed_contatin = hasContain(x2, y2, planetArr[i][0], planetArr[i][1], planetArr[i][2]);
                
                // cal
                if (!(st_contatin && ed_contatin) && (st_contatin || ed_contatin))
                {
                    result++;
                }                
            }
            System.out.println(result);
        }           
    }   
    /**
     * 출발/도착점 포함 여부 반환 함수
     *
     * @param xo: [int] 출발/도착점의 x좌표
     * @param yo: [int] 출발/도착점의 y좌표
     * @param x: [int] 행성의 x좌표
     * @param y: [int] 행성의 y좌표
     * @param r: [int] 행성의 반지름
     *
     * @return [boolean] 출발/도착점 포함 여부
     */
    private static boolean hasContain(int xo, int yo, int x, int y, int r)
    {
        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) < r;
    }
}
