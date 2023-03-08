import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import LV2.ContinuousSeq;
import LV2.DeliveryBox;
import LV2.H_Index;
import LV2.HotelReservation;
import LV2.NumberCardDiv;
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
        
        DeliveryBox test = new DeliveryBox();
        int[] testcaset = {4,3,1,2,5};
        int[] testcaset2 = {5,4,3,2,1};

        System.out.println(test.solution(testcaset));
        System.out.println(test.solution(testcaset2));

    }
}
