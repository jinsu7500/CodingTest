import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws IOException {  
        // //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));  
        BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(bfr.readLine());

        //스택생성
        MakeIntgerStack stack = new MakeIntgerStack(size);
        
        for(int i = 0 ; i< size ; i++)
        {
            String input[] = bfr.readLine().split(" ");
            
            switch (input[0]) {

                // 정수 X를 스택에 넣는다.
                case "1":  
                    stack.push(Integer.parseInt(input[1]));
                    break;
                // 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                case "2":
                    bwr.write(String.valueOf(stack.pop()) + "\n");
                    break;
                //스택에 들어있는 정수의 개수를 출력한다.
                case "3":
                bwr.write(String.valueOf(stack.getSize()) + "\n");
                    break;
                // 스택이 비어있으면 1, 아니면 0을 출력한다.
                case "4":
                    bwr.write(String.valueOf(stack.isEmpty()) + "\n");
                    break;
                //스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                case "5":
                    bwr.write(String.valueOf(stack.getTop()) + "\n");
                    break;                    
            
                default:
                    break;
            }
        }
        bwr.flush();
        bwr.close();
        bfr.close();
    }
}

class MakeIntgerStack
{
    int top;
    int size;
    int arr[];

    //생성자
    public MakeIntgerStack(int inputSize)
    {
        this.top = 0;
        this.size = 0;
        this.arr = new int[inputSize];
    }

    void push(int item)
    {
        size++;
        top++;
        arr[top] = item;        
    }
    int pop ()
    {
        if(size == 0) 
        {
			return -1;
		}else 
        {
			size--;
			int pop = arr[top];
			arr[top--] = 0;
			return pop;
		}
        
    }
    int getSize() {
		return size;
	}
	
	int isEmpty() {
		if(size == 0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	int getTop() {
		if(size == 0) {
			return -1;
		}else {
			return arr[top];
		}
	}
}

