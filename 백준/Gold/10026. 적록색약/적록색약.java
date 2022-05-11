import java.util.Scanner;

public class Main {
	static int[][] map, grmap;
	static boolean[][] visited, grvisited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, cnt, grcnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];
		grmap = new int[N][N];
		visited = new boolean[N][N];
		grvisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == 'R') { // 빨강 일반맵 - 2, 색약맵 - 1
					map[i][j] = 2;
					grmap[i][j] = 1;
				} else if (s.charAt(j) == 'G') {// 초록 일반맵 - 1 색약맵 - 1
					map[i][j] = 1;
					grmap[i][j] = 1;
				} else if (s.charAt(j) == 'B') { // 파랑 일반맵 - 0 색약맥 - 0
					map[i][j] = 0;
					grmap[i][j] = 0;
				}
			}
		}
		cnt = 0;
		grcnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					if (!visited[i][j] && map[i][j] == k) {
						dfs(i, j, k);
						cnt++;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					if (!grvisited[i][j] && grmap[i][j] == k) {
						grdfs(i, j, k);
						grcnt++;
					}
				}
			}
		}
		System.out.println(cnt + " " + grcnt);
	}

	private static void grdfs(int x, int y, int color) {
		grvisited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (!grvisited[nr][nc] && grmap[nr][nc] == color) {
					grdfs(nr, nc, color);
				}
			}
		}
	}

	private static void dfs(int x, int y, int color) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (!visited[nr][nc] && map[nr][nc] == color) {
					dfs(nr, nc, color);
				}
			}
		}

	}

}