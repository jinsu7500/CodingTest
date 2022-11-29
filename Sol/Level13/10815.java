/***********************************************************************************************
10815: 숫자카드
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 
이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 
숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 
이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.

ex)
input
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10
output
1 0 0 1 1 0 0 1
************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main
{    
    public static void main(String args[]) throws IOException
    {
        /***********************************TIME OUT!!!**********************************************/
        // BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	                            
        // BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // int N = Integer.parseInt(bfr.readLine());        
        // int[] getArr = new int[N];
        

        // StringTokenizer st = new StringTokenizer(bfr.readLine());
        // for(int i = 0 ; i< N ; i++)        
        // {
        //     getArr[i] = Integer.parseInt(st.nextToken());
        // }

        // int M = Integer.parseInt(bfr.readLine());
        // int[] comArr = new int[M];
        // int[] resultArr = new int[M];

        // st = new StringTokenizer(bfr.readLine());
        // for(int i = 0; i<M ; i++)
        // {            
        //     comArr[i] = Integer.parseInt(st.nextToken());
        // }

                
        // //compare
        // for(int i = 0 ; i< M ; i++)
        // {
        //     for(int j = 0 ; j< N ; j++)
        //     {
        //         if(comArr[i] == getArr[j])
        //         {
        //             resultArr[i] = 1;                    
        //         }               
        //     }
        // }

        // //output
        // for(int i = 0 ; i< M ; i++)
        // {
        //     if(i == M-1)    bfw.write(resultArr[i]);
        //     else
        //     bfw.write(resultArr[i]+" ");
        // }
        // bfw.flush();
        // bfw.close();
        /***********************************TIME OUT!!!**********************************************/

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));	                            
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(bfr.readLine());        
        int[] getArr = new int[N];
        

        StringTokenizer st = new StringTokenizer(bfr.readLine());
        for(int i = 0 ; i< N ; i++)        
        {
            getArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(getArr);

        int M = Integer.parseInt(bfr.readLine());
        st = new StringTokenizer(bfr.readLine());
        
        for(int i = 0; i<M; i++) {
			
			int m = Integer.parseInt(st.nextToken());
			
			int first= 0;
			int last = N-1;
			boolean flag = false;
			while(first<=last) {

				int mid = (first+last)/2;
				int targetN = getArr[mid];
				 
				if(targetN==m) {
					flag = true;
					break;
				}
				
				if(targetN > m) {
					last = mid - 1;
				}
				else {
					first = mid + 1;
				}
				
			}
			if(flag) bfw.write(1 + " ");
			else bfw.write(0 + " ");
			
		}
        bfw.flush();
        bfw.close();
        bfr.close();
    }   
}
