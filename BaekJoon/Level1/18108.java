/************************************************************************************************/
/* 18108번 : 1998년생인 내가 태국에서는 2541년생?!
/************************************************************************************************/

//※ 불기와 서기의 차이는 543년이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        //BufferReader 선언
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //출력
        System.out.println(Integer.parseInt(bfr.readLine()) - 543);
    }
}
