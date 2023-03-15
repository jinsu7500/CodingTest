/************************************************************************************************/
/* 25083번 : 새싹
/************************************************************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언        
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));        
        
        bfw.write("         ,r'" + '"'+"7" + "\n");
        bfw.write("r`-_   ,'  ,/" + "\n");
        bfw.write(" \\. " + '"' + ". L_r'"     + "\n");
        bfw.write("   `~"+"\\/"+"\n");
        bfw.write("      |" + "\n");
        bfw.write("      |" + "\n");
        bfw.flush();

        
/*        
                 ,r'"7
        r`-_   ,'  ,/
         \. ". L_r'
           `~\/
              |
              |
*/
    }
}
