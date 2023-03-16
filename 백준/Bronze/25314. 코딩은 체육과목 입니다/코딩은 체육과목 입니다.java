import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bfr.readLine());
        n = n/4;
        for(int i = 0 ; i<n ; i++){
            System.out.print("long ");
        }
        System.out.print("int");
        
    }
}