import java.util.Scanner;

public class Main {
	static int[][] candy;
	static int N;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		candy = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				switch (s.substring(j, j+1)) {
				case "C": //빨강
					candy[i][j] = 1;
					break;
				case "P": //파랑
					candy[i][j] = 2;
					break;
				case "Z": //초록
					candy[i][j] = 3;
					break;
				case "Y":
					candy[i][j] = 4;
					break;
				default:
					break;
				}
			}
		}//입력완료
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//i가 마지막 줄이 아니고 j가 제일 오른쪽일때 아래만 검사
				if(i != N-1 && j == N-1) {
					int tmp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = tmp;
					
					max_search();
					
					tmp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = tmp;
				}
				//i가 마지막줄이고 j가 제일 오른쪽줄이 아닐때 오른쪽으로만 검사
				else if(i == N-1 && j != N-1) {
					int tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
					
					max_search();
					
					tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
				}
				
				//마지막칸 도착시 break
				else if (i == N - 1 && j == N - 1)
					break;
				
				//그 외의 경우엔 오른쪽, 아래 다 검사
				else {
					
					int tmp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = tmp;
					
					max_search();
					
					tmp = candy[i][j];
					candy[i][j] = candy[i+1][j];
					candy[i+1][j] = tmp;
					
					tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
					
					max_search();
					
					tmp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = tmp;
				}
			}
		}
		System.out.println(max);
	}

	private static void max_search() {
		int cnt = 1;
		//가로검사
		out: for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (candy[i][j] == candy[i][j + 1]) {
					cnt++;
					max = Math.max(max, cnt);
					if (max == N)
						break out;
				} else
					cnt = 1;
			}
		}

		cnt = 1;
		//세로검사
		out: for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (candy[j][i] == candy[j + 1][i]) {
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