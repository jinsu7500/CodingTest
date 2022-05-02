
/************************************************************************************************/
/* 1546번 : 평균
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));        

        //과목
        int n = Integer.parseInt(bfr.readLine());

        //StringTokenizer
        StringTokenizer st = new StringTokenizer(bfr.readLine()," ");       
        
        int [] arr = new int[n];        
        int max = -1; 
        double avg = 0;

        for(int i=0; i<n ; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) 
            {
                max = arr[i];
            }
            avg += arr[i];
        }             
        
        //output
        System.out.println(((avg/max)*100 ) /n);
    }
        
}
