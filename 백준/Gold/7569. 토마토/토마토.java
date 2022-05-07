import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pos {
		int r, c, z;

		public Pos(int z, int r, int c) {
			this.z = z;
			this.r = r;
			this.c = c;
		}
	}

	static int[][][] box; // 박스배열
	static int N, M, H; // N -세로 M - 가로 H - 높이입력은 M부터 주어진다.
	static int ans;
	static Queue<Pos> queue;
	static int[] dr = { -1, 0, 1, 0, 0, 0 };// 상하좌우위아래
	static int[] dc = { 0, 1, 0, -1, 0, 0 };// 상하좌우위아래
	static int[] dz = { 0, 0, 0, 0, 1, -1 };// 상하좌우위아래

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		box = new int[H][N][M];
		queue = new LinkedList<Pos>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					box[i][j][k] = sc.nextInt();
					if (box[i][j][k] == 1) {
						queue.add(new Pos(i, j, k));
					}
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			for (int d = 0; d < 6; d++) {
				int nr = p.r + dr[d]; //세로
				int nc = p.c + dc[d]; //가로
				int nz = p.z + dz[d]; //면

				if (nr >= 0 && nc >= 0 && nz >= 0 && nr < N && nc < M && nz < H) {
					if (box[nz][nr][nc] == 0) {
						queue.add(new Pos(nz, nr, nc));
						box[nz][nr][nc] = box[p.z][p.r][p.c] + 1;
					}
				} // end if
			} // end for 사방탐색
		} // end while

		ans = Integer.MIN_VALUE;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					// 끝까지 돌렸는데도 0인게있으면(안익은게 있으면) -1을 출력
					if (box[i][j][k] == 0)
						return -1;
					// 가장 큰 값으로 갱신해주기
					ans = Math.max(ans, box[i][j][k]);
				}
			}
		}
		// 처음부터 토마토가 다 익어서 더 익을게 없는상태라면, 0일
		if (ans == 1)
			return 0;
		// 1부터 시작했으므로 최종 값에서 1을 빼주기.
		else
			return ans - 1;
	}
}