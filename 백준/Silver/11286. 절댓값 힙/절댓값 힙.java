import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			
			if(a == b) {
				//절대값이 같은 경우, 가장 작은 수
				return o1 > o2 ? 1 : -1;
			}
			return a - b;
			
		});
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if(num == 0) {
				if(pq.isEmpty()) {
					System.out.println("0");
				}
				else {
					System.out.println(pq.poll());
				}
			}
			else {
				pq.add(num);
			}
		}
	}
}