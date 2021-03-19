import java.util.*;
import java.io.*;

class p {
	int y;
	int x;
	int wall;
	public p(int y, int x, int wall) {
		this.y = y;
		this.x = x;
		this.wall = wall;
	}
}

public class baekjoon_1261 {
	public static int [] dx = {0, 0, -1, 1};
	public static int [] dy = {-1, 1, 0, 0};
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static void main(String [] args) throws IOException {
		int wallBreakNumber = 100001;
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque <p> deque = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[y][x];
		int [][] check = new int[y][x];
		
		for(int i=0; i<y; i++) {
			String s = br.readLine();
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1));
				check[i][j] = 100001;
			}
		}
		
		// bfs
		check[0][0] = 0;
		deque.addLast(new p(0, 0, 0));
		while(!deque.isEmpty()) {
			p pair = deque.pollFirst();
			int px = pair.x;
			int py = pair.y;
			int pwall = pair.wall;
			
			if(py == y-1 && px == x-1) {
				wallBreakNumber = Math.min(pwall, wallBreakNumber);
			}
			
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
								
				if(ny < 0 || ny >= y || nx < 0 || nx >= x) {
					continue;
				}
				
				if(check[ny][nx] <= pwall + 1) {
					continue;
				}
				
				if(map[ny][nx] == 1) {
					check[ny][nx] = pwall + 1;
					deque.addLast(new p(ny, nx, pwall + 1));
					continue;
				}
				
				if(map[ny][nx] == 0) {
					check[ny][nx] = pwall + 1;
					deque.addLast(new p(ny, nx, pwall));
					continue;
				}
			}
		}
		
		bw.write(wallBreakNumber + "\n");
		bw.flush();
		bw.close();
	}
}
