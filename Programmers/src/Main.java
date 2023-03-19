import java.io.*;
import java.util.*;

import LV2.EnglishFollowUp;

public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        // BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        // StringTokenizer st = new StringTokenizer(bfr.readLine()," ");

        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());

        // //arr input
        // int[] arr = new int[n];
        // for(int i = 0 ; i<n ; i++){
        //     arr[0] = i+1;
        // }

        // //{1,2,3}

        EnglishFollowUp test = new EnglishFollowUp();
        String[] testCase = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] testCase2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] testCase3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        // int[] tt = test.solution(3, testCase);
        int[] tt = test.solution(5, testCase2);
        // int[] tt = test.solution(2, testCase3);
        
        System.out.println(tt[0] + "," + tt[1]);
    
        
    }
}
