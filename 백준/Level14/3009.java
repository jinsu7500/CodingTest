/***********************************************************************************************
3009 : 4번째 점
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.
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

        int[][] squarePoints = new int[3][2];

        for(int i = 0 ; i<3; i++)
        {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            for(int j = 0 ; j <2; j++)
            {
                squarePoints[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        if(squarePoints[0][0] == squarePoints[1][0])
            System.out.print(squarePoints[2][0]);
        else if(squarePoints[1][0] == squarePoints[2][0])
            System.out.print(squarePoints[0][0]);
        else
            System.out.print(squarePoints[1][0]);   
            
        System.out.print(" ");

        if(squarePoints[0][1] == squarePoints[1][1])
            System.out.println(squarePoints[2][1]);
        else if(squarePoints[1][1] == squarePoints[2][1])
            System.out.println(squarePoints[0][1]);
        else
            System.out.println(squarePoints[1][1]);   

    }   
}
