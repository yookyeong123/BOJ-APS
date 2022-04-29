import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0;
		
		//factorial 입력값이 커지면 integer와 long의 범위를 넘어서 
		//biginteger로 받아주어야 한다.
		
		BigInteger big = new BigInteger("1");
		for(int i = 1; i <=N; i++) {
			big = big.multiply((BigInteger.valueOf(i)));
		}
		
		//biginteger를 문자열로 변환해서
		String s = big.toString();
		//거꾸로 읽어가면서 0의 갯수를 카운트
		//0이아니면 for문 빠져나오기
		for(int i = s.length()-1; i > 1; i--) {
			if(s.charAt(i)-'0' == 0)
				cnt++;
			else
				break;
		}
		System.out.println(cnt);
	}
}