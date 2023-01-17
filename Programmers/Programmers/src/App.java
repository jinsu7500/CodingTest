
import java.util.Arrays;

import LV2.Carpet;


public class App {
    public static void main(String[] args) throws Exception {       
        
        
        Carpet test = new Carpet();   

        
        System.out.println(Arrays.toString(test.solution(10, 2)));
        System.out.println(Arrays.toString(test.solution(8, 1)));
        System.out.println(Arrays.toString(test.solution(24, 24)));
        
    }
}


