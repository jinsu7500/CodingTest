import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        int N = Integer.parseInt(bfr.readLine());

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        StringTokenizer st;
        st = new StringTokenizer(bfr.readLine()," ");
        for(int i = 0 ; i < N ; i++){        
            int key = Integer.parseInt(st.nextToken());
            map.put(key,map.getOrDefault(key, 0) + 1);           
        }

        int key2 = Integer.parseInt(bfr.readLine());
        int answer = map.getOrDefault(key2, 0);
        System.out.println(answer);     
    }
}
