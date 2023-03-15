/************************************************************************************************/
/* 10989번: 수 정렬하기3 (시간제한, 메모리제한)
/************************************************************************************************/     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();
        
        //input
        int N = Integer.parseInt(bfr.readLine());                
        int[] arr = new int[N];
    
        for(int i = 0 ; i < N ; i++)
        {            
            arr[i] = Integer.parseInt(bfr.readLine());
        }
        //sort ASC                
        Arrays.sort(arr);

        for(int i : arr)
        {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
