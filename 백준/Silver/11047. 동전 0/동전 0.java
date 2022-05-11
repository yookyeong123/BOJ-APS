import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] money = new int[N];
		for(int i =0; i < N; i++) {
			money[i] = sc.nextInt();
		}
		
		int cnt = 0;
		
		for(int i = N-1; i >=0; i--) {
			if(money[i] <= K) {
				cnt += (K/money[i]);
				K = K%money[i];
			}
		}
		System.out.println(cnt);
	}
}