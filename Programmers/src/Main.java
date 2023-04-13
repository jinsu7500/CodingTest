import java.io.*;
import java.util.*;

import LV3.BannedUser;
import LV3.BestAlbum;
import LV3.BestSet;



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


        // String[] genres = {"pop", "pop", "pop", "rap", "rap"};
        // int[] plays = {45, 50, 40, 60, 70};
        // int[] result = test.solution(genres, plays);
        // ////answer 1,0,4,3

        // for(int i = 0 ; i<result.length ; i++){
        //     System.out.print(result[i] + ",");
        // }

        BannedUser test = new BannedUser();
        //testcase1
        // String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        // String[] banned_id = {"fr*d*", "abc1**"};

        //testcase2
        // String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        // String[] banned_id = {"fr*d*", "*rodo", "******", "******"};


        // System.out.println(test.solution_final(user_id, banned_id));


        BestSet bestset = new BestSet();
        // int n[] = bestset.solution(2, 9);
        int n[] = bestset.solution(3, 11);
        
        for(int i = 0; i < n.length ;i++){
            System.out.print(n[i] + ", ");
        }
       
    }
}
