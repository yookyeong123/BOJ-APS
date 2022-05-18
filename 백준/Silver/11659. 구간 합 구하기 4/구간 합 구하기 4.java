import java.util.Scanner;

//헉 시간초과... -> 해결
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] num = new int[N+1];

		for (int i = 1; i <= N; i++) {
			//배열에 합을 저장해놓는다.
			num[i] = num[i-1] + sc.nextInt();
		}

		for (int j = 0; j < M; j++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			System.out.println(num[ed]-num[st-1]);
		}
	}
}