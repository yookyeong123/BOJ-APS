import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//숫자를 입력받는다
		int num = sc.nextInt();
		List<String> list = new ArrayList<String>();
		

		for(int i = 0; i < num; i++) {
			list.add(sc.next());
		}
		
		Collections.sort(list);
		
		for(int i = 1; i<=50;i++) {
			for(int j = 0; j < list.size();) {
				
				if(list.get(j).length() == i) {
					System.out.println(list.get(j));
					list.removeAll(Arrays.asList(list.get(j)));
				}
				else
					j++;
			}
			if(list.isEmpty()) break;
		}
		
	}
}
