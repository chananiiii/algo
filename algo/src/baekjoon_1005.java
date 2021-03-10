import java.util.*;
import java.io.*;

class B {
	public B (int y, int x) {
		this.present = y;
		this.next = x;
	}
	public int present;
	public int next;
}
public class baekjoon_1005 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static ArrayList <Integer> [] map = null;
	public static void main(String [] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t ++) {
			String [] temp = br.readLine().split(" ");
			int N = Integer.parseInt(temp[0]);
			int K = Integer.parseInt(temp[1]);
			
			int [] time = new int[N];
			int [] node = new int[N];
			int [] result = new int[N];
			
			temp = br.readLine().split(" ");
			ArrayList <Integer> [] map = new ArrayList[N];
			for(int j = 0; j < N; j ++) {
				time[j] = Integer.parseInt(temp[j]);
				map[j] = new ArrayList<>();
			}
			
			int s,e;
			for(int j = 0; j < K; j ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				
				map[s-1].add(e - 1);
				node[e - 1] ++;
			}
			
            Queue<Integer> qu = new LinkedList<>();
            for(int i=0; i<N; i++) {
                if(node[i] == 0) {
                    result[i] = time[i];
                    qu.add(i);
                }
            }

            for(int i=0; i<N; i++) {
                int b = qu.poll();

                for(int index : map[b]) {
                    result[index] = Math.max(result[index], time[index] + result[b]);
                    if(--node[index] == 0){
                        qu.add(index);
                    }
                }
            }
			
			bw.write(result[Integer.parseInt(br.readLine())-1] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
