import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import LV2.ContinuousSeq;
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

        HotelReservation test = new HotelReservation();                           
        String testcase[][] = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String testcase2[][] = {{"09:10", "10:10"},{"10:20","12:20"}};
        String testcase3[][] = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        String testcase4[][] = {{"16:00", "16:10"},{"16:20","16:30"},{"16:53","16:55"}};
        


        // System.out.println(test.solution(testcase));
        // System.out.println(test.solution(testcase2));
        // System.out.println(test.solution(testcase3));
        System.out.println(test.solution(testcase4));
    }
}