
/************************************************************************************************/
/* 10757번 : 큰수 A+B
/************************************************************************************************/

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		BigDecimal big_A = new BigDecimal(st.nextToken());
		BigDecimal big_B = new BigDecimal(st.nextToken());

		System.out.println(big_A.add(big_B));

	}
}
