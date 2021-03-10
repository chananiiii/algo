package BFS;
import java.util.*;
import java.io.*;

public class baekjoon_12886 {
	public static boolean b = false;
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static boolean [][] check1 = null;
	public static boolean [][] check2 = null;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int [] rocks = new int[3];
		check1 = new boolean[1501][1501];
		check2 = new boolean[1501][1501];
		String [] temp = br.readLine().split(" ");
		
		rocks[0] = Integer.parseInt(temp[0]);
		rocks[1] = Integer.parseInt(temp[1]);
		rocks[2] = Integer.parseInt(temp[2]);
		
		bfs(rocks);
		
		if(b == true) {
			bw.write("1" + "\n");
		}
		else {
			if(rocks[0] == rocks[1] && rocks[1] == rocks[2]) {
				bw.write("1" + "\n");
			}
			else {
				bw.write("0" + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int [] rocks) throws IOException {
		if(b == true) {
			return;
		}
		
		if(check1[rocks[0]][rocks[1]] && check2[rocks[0]][rocks[1]]) {
			if(rocks[0] == rocks[1] && rocks[0]== rocks[2]) {
				b = true;
			}
			return;
		}
				
		// 왼쪽 2개비교
		// 왼쪽이 더 클때
		if(rocks[0] > rocks[1]) {
			int previousLeft = rocks[0];
			int previousRight = rocks[1];
			rocks[0] = previousLeft - previousRight;
			rocks[1] = previousRight + previousRight;	
			if(!check1[rocks[0]][rocks[1]]) {
				check1[rocks[0]][rocks[1]] = true;
				bfs(rocks);
			}
			rocks[0] = previousLeft;
			rocks[1] = previousRight;
		}
		// 오른쪽이 더 클 때
		if(rocks[0] < rocks[1]) {
			int previousLeft = rocks[0];
			int previousRight = rocks[1];
			rocks[0] = previousLeft + previousLeft;
			rocks[1] = previousRight - previousLeft;
			if(!check1[rocks[0]][rocks[1]]) {
				check1[rocks[0]][rocks[1]] = true;
				bfs(rocks);
			}
			rocks[0] = previousLeft;
			rocks[1] = previousRight;
		}
		
		// 오른쪽 2개 비교
		// 왼쪽이 더 클때
		if(rocks[1] > rocks[2]) {
			int previousLeft = rocks[1];
			int previousRight = rocks[2];
			rocks[1] = previousLeft - previousRight;
			rocks[2] = previousRight + previousRight;	
			if(!check2[rocks[1]][rocks[2]]) {
				check2[rocks[1]][rocks[2]] = true;
				bfs(rocks);
			}
			rocks[1] = previousLeft;
			rocks[2] = previousRight;
		}
		// 오른쪽이 더 클 때
		if(rocks[1] < rocks[2]) {
			int previousLeft = rocks[1];
			int previousRight = rocks[2];
			rocks[1] = previousLeft + previousLeft;
			rocks[2] = previousRight - previousLeft;	
			if(!check2[rocks[1]][rocks[2]]) {
				check2[rocks[1]][rocks[2]] = true;
				bfs(rocks);
			}
			rocks[1] = previousLeft;
			rocks[2] = previousRight;
		}
	}
	
	public static int [] copyArray(int [] a) {
		int [] copyArray = new int[3];
		for(int i = 0; i < a.length; i ++) {
			copyArray[i] = a[i];
		}
		return copyArray;
	}
}
