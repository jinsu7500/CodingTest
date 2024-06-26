import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static final String CONST_PERIOD = ".";

    public static void main(String[] args) throws IOException {  
        //BufferReader 
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        
        //StringBuilder
        StringBuilder sb = new StringBuilder();

        String inputString  = "";

        while(true)
        {
            inputString = bfr.readLine();

            if(inputString.equals(CONST_PERIOD))
            {
                break;
            }

            //output
            sb.append(IsBalance(inputString)).append('\n');
            
        }
        System.out.println(sb);
    }

    public static String IsBalance(String input)
    {
        Stack<Character> stack = new Stack<>();

        //loop 
        for(int i = 0; i < input.length(); i++) {
			
			char charAt = input.charAt(i);	
			
			// push
			if(charAt == '(' || charAt == '[') {
				stack.push(charAt);
			}
			
			// pop ')'
			else if(charAt == ')') {
				
				// not balance
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}


			// pop ']'
			else if(charAt == ']') {
				
				// not balance
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
        
    }
}


