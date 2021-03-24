package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back_2493 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//탑 저장
		Stack<Towel> stack = new Stack<>(); 
		int height , no;
		
		// 탑 갯수
		// 6 9 5 7 4
		int N = Integer.parseInt(br.readLine()); 
		// 탑 높이가 N개 들어옴
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력받은 탑 높이를 하나씩 체크
		for (no = 1; no <= N ; no++) {
			height = Integer.parseInt(st.nextToken());
			
			//stack 안 체크
			while(!stack.isEmpty()) {
				//비교: height(오른쪽 탑), stack.peek()(왼쪽 탑)
				if(stack.peek().height >= height) {
					System.out.print(stack.peek().no + " ");
					break;
				}
				
				// 더 낮은 탑이면 어차피 앞으로도 계속 신호를 못받으니까 삭제
				stack.pop();
			}
			
			// 맨 처음 이거나 , 위에서 작업 중 스택이 비었거나 한 경우
			if(stack.isEmpty()) {
				System.out.print(0 + " ");
			}
			stack.push(new Towel(height,no));
		}
	}
	
	static class Towel{
		int height; // 탑 높이
		int no; // 탑 번호
		
		public Towel(int height, int position) {
			this.height=height;
			this.no=position;
		}
	}
}

///*
// * 1시간 반 고민하다가
// * google에서 해법을 이해하고 여러번 숙지함!
// * */
///* Stack을 이용하면 시간 복잡도는 O(n)으로 해결 가능하고
// * 또한 Scanner을 이용하면 시간 복잡도가 커지기 때문에
// * BufferedReader을 사용해야 한다는 것을 알게 됨!
// * 
// * */
//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Back_2493 {
//	public static void main(String[] args) throws Exception {
//		Stack<int[]> stack = new Stack<>();
//		
//		//빠르게 실행하기 위해서 BufferedReader을 사용
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		// 갯수 받아오기
//		int num = Integer.parseInt(br.readLine());
//		//나머지 뒤에 있는 값을 받아옴
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		
//		for (int i = 1; i <= num; i++) {
//			// 6 9 5 7 4 순서로 받아옴
//			int value = Integer.parseInt(st.nextToken());
//			// 9일때 while을 돌게됨
//			// 5일때 들어옴
//			// 7일때도 들어옴
//			while (!stack.isEmpty()) {
//				//제일 위에 있는 거 < = 제일 큰값 
//				// 6>=9 X
//				// 9>=5 O
//				// 5>=7 X
//				if (stack.peek()[1] >= value) {
//					// 9가 있는 자리인 index : 1 이고, 2번째 자리이므로 2 출력
//					System.out.print(stack.peek()[0] + " ");
//					break;
//				}
//				//6은 pop
//				//5는 pop
//				stack.pop();
//			}
//			
//			//stack이 비어있는 경우 첫번째 , 두번째 비어 있음
//			if (stack.isEmpty()) {
//				System.out.print("0 ");
//			}
//			//1번 순서에 6 을 넣음
//			//2번 순서에 9를 넣음
//			//3번 순서에 5를 넣음
//			//....
//			stack.push(new int[] { i, value });
//		}
//	}
//}


//package com.Back;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Back_2493 {
//
//	static String input="5\r\n" + 
//			"6 9 5 7 4" ;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TopNum = sc.nextInt();
//		int [] TopHigh = new int[TopNum];
//		int [] recPoint = new int[TopNum];
//		//탑의 입력값 넣기
//		for (int i = 0; i < TopNum; i++) {
//			TopHigh[i] = sc.nextInt();
//		}
//		for (int i = TopNum-1; i > 0; i--) {
//			for (int j = i-1; j >= 0; j--) {
//				if(TopHigh[j]>TopHigh[i]) {
//					recPoint[i]=j+1;
//					break;
//				}
//			}
//		}
//
//		for (int i = 0; i < TopNum; i++) {
//			System.out.print(recPoint[i]+" ");
//		}
//	}
//
//}
