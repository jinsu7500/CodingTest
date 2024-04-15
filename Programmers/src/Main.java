import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        // // BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));

        String output  = "";
        boolean bYN = true;

        for(;;)
        {
            Stack<Character> stack = new Stack<>();
            String inputText = bfr.readLine();
            if(inputText == ".") { break; }
            
            for(int i = 0 ; i < inputText.length(); i++)
            {
                

                char chk = inputText.charAt(i);

                if(chk == '(' || chk == '[')
                {
                    stack.push(chk);
                }
                else if (chk == ')')
                {
                    if(stack.isEmpty() || stack.peek() != '(')
                    {
                        output = "no";
                        bYN = false;
                        System.out.println(output);
                        break;
                    }
                    else
                    {
                        stack.pop();
                    }
                }
                else if (chk == ']')
                {
                    if(stack.isEmpty() || stack.peek() != '[')
                    {                        
                        output = "no";
                        bYN = false;
                        System.out.println(output);
                        break;
                    }
                    else
                    {
                        stack.pop();
                    }
                }

            }

            if(stack.isEmpty() &&  bYN == true)
            {
                output = "yes";
                break;
            }

            
            
        }
        System.out.println(output);
        
        // int size = Integer.parseInt(bfr.readLine());       
        

        // for(int i = 0 ; i < size ; i++)
        // {
        //     Stack<Character> stack = new Stack<>();
        //     String inputText = bfr.readLine();
        //     boolean bYN = true;

        //     for(int j = 0 ; j <inputText.length() ; j++)
        //     {
        //         if(inputText.charAt(j) == '(')
        //         {
        //             stack.push(inputText.charAt(j));
        //         }
        //         else if(stack.isEmpty())
        //         {
        //             bYN = false;
        //             break;
        //         }
        //         else
        //         {
        //             stack.pop();
        //         }
        //     }
        //     System.out.println(bYN && stack.isEmpty() ? "YES" :  "NO");
               
        // } 
        bfr.close();
    }
}


