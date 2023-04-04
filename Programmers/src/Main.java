import java.io.*;
import java.util.*;

import LV2.BestAlbum;



public class Main {
    public static void main(String[] args) throws IOException {  
        // // //BufferReader 선언
        // BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        // int N = Integer.parseInt(bfr.readLine());

        // HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        // StringTokenizer st;
        // st = new StringTokenizer(bfr.readLine()," ");
        // for(int i = 0 ; i < N ; i++){        
        //     int key = Integer.parseInt(st.nextToken());
        //     map.put(key,map.getOrDefault(key, 0) + 1);           
        // }

        // int key2 = Integer.parseInt(bfr.readLine());
        // int answer = map.getOrDefault(key2, 0);
        // System.out.println(answer);     

        BestAlbum test = new BestAlbum();
        // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        // int[] plays = {500, 600, 150, 800, 2500};
        // int[] result = test.solution(genres, plays);

        // String[] genres = {"classic", "pop", "classic", "classic"};
        // int[] plays = {800, 600, 150, 800};
        // int[] result = test.solution(genres, plays);
        //answser 0,3,1


        String[] genres = {"pop", "pop", "pop", "rap", "rap"};
        int[] plays = {45, 50, 40, 60, 70};
        int[] result = test.solution(genres, plays);
        ////answer 1,0,4,3




        for(int i = 0 ; i<result.length ; i++){
            System.out.print(result[i] + ",");
        }
        
    }
}
