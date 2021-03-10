import java.util.*;
import java.io.*;
class Pair {
	int y;
	int x;
	
	public Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public int getX() {
		return this.x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setX(int x ) { 
		this.x = x;
	}
}
public class baekjoon_1926 {
	public static int [] dx = {0, 0, -1, 1};
	public static int [] dy = {-1, 1, 0, 0};
	public static int [][] check = null;
	public static int [][] map = null;
	public static int pictureNumber = 0;
	public static int maxPicture = 0;
	public static int y = 0;
	public static int x = 0;
	public static Deque <Pair> deque = null;
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static int oneTime = 0;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] temp = br.readLine().split(" " );
		y = Integer.parseInt(temp[0]);
		x = Integer.parseInt(temp[1]);
		check = new int[y][x];
		map = new int[y][x];
		deque = new ArrayDeque();
		for(int i = 0; i < y; i ++) {
			temp = br.readLine().split(" " );
			for(int j = 0; j < x; j ++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		bfs();
		
		bw.write(pictureNumber + "\n");
		bw.write(maxPicture + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void bfs() throws IOException {
		int thisMaxPicture = 0;
		for(int i = 0; i < y; i ++) {
			for(int j = 0; j < x; j ++) {
				if(check[i][j] == 1 || map[i][j] == 0) {
					continue;
				}
				check[i][j] = 1;
				deque.addLast(new Pair(i, j));
				pictureNumber ++;
				thisMaxPicture = 1;
				maxPicture = thisMaxPicture > maxPicture ? thisMaxPicture : maxPicture;
				while(!deque.isEmpty()) {
					Pair pair = deque.pollFirst();
					int py = pair.getY();
					int px = pair.getX();
					for(int four = 0; four < 4; four++) {
						int ny = py + dy[four];
						int nx = px + dx[four];
						
						if(ny < 0 || ny >= y || nx < 0 || nx >= x) {
							continue;
						}
						
						if(check[ny][nx] == 1 || map[ny][nx] == 0) {
							continue;
						}
						
						check[ny][nx] = 1;
						deque.addLast(new Pair(ny, nx));
						thisMaxPicture ++;
						maxPicture = thisMaxPicture > maxPicture ? thisMaxPicture : maxPicture;
					} 
				}
			}
		}
	}
}
