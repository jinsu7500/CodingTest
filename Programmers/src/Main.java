import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// import LV2.SelfTicTactoe;
public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arrayB = new int[H+X][W+Y];
        int[][] arrayA = new int[H][W];

        //arrayB 입력
        for(int i = 0; i < H+X ; i++)
        {
            st = new StringTokenizer(bfr.readLine(), " ");
            for(int j = 0;j < W+Y ; j++)
            {
                arrayB[i][j] = Integer.parseInt(st.nextToken());
            }
        }        

        //arrayA 입력
        for(int i = 0 ; i < H ; i++)
        {
          for(int j = 0 ; j<W; j++)
          {
            if(i - X >= 0 &&  j - Y >=0)
            {
                arrayA[i][j] = arrayB[i][j] - arrayA[i-X][j-Y];
            }
            else
            {
                arrayA[i][j] = arrayB[i][j];
            }
          }
        }

        //출력
        for(int i = 0 ; i < H; i++)
        {
            for(int j = 0 ; j < W ; j++)
            {
                System.out.print(arrayA[i][j] + " ");
            }
            System.out.println();
        }
    }
}

