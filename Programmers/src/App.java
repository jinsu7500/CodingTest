import java.io.*;
import java.util.StringTokenizer;

import LV2.Spy;
public class App {
    public static void main(String[] args) throws Exception {  
        // //BufferReader,BufferWriter 선언
        // BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));   

        // //Stringtokenizer
        
        // while(true){
        //     StringTokenizer st = new StringTokenizer(bfr.readLine());
        //     int firstNum = Integer.parseInt(st.nextToken(" "));
        //     int secondNum = Integer.parseInt(st.nextToken(" "));
        //     String answer = " ";
            
        //     if(firstNum == 0 && secondNum == 0) break;

        //     //factor
        //     if(secondNum % firstNum == 0)
        //         answer = "factor";
        //     //multiple
        //     else if(firstNum % secondNum == 0 )
        //         answer = "multiple";
        //     // if((secondNum % firstNum == 1) ||(firstNum % secondNum == 1))
        //     else
        //         answer = "neither";
                
        //     bfw.write(answer + "\n");
        //     bfw.flush();            
        // }
        // bfw.close();

        Spy test = new Spy();
        String[][] testCase = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] testCase2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(test.solution(testCase));
        System.out.println(test.solution(testCase2));
    }
}