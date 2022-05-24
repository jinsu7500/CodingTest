/************************************************************************************************/
/* 5622번 : 다이얼
/************************************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] Args) throws IOException
    {
        /**
         * 다이얼 
         * 2번 : 2초 : ABC
         * 3번 : 3초 : DEF
         * 4번 : 4초 : GHI
         * 5번 : 5초 : JKL
         * 6번 : 6초 : MNO
         * 7번 : 7초 : PQRS
         * 8번 : 8초 : TUV
         * 9번 : 9초 : WXYZ
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in)); 
        
        //입력값
        String input = bfr.readLine();
        int count=0;
        
        for(int i = 0 ; i< input.length() ; i++)
        {
            switch(input.charAt(i))
            {
                case 'A':
                case 'B':
                case 'C':
                    count += 3;
                    break;

                case 'D':
                case 'E':
                case 'F':
                    count += 4;
                    break;    

                case 'G':
                case 'H':
                case 'I':
                    count += 5;
                    break;

                case 'J':
                case 'K':
                case 'L':
                    count += 6;
                    break;

                case 'M':
                case 'N':
                case 'O':
                    count += 7;
                    break;

                case 'P': 
                case 'Q': 
                case 'R': 
                case 'S':
                    count += 8; 
                    break;
                    
                case 'T': 
                case 'U': 
                case 'V': 
                    count += 9; 
                    break;
                    
                case 'W': 
                case 'X': 
                case 'Y': 
                case 'Z': 
                    count += 10; 
                    break;                    
            }
        }
        System.out.println(count);
        
    }
}
