import java.io.*;
import java.util.*;

import LV2.AssignmentProgress;
import LV2.EatTheGround;
import LV2.HailWaterThermalIntegral;
import LV2.MineCraft;
import LV3.GemsShopping;
import LV3.ReturnArmy;

// import LV2.SelfTicTactoe;
public class Main {
    public static void main(String[] args) throws IOException {  
        // // // //BufferReader 선언
        // // BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        // // int N = Integer.parseInt(bfr.readLine());

        // // HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        // // StringTokenizer st;
        // // st = new StringTokenizer(bfr.readLine()," ");
        // // for(int i = 0 ; i < N ; i++){        
        // //     int key = Integer.parseInt(st.nextToken());
        // //     map.put(key,map.getOrDefault(key, 0) + 1);           
        // // }

        // // int key2 = Integer.parseInt(bfr.readLine());
        // // int answer = map.getOrDefault(key2, 0);
        // // System.out.println(answer);     

        // BestAlbum test = new BestAlbum();
        // // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        // // int[] plays = {500, 600, 150, 800, 2500};
        // // int[] result = test.solution(genres, plays);

        // // String[] genres = {"classic", "pop", "classic", "classic"};
        // // int[] plays = {800, 600, 150, 800};
        // // int[] result = test.solution(genres, plays);
        // //answser 0,3,1

        // ReturnArmy test = new ReturnArmy();
        // int n = 3;
        // int[][] roads = {{1,2},{2,3}};
        // int[] sources = {2,3};
        // int destination = 1;

        
        
        // System.out.println(test.solution(n, roads, sources, destination));

        // HailWaterThermalIntegral test = new HailWaterThermalIntegral();
        // int[][] range = {{2,-4}};
        // double[] test_out = test.solution(5, range);
        
        // for(int i = 0; i < test_out.length ; i++){
        //     System.out.println(test_out[i]);
        // }
            GemsShopping test = new GemsShopping();
            // {"test", "19:10", "20"},
            String[] testcase = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};


            int[] answer = test.solution(testcase);
            for(int i = 0 ; i<answer.length; i++)
            {
                System.out.print(answer[i] + ",");
            }
    }
}

