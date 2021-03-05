package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Pair{
	private int y;
	private int x;
	private int number;
	
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	Pair(int y, int x, int number) {
		this.y = y;
		this.x = x;
		this.number = number;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY() {
		this.y = y;
	}
	
	public void setX() {
		this.x = x;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber() {
		this.number = number;
	}
}

public class baekjoon_17141 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static ArrayList <Pair> arrayList = null;
	public static int vaNum = 0;
	public static int num = 0;
	public static int [] check = null;
	public static int min;
	public static int totalVaNum = 0;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] temp = br.readLine().split(" ");
		num = Integer.parseInt(temp[0]);
		vaNum = Integer.parseInt(temp[1]);
		int [][] map = new int[num][num];
		arrayList = new ArrayList();
		min = 100000;
		
		for(int i = 0; i < num; i ++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int j = 0;
			while(st.hasMoreTokens() ) {
				int integerTemp = Integer.parseInt(st.nextToken());
				
				if(integerTemp == 1) {
					map[i][j] = -1;
					j ++;
					continue;
				}
				
				if(integerTemp == 2) {
					arrayList.add(new Pair(i, j));
					map[i][j] = 0;
					totalVaNum ++;
					j ++;
					continue;
				}
				
				map[i][j] = integerTemp;
				j ++;
			}
		}
		
		check = new int[totalVaNum];

		combination(map, 0, arrayList.size(), vaNum);
		
		if(min == 100000) {
			bw.write("-1" + "\n");
			bw.flush();
			bw.close();
			return ;
		}
		
		bw.write(min - 1 + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void picture(int [][] map, int [] check) throws IOException {
		/*
		 * for(int i = 0; i < totalVaNum; i ++) { if(check[i] == 1) { Pair p =
		 * arrayList.get(i); map[p.getY()][p.getX()] = 2; } }
		 */
		for(int i = 0; i < num; i ++) {
			for(int j = 0; j < num; j ++) {
				bw.write(map[i][j] + " " );
			}	
			bw.write("\n");
		}	
		bw.write("\n");
		
		/*
		 * for(int i = 0; i < totalVaNum; i ++) { if(check[i] == 1) { Pair p =
		 * arrayList.get(i); map[p.getY()][p.getX()] = 0; } }
		 */
	}
	
	public static void combination(int [][] map, int start, int n, int r) throws IOException {
		if(r == 0) {
			bfs(copy(map, check));
			//picture(map, check);
		}
		else {
			for(int i = start; i < n; i ++) {
				check[i] = 1;
				combination(map, i + 1, n, r - 1);
				check[i] = 0;
			}
		}
	}
	
	public static int[][] copy(int [][] map, int []check) {
		int [][] copyMap = new int[num][num];
		for(int i = 0; i < num; i ++) {
			for(int j = 0; j < num; j ++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}
	
	public static void bfs(int [][] map) {
		Deque <Pair> deque = new ArrayDeque<Pair>(); 
		for(int i = 0; i < totalVaNum; i ++) {
			if(check[i] == 1) {
				Pair p = arrayList.get(i);
				deque.addLast(new Pair(p.getY(), p.getX(), 1));
			}
		}
		
		while(!deque.isEmpty()) {
			Pair p = deque.pollFirst();
			int y = p.getY();
			int x = p.getX();
			int number = p.getNumber();
			
			if(map[y][x] != 0) 
				continue;
			
			map[y][x] = number;
			
			// À§
			if(y - 1 > -1 && map[y - 1][x] == 0) {
				deque.addLast(new Pair(y - 1, x, number + 1));
			}
			// ¿ì
			if(x + 1 < num && map[y][x + 1] == 0) {
				deque.addLast(new Pair(y, x + 1, number + 1));
			}
			// ¾Æ·¡
			if(y + 1 < num && map[y + 1][x] == 0) {
				deque.addLast(new Pair(y + 1, x, number + 1));
			}
			// ÁÂ
			if(x - 1 > -1 && map[y][x - 1] == 0) {
				deque.addLast(new Pair(y, x - 1, number + 1));
			}
		}
		
		boolean b = true;
		int maxCount = 0;
		
		for(int i = 0; i < num; i ++) {
			for(int j = 0; j < num; j ++) {
				if(map[i][j] == 0) {
					b = false;
					break;
				}
				else {
					maxCount = map[i][j] > maxCount ? map[i][j] : maxCount;
				}
			}
			if(b == false) {
				break;
			}
		}
		
		if(b) {
			min = (min < maxCount) ? min : maxCount;
		}
	}
}
