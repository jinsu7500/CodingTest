/************************************************************************************************/
/* 8958번 : OX퀴즈
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferedReader
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                
        int n = Integer.parseInt(bfr.readLine());      
        String arr[] = new String[n];        
        for(int i=0; i<n ; i++)
        {                      
            arr[i] = bfr.readLine();
            int sum = 0;
            int count = 0;  
            for(int j=0 ; j<arr[i].length(); j++)
            {
                if(arr[i].charAt(j) == 'O')
                {
                    count++;
                    sum += count;
                }
                else
                {
                    count = 0;
                }                
            }  
            System.out.println(sum);              
        }
        
    }
}
