import java.util.Scanner;

public class Main {
	static long[] dp;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			dp = new long[N + 1];
			System.out.println(dp(N));
		}
	}

	private static long dp(int n) {
		if (n >= 1) {
			dp[1] = 1;
		}
		if (n >= 2) {
			dp[2] = 1;
		}
		if (n >= 3) {
			dp[3] = 1;
		}
		for (int i = 4; i < N + 1; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}
}