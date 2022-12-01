/***********************************************************************************************
3053: 택시 기하학
19세기 독일 수학자 헤르만 민코프스키는 비유클리드 기하학 중 택시 기하학을 고안했다.

택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.

D(T1,T2) = |x1-x2| + |y1-y2|

두 점 사이의 거리를 제외한 나머지 정의는 유클리드 기하학에서의 정의와 같다.

따라서 택시 기하학에서 원의 정의는 유클리드 기하학에서 원의 정의와 같다.

원: 평면 상의 어떤 점에서 거리가 일정한 점들의 집합

반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 반지름 R이 주어진다. R은 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄에는 유클리드 기하학에서 반지름이 R인 원의 넓이를, 둘째 줄에는 택시 기하학에서 반지름이 R인 원의 넓이를 출력한다. 정답과의 오차는 0.0001까지 허용한다.
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
        /**
         * 유클리드 기하학의 원넓이 : PI *r^2
         * 택시 기하학의 원넓이 : 2*r^2
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
        Double R = Double.parseDouble(bfr.readLine());

        double uClid = Math.PI * Math.pow(R, 2);
        double taxi = 2 * Math.pow(R, 2);

        System.out.println(String.format("%.6f", uClid));
        System.out.println(String.format("%.6f", taxi));

    }   
}
