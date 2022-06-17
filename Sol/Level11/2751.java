/************************************************************************************************/
/* 2751번: 수 정렬하기2 ( 시간제한)
/************************************************************************************************/     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //input
        int N = Integer.parseInt(bfr.readLine());
        //   int[] arr = new int[N];
        ArrayList<Integer> arr = new ArrayList<Integer>();
    
        for(int i = 0 ; i < N ; i++)
        {
            arr.add(Integer.parseInt(bfr.readLine()));
        }
        //sort ASC        
        Collections.sort(arr);

        for(int i : arr)
        {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
