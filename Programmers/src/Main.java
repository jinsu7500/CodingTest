import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        // BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(bfr.readLine());       
        

        for(int i = 0 ; i < size ; i++)
        {
            Stack<Character> stack = new Stack<>();
            String inputText = bfr.readLine();
            boolean bYN = true;

            for(int j = 0 ; j <inputText.length() ; j++)
            {
                if(inputText.charAt(j) == '(')
                {
                    stack.push(inputText.charAt(j));
                }
                else if(stack.isEmpty())
                {
                    bYN = false;
                    break;
                }
                else
                {
                    stack.pop();
                }
            }
            System.out.println(bYN && stack.isEmpty() ? "YES" :  "NO");
               
        } 
        bfr.close();
    }
}


