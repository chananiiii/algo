import java.util.*;
import java.io.*;

class Group {
	private int y;
	private int x;
	private int time;
	private boolean sword;

	public Group(int y, int x, int time, boolean sword) {
		this.y = y;
		this.x = x;
		this.time = time;
		this.sword = sword;
	}

	public int getY() {
		return this.y;
	}

	public int getX() {
		return this.x;
	}

	public int getTime() {
		return this.time;
	}

	public boolean getSword() {
		return this.sword;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setSword(boolean sword) {
		this.sword = sword;
	}
}

public class baekjoon_17836 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static int[][] check1 = null;
	public static int[][] check2 = null;
	public static int[][] map = null;
	public static Deque<Group> deque = null;
	public static int N = 0;
	public static int M = 0;
	public static int T = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		T = Integer.parseInt(temp[2]);
		check1 = new int[N][M];
		check2 = new int[N][M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check1[i][j] = 10001;
				check2[i][j] = 10001;
			}
		}

		deque = new ArrayDeque<Group>();
		for (int i = 0; i < N; i++) {
			String[] a = br.readLine().split(" ");
			for (int j = 0; j < a.length; j++) {
				map[i][j] = Integer.parseInt(a[j]);
			}
		}

		bfs1();
		bfs2();
		/*
		 * for(int i = 0; i < N; i ++) { for (int j = 0; j < M; j ++) {
		 * bw.write(check1[i][j] + " "); } bw.write("\n"); }
		 * 
		 * bw.write("\n");
		 * 
		 * for(int i = 0; i < N; i ++) { for (int j = 0; j < M; j ++) {
		 * bw.write(check2[i][j] + " "); } bw.write("\n"); }
		 */
		 

		int resultA = check1[N - 1][M - 1];
		int resultB = check2[N - 1][M - 1];

		if (resultA == 100001 && resultB == 100001) {
			bw.write("Fail\n");
			bw.flush();
			bw.close();
			return;
		} else {
			if (resultA == 100001 && resultB != 100001) {
				if (resultB <= T) {
					bw.write(resultB + "\n");
				} else {
					bw.write("Fail\n");
				}
			} else if (resultA != 100001 && resultB == 100001) {
				if (resultA <= T) {
					bw.write(resultA + "\n");
				} else {
					bw.write("Fail\n");
				}
			} else {
				if (Math.min(resultA, resultB) <= T) {
					bw.write(Math.min(resultA, resultB) + "\n");
				} else {
					bw.write("Fail\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}

	// 검나와도 무시
	public static void bfs1() throws IOException {
		deque.addLast(new Group(0, 0, 0, false));
		while (!deque.isEmpty()) {
			Group group = deque.pollFirst();
			int y = group.getY();
			int x = group.getX();
			int time = group.getTime();
			boolean sword = group.getSword();

			if (y - 1 > -1 && check1[y - 1][x] == 10001 && map[y - 1][x] == 1 && time + 1 <= T) {
				check1[y - 1][x] = time + 1;
				deque.addLast(new Group(y - 1, x, time + 1, sword));
			}
			// 우
			if (x + 1 < M && check1[y][x + 1] == 10001 && map[y][x + 1] != 1 && time + 1 <= T) {
				check1[y][x + 1] = time + 1;
				deque.addLast(new Group(y, x + 1, time + 1, sword));
			}
			// 하
			if (y + 1 < N && check1[y + 1][x] == 10001 && map[y + 1][x] != 1 && time + 1 <= T) {
				check1[y + 1][x] = time + 1;
				deque.addLast(new Group(y + 1, x, time + 1, sword));
			}
			// 좌
			if (x - 1 > -1 && check1[y][x - 1] == 10001 && map[y][x - 1] != 1 && time + 1 <= T) {
				check1[y][x - 1] = time + 1;
				deque.addLast(new Group(y, x - 1, time + 1, sword));
			}

		}

	}

	// 검나오면 무시X
	public static void bfs2() throws IOException {
		deque.addLast(new Group(0, 0, 0, false));

		while (!deque.isEmpty()) {
			Group group = deque.pollFirst();
			int y = group.getY();
			int x = group.getX();
			int time = group.getTime();
			boolean sword = group.getSword();

			if (map[y][x] == 2) {
				sword = true;
			}
			
			if(time > T)
				continue;

			if (sword) {
				// 상
				if (y - 1 > -1 && check2[y - 1][x] >= time + 1 && time + 1 <= T) {
					check2[y - 1][x] = time + 1;
					deque.addLast(new Group(y - 1, x, time + 1, sword));
				}
				// 우
				if (x + 1 < M && check2[y][x + 1] >= time + 1 && time + 1 <= T) {
					check2[y][x + 1] = time + 1;
					deque.addLast(new Group(y, x + 1, time + 1, sword));
				}
				// 하
				if (y + 1 < N && check2[y + 1][x] >= time + 1 && time + 1 <= T) {
					check2[y + 1][x] = time + 1;
					deque.addLast(new Group(y + 1, x, time + 1, sword));
				}
				// 좌
				if (x - 1 > -1 && check2[y][x - 1] >= time + 1 && time + 1 <= T) {
					check2[y][x - 1] = time + 1;
					deque.addLast(new Group(y, x - 1, time + 1, sword));
				}
			} else {
				// 상
				if (y - 1 > -1 && check2[y - 1][x] == 10001 && map[y - 1][x] != 1 && time + 1 <= T) {
					check2[y - 1][x] = time + 1;
					deque.addLast(new Group(y - 1, x, time + 1, sword));
				}
				// 우
				if (x + 1 < M && check2[y][x + 1] == 10001 && map[y][x + 1] != 1 && time + 1 <= T) {
					check2[y][x + 1] = time + 1;
					deque.addLast(new Group(y, x + 1, time + 1, sword));
				}
				// 하
				if (y + 1 < N && check2[y + 1][x] == 10001 && map[y + 1][x] != 1 && time + 1 <= T) {
					check2[y + 1][x] = time + 1;
					deque.addLast(new Group(y + 1, x, time + 1, sword));
				}
				// 좌
				if (x - 1 > -1 && check2[y][x - 1] == 10001 && map[y][x - 1] != 1 && time + 1 <= T) {
					check2[y][x - 1] = time + 1;
					deque.addLast(new Group(y, x - 1, time + 1, sword));
				}
			}
		}
	}
}
