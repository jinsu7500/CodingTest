import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import LV2.ContinuousSeq;
import LV2.H_Index;


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

        ContinuousSeq test = new ContinuousSeq();        
        int testCase[] = {7,9,1,1,4};        

        System.out.println(test.solution2(testCase));
    }
}