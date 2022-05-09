import java.io.IOException;
public class Main
{    
    public static void main(String[] args) throws IOException
    {
        boolean[] chk = new boolean[10001];
        for(int i = 1 ; i< 10001 ; i++)
        {
            int n = SelfNum(i);

            if(n < 10001)
            {
                chk[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        
		for (int i = 1; i < 10001; i++) 
        {
			if (!chk[i]) 
            {	
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
    
    
    public static int SelfNum(int N)
    {
        int sum = N;
        while(N != 0)
        {
            sum = sum + (N % 10);
            N = N/10;
        }
        return sum;
    }
}
