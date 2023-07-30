import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import LV2.pairTwoCircles;
import LV3.MergeTables;

// import LV2.SelfTicTactoe;
public class Main {
    public static void main(String[] args) throws IOException {  
    //     // //BufferReader 선언
    //     BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
    //     StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");
    //     int H = Integer.parseInt(st.nextToken());
    //     int W = Integer.parseInt(st.nextToken());
    //     int X = Integer.parseInt(st.nextToken());
    //     int Y = Integer.parseInt(st.nextToken());

    //     int[][] arrayB = new int[H+X][W+Y];
    //     int[][] arrayA = new int[H][W];

    //     //arrayB 입력
    //     for(int i = 0; i < H+X ; i++)
    //     {
    //         st = new StringTokenizer(bfr.readLine(), " ");
    //         for(int j = 0;j < W+Y ; j++)
    //         {
    //             arrayB[i][j] = Integer.parseInt(st.nextToken());
    //         }
    //     }        

    //     //arrayA 입력
    //     for(int i = 0 ; i < H ; i++)
    //     {
    //       for(int j = 0 ; j<W; j++)
    //       {
    //         if(i - X >= 0 &&  j - Y >=0)
    //         {
    //             arrayA[i][j] = arrayB[i][j] - arrayA[i-X][j-Y];
    //         }
    //         else
    //         {
    //             arrayA[i][j] = arrayB[i][j];
    //         }
    //       }
    //     }

    //     //출력
    //     for(int i = 0 ; i < H; i++)
    //     {
    //         for(int j = 0 ; j < W ; j++)
    //         {
    //             System.out.print(arrayA[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // MergeTables test = new MergeTables();
    // String[] testCase = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
    // String[] testCase2 = {"UPDATE 1 1 menu", "UPDATE 1 1 category","UPDATE category merororn"};
    // System.out.println(test.solution(testCase2));

    pairTwoCircles test = new pairTwoCircles();
    System.out.println(test.solution(2, 3));
    }
}

