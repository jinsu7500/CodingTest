/************************************************************************************************/
/* 2750번: 수 정렬하기
/************************************************************************************************/     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        
        //input
        int N = Integer.parseInt(bfr.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = Integer.parseInt(bfr.readLine());
        }
        //sort ASC
        Arrays.sort(arr);

        for(int i = 0 ; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }


    }
}
