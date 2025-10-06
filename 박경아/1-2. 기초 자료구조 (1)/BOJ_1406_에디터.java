import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<String> text = new LinkedList<>(); // 텍스트를 받을 리스트 생성

		String[] temp = br.readLine().split("");
		
		for(int i = 0; i<temp.length; i++) {
			text.add(temp[i]);
		}// 리스트에 텍스트 입력
		
		ListIterator<String> cursor = text.listIterator(text.size()); // 커서의 위치를 표현할 ListIterator
		
		// 명령어 입력 횟수 입력
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			
			// 명령어 입력
			String[] order = br.readLine().split(" ");
			
			if(order[0].equals("L")) {
				// L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시)
				if(!cursor.hasPrevious()) {
					continue;
				}else {
					cursor.previous(); // 커서를 왼쪽으로 한 칸 옮김
				}
				
			}else if(order[0].equals("D")) {
				// D : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤면 무시)
				if(!cursor.hasNext()) {
					continue;
				}else {
					cursor.next(); // 커서를 오른쪽으로 한 칸 옮김
				}
				
			}else if(order[0].equals("B")) {
				// 커서 왼쪽에 있는 문자를 삭제 (커서가 문장의 맨 앞이면 무시)
				if(!cursor.hasPrevious()) {
					continue;
				}else {
					cursor.previous();
					cursor.remove();
				}
				
			}else if(order[0].equals("P")) {
				// order[1]의 문자를 커서 왼족에 추가함
				cursor.add(order[1]);
			}
			
		}// N번 명령을 수횅
		
		StringBuilder sb = new StringBuilder();
		
		for(String alphabet : text) {
			sb.append(alphabet);
		}
		
		System.out.println(sb);
	}// main 

}