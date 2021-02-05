package com.Expert;

//�����ǹ�
//.	����(������ �� �� �ִ�.)
//*	������ ������� ��
//#	��ö�� ������� ��
//-	��(������ �� �� ����.)
//^	������ �ٶ󺸴� ����(�Ʒ��� �����̴�.)
//v	�Ʒ����� �ٶ󺸴� ����(�Ʒ��� �����̴�.)
//<	������ �ٶ󺸴� ����(�Ʒ��� �����̴�.)
//>	�������� �ٶ󺸴� ����(�Ʒ��� �����̴�.)


//���� ���� ���� ������ ������ �д�.
/* 1. map�� �Է�. �Է� �ް� ������ ��ġ ã�Ƴ���
 * 2. ��� �Է� �ޱ�
 * 3. ��ɾ� ���뿡 ���� ����
 * 	3-1. �̵�(UDLR)
 *  3-2. SHOOT
 * */
import java.util.Scanner;

public class Expert_1873 {
	// �� , �� , �� , ��
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int H,W;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T; tc++) {
			//1.MAP�� ũ�� �Է�
			H = sc.nextInt();
			W = sc.nextInt();
			char[][] map = new char[H][W];
			
			//������ ��ǥ�����ϴ� �迭
			int [] tank = new int[2];
			
			//�Է�
			for (int i = 0; i < H; i++) {
				//�� �࿡ �Է��� ��
				map[i] = sc.next().toCharArray();
				for (int j = 0; j < map[i].length; j++) {
					switch (map[i][j]) {
					case '<':
					case '>':
					case '^':
					case 'v':
						tank[0] = i;
						tank[i] = j;
						break;
					
					}
				}
			} // �Է� �Ϸ� , ���� ã�� �Ϸ�
				
			//��� ������ ������ �Է�
			int N = sc.nextInt(); //23
			String command = sc.next();
			
			for (int i = 0; i < N; i++) {
				char c = command.charAt(i); // ��ɾ� �ѱ���
				switch (c) {
					case 'U': {//��
						map[tank[0]][tank[1]]='^'; // ���� ��ȯ
						move(map, tank, 0);
						break;
					}
					case 'D': {//��
						map[tank[0]][tank[1]]='v'; // ���� ��ȯ
						move(map, tank, 1);
						break;
					}
					case 'L': {//��
						map[tank[0]][tank[1]]='<'; // ���� ��ȯ
						move(map, tank, 2);
						break;
					}
					case 'R': {//��
						map[tank[0]][tank[1]]='>'; // ���� ��ȯ
						move(map, tank, 3);
						break;
					}
					case 'S': {//��
						shoot(map,tank);
						break;
					}
				}//switch
			}//for
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.println(map[i][j]);
				}
			}
		}
		
	}//main
	
	private static void shoot(char[][] map, int[] tank) {
		int dir = 0;
		
		//map[tank[0]][tank[1]] <- '^','v','<','>'
		//1. ���� ������ ���⿡ ���� �� �������� ���� ��
		switch (map[tank[0]][tank[1]]) {
		case '<':
			dir=0;
			break;
		case '>':
			dir=1;
			break;
		case '^':
			dir=2;
			break;
		case 'v':
			dir=3;
			break;
		}
		
		//2. ������ ���� ��ġ
		int tx = tank[0];
		int ty = tank[1];
		
		//3. ������ ������ ��ź�� ��� �̵��ϸ鼭 �����
		while(true) {
			//3-1 ��ź�� ���ư� �� ��ǥ
			tx = tx + dx[dir];
			ty = ty + dy[dir];
			
			//3-2 ����ǥ�� ��ȿ�� üũ
			if(tx < 0 || ty < 0 || tx>=H || ty >=W) return;
			
			//3-3 �������� ���(������ �ٲ�)
			if(map[tx][ty] == '*') {
				map[tx][ty]= '.'; // ������ �ٲٰ�
				return;
			}else if(map[tx][ty] == '#') {//3-4 ��ö���� ���(�׳� ��)
				return;
			}
		}
	}
	
	//������ ������ �� ��ǥ�� ���� �̵�
	private static void move(char[][]map,int[] tank, int dir) {
		// ������ ������ �̹� �ٲٰ� ����
		// 1. ������ �̵��� �������� �� ��ǥ ���
		int nx = tank[0] + dx[dir]; // ���� ������ x ��ǥ
		int ny = tank[1] + dy[dir]; // ���� ������ y ��ǥ
		
		// 2. ����ǥ�� ��ȿ�� üũ
		if(nx < 0 || ny < 0 || nx>=H || ny >=W) return;
		
		// 3. �̵� ����(�����̾�߸� ����)
		if(map[nx][ny] == '.') {
			//3.1. �� ��ġ�� ������ �̵���Ŵ
			map[nx][ny] = map[tank[0]][tank[1]];
			//3.2. ���� ������ �ִ� �ڸ��� ������ �ٲ�
			map[tank[0]][tank[1]]='.';
			//3.3. ������ ��ǥ ����
			tank[0]=nx;
			tank[1]=ny;
		}
	}

}



//package com.Expert;
//
////�����ǹ�
////.	����(������ �� �� �ִ�.)
////*	������ ������� ��
////#	��ö�� ������� ��
////-	��(������ �� �� ����.)
////^	������ �ٶ󺸴� ����(�Ʒ��� �����̴�.)
////v	�Ʒ����� �ٶ󺸴� ����(�Ʒ��� �����̴�.)
////<	������ �ٶ󺸴� ����(�Ʒ��� �����̴�.)
////>	�������� �ٶ󺸴� ����(�Ʒ��� �����̴�.)
//
//import java.util.Scanner;
//
//public class Expert_1873 {
//	static String input="2\r\n" + 
//			"3 7\r\n" + 
//			"***....\r\n" + 
//			"*-..#**\r\n" + 
//			"#<.****\r\n" + 
//			"23\r\n" + 
//			"SURSSSSUSLSRSSSURRDSRDS\r\n"+
//			"3 7\r\n" + 
//			"***..*.\r\n" + 
//			"*-..#.*\r\n" + 
//			"#<.**.*\r\n" + 
//			"23\r\n" + 
//			"SURSSSSUSLSRSSSURRDSRDS";
//			
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TestCase = sc.nextInt();
//
//		for (int tc = 1; tc <= TestCase; tc++) {
//			int Height = sc.nextInt();
//			int Width = sc.nextInt();
//
//			char [][] Map = new char[Height][Width];
//			for (int i = 0; i < Map.length; i++) {
//				Map[i]=sc.next().toCharArray();
//			}
//			
//			int NowX = 0;
//			int NowY = 0;
//			
//			//���� ��ġ ã��
//			for (int i = 0; i < Height; i++) {
//				for (int j = 0; j < Width; j++) {
//					if(Map[i][j]=='^'||Map[i][j]=='v'||Map[i][j]=='<'
//							||Map[i][j]=='>') {
//						NowX = i;
//						NowY = j;
//						break;
//					}
//				}
//			}
//			
//			// ��ɼ��� ��� �޾ƿ���
//			int ComNum = sc.nextInt();
//			String Command = sc.next();
//			//ź ��ġ
//			int ShootX=0;
//			int ShootY=0;
//			
//			for (int i = 0; i < ComNum; i++) {
//				if(Command.charAt(i)=='U') {
//					Map[NowX][NowY]='^';
//					if(NowX-1>=0 && Map[NowX-1][NowY]=='.') {
//						Map[NowX][NowY]='.';
//						NowX=NowX-1;
//						Map[NowX][NowY]='^';
//					}
//					continue;
//				}else if(Command.charAt(i)=='D') {
//					Map[NowX][NowY]='v';
//					if(NowX+1<Height&&Map[NowX+1][NowY]=='.') {
//						Map[NowX][NowY]='.';
//						NowX=NowX+1;
//						Map[NowX][NowY]='v';
//					}
//					continue;
//				}else if(Command.charAt(i)=='L') {
//					Map[NowX][NowY]='<';
//					if(NowY-1>=0&&Map[NowX][NowY-1]=='.') {
//						Map[NowX][NowY]='.';
//						NowY=NowY-1;
//						Map[NowX][NowY]='<';
//					}
//					continue;
//				}else if(Command.charAt(i)=='R') {
//					Map[NowX][NowY]='>';
//					if(NowY+1<Width&&Map[NowX][NowY+1]=='.') {
//						Map[NowX][NowY]='.';
//						NowY=NowY+1;
//						Map[NowX][NowY]='>';
//					}
//					continue;
//				}else if(Command.charAt(i)=='S') {
//					ShootX=NowX;
//					ShootY=NowY;
//					if(Map[NowX][NowY]=='^') {
//						while(true) {
//							ShootX--;
//							if(ShootX<0 || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}else if(Map[NowX][NowY]=='v') {
//						while(true) {
//							ShootX++;
//							if(ShootX>=Height || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}else if(Map[NowX][NowY]=='<') {
//						while(true) {
//							ShootY--;
//							if(ShootY<0 || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}else if(Map[NowX][NowY]=='>') {
//						while(true) {
//							ShootY++;
//							if(ShootY>=Width || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}
//				}
//			}
//			
//			System.out.print("#"+tc+" ");
//			for (int i = 0; i < Height; i++) {
//				for (int j = 0; j < Width; j++) {
//					System.out.print(Map[i][j]);
//				}
//				System.out.println();
//			}
//		}
//	}
//
//}
