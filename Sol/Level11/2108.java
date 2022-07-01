//************************************************************************************************/
/* 2108번 : 통계학( 다시체크)
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] Args) throws IOException
    {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));             
        
        //input
        int N = Integer.parseInt(bfr.readLine());

        int arr[] = new int[N];

        for(int i = 0 ;i<N ; i++)
        {
            arr[i] = Integer.parseInt(bfr.readLine());
        }
        
        //output
        System.out.println(arithmeticMean(arr));
        System.out.println(medianValue(arr));
        System.out.println(mode(arr));
        System.out.println(range(arr));


    }

    //산술평균
    public static int arithmeticMean(int arr[])
    {
        int answer = 0;
        int sum = 0;

        for(int i = 0 ;i<arr.length; i++)
        {
            sum += arr[i];
        }
        answer = (int)Math.round((double)sum / arr.length);
        return answer;
    }

    //중앙값
    public static int medianValue(int arr[])
    {
        int answer = 0;
        Arrays.sort(arr);

        if(arr.length == 1)
        {
            return arr[0];
        }
        else
        {
            answer = arr[(arr.length / 2)];
            return answer;
        }        
    }

    //최빈값
    public static int mode(int arr[])
    {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int index[] = new int[8001];

        for(int i = 0; i<arr.length; i++)
        {
            answer = 4000 + arr[i];
            index[answer]++;
            
            if(max < index[answer])
            {
                max = index[answer];
            }
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < index.length ;i++)        
        {
            if(max == index[i]) 
            {
                stack.push(i);
            }
        }

        Integer list[] = new Integer[stack.size()];
        for(int i = 0 ; i < list.length; i++)
        {
            list[i] = stack.pop();
        }

        Arrays.sort(list);

        //return
        if(list.length == 1 )
        {
            return list[0] - 4000;
        }
        else
        {
            if(list[0] < list[1] && list[0] > 4000)
            {
                return list[0] - 4000;
            }
                
            else
            {
                return list[1] - 4000;
            }             

        }     
    }

    //범위
    public static int range(int arr[])
    {
        int answer = 0;
        Arrays.sort(arr);

        answer = Math.abs(arr[0] - arr[arr.length-1]);
        return answer;
    }
}
