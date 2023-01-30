
/************************************************************************************************/
/* 1003번 : 피보나치 함수
/************************************************************************************************/

//문제
/*
    *피보나치함수를 호출하였을떄, 0과 1이 각각 몇번 출력되는지 구하는 프로그램을 작성하시오
*/

//입력
/**
 *  첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 *  각 테스트 케이스는 한 줄로이루어져 있고 N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
 */

 //출력
 /**
  * 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
  */

//제한사항
/**
 * 시간제한 0.25초,메모리제한 128MB
 * Scanner를 사용하면 Timeout, -> BufferReader,BufferWriter를 사용해볼것
 */

//풀이
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        //BufferReader,BufferWriter 선언
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(sc.readLine());
        int num;
        Integer[] num0 = new Integer[41];
        Integer[] num1 = new Integer[41];

        num0[0] = 1; 
        num0[1] = 0;        
        num1[0] = 0;
        num1[1] = 1;

        for(int i = 0; i<n; i++) {
            num = Integer.parseInt(sc.readLine());
            for(int j=2; j<=num; j++) {
                num0[j] = num0[j-2] + num0[j-1];
                num1[j] = num1[j-2] + num1[j-1];
            }
            sw.write(num0[num]+ " " +num1[num]+"\n");
        }
        sw.close();
        sc.close();
    }
}
