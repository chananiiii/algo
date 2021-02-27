package BFS;
import java.util.*;
import java.io.*;

class Pair {
	private int y;
	private int x;
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public int getX() {
		return this.x;
	}
}

public class baekjoon_9205 {
	public static Deque <Integer> deque = null;
	public static ArrayList <Pair> tempGraph = null;
	public static ArrayList <ArrayList<Integer>> graph = null;
	public static int [] check = null;
	public static int storeNum = 0;
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		for(int i = 0; i < testcase; i ++) {
			storeNum = Integer.parseInt(br.readLine());
			deque = new ArrayDeque();
			tempGraph = new ArrayList<Pair>();
			check = new int[storeNum + 2];
			graph = new ArrayList<ArrayList<Integer>>();
			
			for(int j = 0; j < storeNum + 2; j ++) {
				graph.add(new ArrayList<Integer>());
			}
			
			String [] temp = br.readLine().split(" ");
			tempGraph.add(new Pair(Integer.parseInt(temp[1]), Integer.parseInt(temp[0])));
			for(int j = 0; j < storeNum; j ++) {
				temp = br.readLine().split(" ");
				tempGraph.add(new Pair(Integer.parseInt(temp[1]), Integer.parseInt(temp[0])));
			}
			temp = br.readLine().split(" ");
			tempGraph.add(new Pair(Integer.parseInt(temp[1]), Integer.parseInt(temp[0])));
			
			// 거리 되는 것들만 graph 생성
			for(int j = 0; j < tempGraph.size() - 1; j ++) {
				for(int jj = j + 1; jj < tempGraph.size(); jj ++) {
					Pair pair1 = tempGraph.get(j);
					Pair pair2 = tempGraph.get(jj);
					if(manhattan(pair1, pair2)) {
						graph.get(j).add(jj);
						graph.get(jj).add(j);
					}
				}
			}

			deque.addLast(0);
			check[0] = 1;
			
			if(bfs()) 
				bw.write("happy" + "\n");
			else 
				bw.write("sad" + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	public static boolean bfs() throws IOException {
		while(!deque.isEmpty()) {
			int presentNumber = deque.pollFirst();
			for(int i = 0; i < graph.get(presentNumber).size(); i ++) {
				int nextNumber = graph.get(presentNumber).get(i);
				if(check[nextNumber] != 1) {
					deque.addLast(nextNumber);
					check[nextNumber] = 1;
				}
				
				if(nextNumber == storeNum + 1)
					return true;
			}
		}
		return false;
	}
	
	public static boolean manhattan(Pair pair1, Pair pair2) {
		int distance = Math.abs(pair1.getY() - pair2.getY()) + Math.abs(pair1.getX() - pair2.getX());
		if(distance  <= 1000)
			return true;
		else
			return false;
	}
}







