import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //정점의 개수
		int E = sc.nextInt(); //간선의 개수
		
		int[][] edges = new int[E][3];
		for(int i = 0; i <E; i++) {
			edges[i][0] = sc.nextInt()-1;
			edges[i][1] = sc.nextInt()-1;
			edges[i][2] = sc.nextInt();
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		}); //정렬완료

		//확인완료
//		for(int[] a : edges) {
//		System.out.println(Arrays.toString(a));
//	}
		//mst를 만들어보자
		
		p = new int[V];
		
		//makeset
		for(int i = 0; i < V; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		
		//시작점의 집합과, 끝지점의 집합을 찾아주고
		for(int i = 0; i < E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			
			//만약 집합이 서로 다르다면 union을 해주고 ans에 더한다.
			if(px != py) {
				union(px, py);
				ans += edges[i][2];
			}
		}
		System.out.println(ans);
	}
	
	static int findSet(int x) {
		if(x == p[x])
			return x;
		else 
			return p[x] = findSet(p[x]);
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}