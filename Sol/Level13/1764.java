/***********************************************************************************************
1764 : 듣보잡
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 
 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

출력
듣보잡의 수와 그 명단을 사전순으로 출력한다.
************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
public class Main
{    
    public static void main(String args[]) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	                                   
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        List<String> nameList = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());        
        int M = Integer.parseInt(st.nextToken());        

        
        //듣도보도못한사람
        for(int i = 0 ; i <N ; i++)
        {
            map.put(bfr.readLine(), 1);
        }
        for(int i = 0 ; i<M ; i++)
        {
            String name = bfr.readLine();
            map.put(name, map.getOrDefault(name,0) + 1);
                if(map.get(name) == 2)
                {
                    nameList.add(name);
                }
        }
        Collections.sort(nameList);
        System.out.println(nameList.size());
        for(String s : nameList)
        {
            sb.append(s + "\n");
        }
        System.out.println(sb);
           
    }   
}
