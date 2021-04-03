import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class baekjoon_2281 {
	final static int MAX = 1001;
	final static int MIN = 987654321;
	public static int [][] cache = null;
	public static int N = 0;
	public static int M = 0;
	public static int [] len = null;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String [] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		len = new int[MAX];
		for(int i=0; i<N; i++) {
			len[i] = Integer.parseInt(br.readLine());
		}
		cache = new int[MAX][MAX];
		
		for(int i=0; i<MAX; i++) {
			for(int j=0; j<MAX; j++) {
				cache[i][j] = -1;
			}
		}
		
		bw.write(minSquareSum(len[0]+1, 1) + "\n");
		bw.flush();
	}
	
	public static int minSquareSum(int col, int cur){
	    // ���� ���: ��� �ܾ �� ��
	    if(cur == N) return 0;
	    // �ش� ���� �� ä�� ���ų� �� ĭ�� ���� ���
	    if(col >= M) return minSquareSum(len[cur]+1, cur+1) + (col==M?1:0);
	    int ret = cache[col][cur];
	    if(ret != -1) return ret;
	 
	    // ���� �ٷ� �Ű� ���鼭 ���� ������ ĭ�� ������ ����
	    ret = minSquareSum(len[cur]+1, cur+1) + (M-col+1)*(M-col+1);
	    // �ش� �ٿ� �̾ �� �� ���� ���
	    if(col+len[cur] <= M) ret = Math.min(ret, minSquareSum(col+len[cur]+1, cur+1));
	    
	    cache[col][cur] = ret;
	    
	    return ret;
	}
}
