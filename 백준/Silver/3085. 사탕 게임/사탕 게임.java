import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				switch (s.substring(j, j + 1)) {
				case "C": // 빨
					map[i][j] = 1;
					break;
				case "P": // 파
					map[i][j] = 2;
					break;
				case "Z": // 초
					map[i][j] = 3;
					break;
				case "Y": // 노
					map[i][j] = 4;
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != N - 1 & j == N - 1) {
					// 아래와 스왑
					int tmp = map[i][j];
					map[i][j] = map[i + 1][j];
					map[i + 1][j] = tmp;

					// 맥스값찾기
					max_search();

					// 원래대로 되돌리기
					tmp = map[i][j];
					map[i][j] = map[i + 1][j];
					map[i + 1][j] = tmp;
					continue;
				}

				else if (i == N - 1 && j != N - 1) {
					int tmp = map[i][j];
					map[i][j] = map[i][j + 1];
					map[i][j + 1] = tmp;

					max_search();

					tmp = map[i][j];
					map[i][j] = map[i][j + 1];
					map[i][j + 1] = tmp;
					continue;
				}

				else if (i == N - 1 && j == N - 1)
					break;

				int tmp = map[i][j];
				map[i][j] = map[i + 1][j];
				map[i + 1][j] = tmp;

				max_search();

				tmp = map[i][j];
				map[i][j] = map[i + 1][j];
				map[i + 1][j] = tmp;

				tmp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = tmp;

				max_search();

				tmp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = tmp;

			}

		}
		System.out.println(max);

	}

	private static void max_search() {
		int cnt = 1;
		out: for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					cnt++;
					max = Math.max(max, cnt);
					if (max == N)
						break out;
				} else
					cnt = 1;
			}
		}

		cnt = 1;

		out: for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[j][i] == map[j + 1][i]) {
					cnt++;
					max = Math.max(max, cnt);
					if (max == N)
						break out;
				} else
					cnt = 1;

			}
		}

	}
}