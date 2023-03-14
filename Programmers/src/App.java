import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import LV2.ContinuousSeq;
import LV2.DeliveryBox;
import LV2.H_Index;
import LV2.HotelReservation;
import LV2.NumberCardDiv;
import LV2.PaintOver;
import LV2.SisoFriend;


public class App {
    public static void main(String[] args) throws Exception {  
        // //BufferReader,BufferWriter 선언
        // BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));        

        // //Stringtokenizer
        // int count = Integer.parseInt(bfr.readLine());
        // int arr[] = new int[count];
        // StringTokenizer st = new StringTokenizer(bfr.readLine());

        // //input
        // for(int i = 0 ; i<count ; i++){
        //     arr[i] = Integer.parseInt(st.nextToken(" "));
        // }

        // //sort & output
        // Arrays.sort(arr);
        // int max = arr[0];
        // int min = arr[count-1];
        // System.out.println(max*min);
        
        PaintOver test = new PaintOver();
        // int[] testcase = {1,3};
        // System.out.println(test.solution(5, 4, testcase));

        int[] testcase = {2,3,6};
        System.out.println(test.solution(8, 4, testcase));

    }
}
