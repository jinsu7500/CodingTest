

/************************************************************************************************/
/* 1018번: 체스판 다시 칠하기
/************************************************************************************************/     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    
    public static void main(String[] args) throws IOException {			
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        //readLine
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        //input M,N
        
        int M = Integer.parseInt(st.nextToken());   //Y
        int N = Integer.parseInt(st.nextToken());  //X
         

        //array Init
        char[][] arr = new char[M][N];
        char[][] RightChessBoardArr = new char[M][N];       
        char[][] RightChessBoardArr2 = new char[M][N];

        //arr input
        for(int i = 0 ; i< M ; i++)
        {
            String input = bfr.readLine();
            for(int j = 0 ; j<N ; j++)
            {
                arr[i][j] = (char)input.charAt(j);
            }            
        }
        
        //정답 로드
        RightChessBoardArr = initRightChessBoard(M , N , 'W');
        RightChessBoardArr2 = initRightChessBoard(M , N , 'B');
        int minCount = Integer.MAX_VALUE;
        int minCount2 = Integer.MAX_VALUE;        

        //check Board    
        //1) 세로
        for(int y = 0 ; y < M-7 ; y++)
        {
            //2) 가로
            for(int x = 0 ; x<N-7; x++)
            {
                minCount = compareChess(arr,RightChessBoardArr,x,y,minCount);
                minCount2 = compareChess(arr,RightChessBoardArr2,x,y,minCount2);               
            }
        }   
        
        //output
        System.out.println(Math.min(minCount, minCount2));
    }

    //compare chessboard
	public static int compareChess(char[][] myChess, char[][] rightChessBoard, int x, int y, int count) 
    {
		int temp = 0;
		for (int i = 0; i < 8; i++) //세로y
        {
			for (int j = 0; j < 8; j++) //가로x
            {
				if (myChess[i + y][j + x] != rightChessBoard[i][j]) 
                {
					temp++;
				}
			}
		}
		return count = Math.min(count, temp);		
	}

    //정답체스판 생성 메소드
    public static char[][] initRightChessBoard(int m , int n , char firstRoom)
    {
        char answer[][] = new char[m][n];

        //1) Is firstRoom is White?
        if(firstRoom == 'W')
        {
            //init
            // i : height , j : width
            for(int i = 0 ; i< m ; i++)
            {
                for(int j = 0; j<n ; j++)
                {
                    //even_number
                    if(i % 2 == 0)
                    {
                        //white Room(even_number)
                        if(j % 2 == 0)
                        {
                            answer[i][j] = 'W';
                        }
                        //Black Room(odd_number)
                        else
                        {
                            answer[i][j] = 'B';
                        }
                    }
                    //odd_number
                    else
                    {
                        //white Room(even_number)
                        if(j % 2 == 0)
                        {
                            answer[i][j] = 'B';
                        }
                        //Black Room(odd_number)
                        else
                        {
                            answer[i][j] = 'W';
                        }
                    }
                }
            }
        }
        //2) Is firstRoom is Black?
        else
        {
            //init
            // i : height , j : width
            for(int i = 0 ; i< m ; i++)
            {
                for(int j = 0; j<n ; j++)
                {
                    //even_number
                    if(i % 2 == 0)
                    {
                        //white Room(even_number)
                        if(j % 2 == 0)
                        {
                            answer[i][j] = 'B';
                        }
                        //Black Room(odd_number)
                        else
                        {
                            answer[i][j] = 'W';
                        }
                    }
                    //odd_number
                    else
                    {
                        //white Room(even_number)
                        if(j % 2 == 0)
                        {
                            answer[i][j] = 'W';
                        }
                        //Black Room(odd_number)
                        else
                        {
                            answer[i][j] = 'B';
                        }
                    }
                }
            }
        }        
        return answer;
    }
}
        
