import java.util.*;
import java.io.*;

class q {
	int start;
	int end;
	int weight;
	
	public q(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class baekjoon_11657 {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static q [] graph = null;
	public static long [] dist = null;
	public static long INF = 987654321;

	public static void main(String [] args) throws IOException { 
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dist = new long[N + 1];
		graph = new q[M + 1];
		
		for(int i=1; i<=N; i++) {
			dist[i] = INF;
		}
		dist[1] = 0;
		
		for(int i=1; i<=M; i++) {
			String [] temp = br.readLine().split(" ");
			
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			
			graph[i] = new q(a, b, c);
		}
		
        for(int i=1; i<N; i++) {
            for(int j=1; j<=M; j++) {
                if(dist[graph[j].start] != INF) {
                	dist[graph[j].end] = Math.min(dist[graph[j].end], dist[graph[j].start] + graph[j].weight);
                }
            }
        }
        
        boolean check = false;
        for(int i=1; i<=M; i++) {
            if(dist[graph[i].start] != INF && dist[graph[i].end] > dist[graph[i].start] + graph[i].weight) {
                check = true;
                break;
            }
        }
        
        if(check)
            System.out.println(-1);
        else {
            for(int i=2; i<=N; i++) {
                if(dist[i] == INF)
                    System.out.println("-1");
                else
                    System.out.println(dist[i]);
            }
        }
	}
}
