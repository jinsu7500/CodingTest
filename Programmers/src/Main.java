import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(bfr.readLine());
        int outputNum = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < size ; i ++)
        {
            int inputNum = Integer.parseInt(bfr.readLine());

            if(inputNum == 0 )
            {
                stack.pop();                
            }
            else
            {
                stack.push(inputNum);                
            }   
        }
        for(int number : stack)
        {
            outputNum += number;
        }
        bwr.write(String.valueOf(outputNum));
        bwr.flush();           

        
        bwr.close();
        bfr.close();
    }
}


